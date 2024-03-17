package org.efs.demo;
import static org.efs.demo.HelloApplication.*;

public class Lokasyon implements Cloneable {

    private int X;
    private int Y;
    static int [][] KORDINATLAR = new int[KARE_YUKSEKLIK][KARE_GENISLIK];

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
                KORDINATLAR[i][j] = 0;
            }
        }
    }
    public void HareketliEngelKordinatYaz(int boy, int genislik, int solUstKordinatX, int solUstKordinatY, int hareketBoyutu, String hareketYonu) {

        int x1 = solUstKordinatX - 1;
        int x2 = solUstKordinatX + genislik - 2;
        int y1 = solUstKordinatY - 1;
        int y2 = solUstKordinatY + boy - 2;

        switch (hareketYonu) {

            case "X":

                for (int i = y1; i <= y2; i++) {
                    for (int j = x1; j <= x2; j++) {
                        KORDINATLAR[i][j] = 3;
                        for (int k = 1; k <= hareketBoyutu; k++) {
                            KORDINATLAR[i][j - k] = 3;
                            KORDINATLAR[i][j + k] = 3;


                        }

                    }
                }

                break;
            case "Y":


                for (int i = y1; i <= y2; i++) {
                    for (int j = x1; j <= x2; j++) {
                        KORDINATLAR[i][j] = 3;
                        for (int k = 1; k <= hareketBoyutu; k++) {
                            KORDINATLAR[i - k][j] = 3; // Üstteki hareketli engel
                            KORDINATLAR[i + k][j] = 3; // Altındaki hareketli engel

                        }
                    }
                }
                break;
        }
    }

    public void HareketsizEngelYazKordinatYaz(int boy,int genislik,int solUstKordinatX,int solUstKordinatY) {

        int x1 = solUstKordinatX - 1;
        int x2 = solUstKordinatX + genislik - 2;
        int y1 = solUstKordinatY - 1;
        int y2 = solUstKordinatY + boy - 2;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                KORDINATLAR[i][j] = 3;
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
                KORDINATLAR[i][j] = 3;
            }
        }
    }
    public void HaritaMatrisYazdir(){

        for (int i = 0;i<KARE_YUKSEKLIK;i++){
            for (int j = 0;j<KARE_GENISLIK;j++){
                System.out.print(KORDINATLAR[i][j]);
            }
            System.out.println();
        }
    }

    public int Kontrol(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y4; j++) {
                if (KORDINATLAR[j][i] != 1) {
                    return -1;
                }
            }
        }
        return 1;
    }

    public void MatrisiBirle(){
        for (int i = 0;i<KARE_YUKSEKLIK;i++){
            for (int j = 0;j<KARE_GENISLIK;j++){
                KORDINATLAR[i][j] = 1;
            }
        }

    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
