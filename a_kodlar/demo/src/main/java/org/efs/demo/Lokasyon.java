package org.efs.demo;
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

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public void KordinatSifirla(){
        for (int i = 0; i < KARE_GENISLIK; i++) {
            for (int j = 0; j < KARE_GENISLIK; j++) {
                KORDINATLAR[i][j] = 0 ;
            }
        }
    }

    public void KarakterKordinatYaz(int boy,int genislik,int solUstKordinatX,int solUstKordinatY){

        int x1 = solUstKordinatX- 1;
        int x2 = solUstKordinatX + genislik -2;
        int y1 = solUstKordinatY -1;
        int y2 = solUstKordinatY + boy -2 ;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                KORDINATLAR[i][j] = 1 ; // Her bir koordinata 3 değeri atanır
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
                KORDINATLAR[i][j] = 5 ; // Her bir koordinata 3 değeri atanır
            }
        }

    }
    public void HareketliEngelKordinatYaz(){
        //Hareketten mütevellit sıkıtı çıkacak

    }
    public void HareketsizEngelYazKordinatYaz(int boy,int genislik,int solUstKordinatX,int solUstKordinatY){

        int x1 = solUstKordinatX- 1;
        int x2 = solUstKordinatX + genislik -2;
        int y1 = solUstKordinatY -1;
        int y2 = solUstKordinatY + boy -2 ;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                KORDINATLAR[i][j] = 3 ; // Her bir koordinata 3 değeri atanır
            }
        }

    }
    public void HareketsizEngelKisKordinatYaz(int boy,int genislik,int solUstKordinatX,int solUstKordinatY){
                                 2           2               12                 5       30*30
        int x1 = solUstKordinatX- 1;
        int x2 = solUstKordinatX + genislik -2;
        int y1 = solUstKordinatY -1;
        int y2 = solUstKordinatY + boy -2 ;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                KORDINATLAR[i][j] = 4; // Her bir koordinata 3 değeri atanır
            }
        }

    }

}
