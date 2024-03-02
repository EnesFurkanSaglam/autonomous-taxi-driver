package org.efs.demo;
import java.util.ArrayList;

import static org.efs.demo.HelloApplication.*;

public class Lokasyon {
        // Kodinatlar sol üsten itibaren yazılıyor

    /*

    LOKASYON İÇİN NOT:
    0-Boş Yerler
    1-Karakter
    2-Harketli Engel
    3-HareketsizEngelYaz
    4-HareketsizEngelKis
    5-Hazine

     */

    private int X;
    private int Y;
    private int [][] KORDINATLAR = new int[KARE_YUKSEKLIK][KARE_GENISLIK];


    public void KarakterKordinatYaz(int boy,int genislik,int solUstKordinatX,int solUstKordinatY){

        int x1 = solUstKordinatX- 1;
        int x2 = solUstKordinatX + genislik -2;
        int y1 = solUstKordinatY -1;
        int y2 = solUstKordinatY + boy -2 ;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                KORDINATLAR[i][j] = 1;
            }
        }

    }

    public void HazineKordinatYaz(int boy,int genislik,int solUstKordinatX,int solUstKordinatY){

        int x1 = solUstKordinatX- 1;
        int x2 = solUstKordinatX + genislik -2;
        int y1 = solUstKordinatY -1;
        int y2 = solUstKordinatY + boy -2 ;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                this.KORDINATLAR[i][j] = 5 ;
            }
        }

    }
    public void HareketliEngelKordinatYaz(){
        //Hareketten mütevellit sıkıtı çıkacak

    }
    public void HareketsizEngelYazKordinatYaz(int boy,int genislik,int solUstKordinatX,int solUstKordinatY) {

        int x1 = solUstKordinatX - 1;
        int x2 = solUstKordinatX + genislik - 2;
        int y1 = solUstKordinatY - 1;
        int y2 = solUstKordinatY + boy - 2;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                this.KORDINATLAR[i][j] = 3;
            }
        }
    }

    public void HareketsizEngelKisKordinatYaz(int boy,int genislik,int solUstKordinatX,int solUstKordinatY){

        int x1 = solUstKordinatX- 1;
        int x2 = solUstKordinatX + genislik -2;
        int y1 = solUstKordinatY -1;
        int y2 = solUstKordinatY + boy -2 ;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                this.KORDINATLAR[i][j] = 4;
            }
        }


    }
    public void HaritaMatrisYazdir(){

        for (int i = 0;i<KARE_YUKSEKLIK;i++){
            for (int j = 0;j<KARE_GENISLIK;j++){
                System.out.print(this.KORDINATLAR[i][j]);
            }
            System.out.println();
        }
    }


    public int Kontrol(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y4; j++) {
                if (this.KORDINATLAR[j][i] != 0) {
                    return -1;
                }
            }
        }

        return 1;
    }


}
