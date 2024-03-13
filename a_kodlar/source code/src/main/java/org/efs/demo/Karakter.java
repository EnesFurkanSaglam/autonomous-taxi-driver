package org.efs.demo;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.efs.demo.Hazine.hazineArrayListYedek;
import static org.efs.demo.Hazine.hazineImageViews;
import static org.efs.demo.HelloApplication.*;
import static org.efs.demo.HelloApplication.KARE_YUKSEKLIK;
import static org.efs.demo.Kordinat.kordinatArrayListKarakter;

public class Karakter {


    // sıkıntı varvvvvvvvvvvvv

/*
    Bu sınıfta bulunması gereken özellikler ve fonksiyonlar:

ID, Ad bilgileri tutulmalıdır.
Karakterlerin ilerlediği koordinatları tutacak Lokasyon değişkenleri olmalıdır.
Constructor, Get, Set ve En KısaYol metotları yer almalıdır.

NOT: Karakter çapraz gidemez. Sadece sağ, sol, yukarı ya da aşağı yönde hareket sağlayabilir.

 */

    public Karakter(int ID, String ad, String imagePath, int ilkKonumX, int ilkKonumY,int genislik,int boy) {
        this.setID(ID);
        this.setAd(ad);
        this.setImagePath(imagePath);
        this.setIlkKonumX(ilkKonumX);
        this.setIlkKonumY(ilkKonumY);
        this.genislik = genislik;
        this.boy = boy;
    }

    private int ID;
    private String ad;
    private String imagePath;
    private int boy;
    private int genislik;
    private int ilkKonumX;
    private int ilkKonumY;
    static ImageView imageViewKarakter;


    static Karakter karakter = new Karakter(1,"doblo.png","file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Karakter/",
            0,0,1,1);




    public static void KarakterOlustur(Lokasyon lokasyon, Group root){

        imageViewKarakter =null;


        int kontrol;



            while (true){

                Random random = new Random();



                int engelX;
                int engelY;

                do {

                    engelX = random.nextInt(KARE_GENISLIK);

                } while (!(engelX + karakter.getGenislik() < KARE_GENISLIK));

                do {

                    engelY = random.nextInt(KARE_YUKSEKLIK);

                } while (!(engelY + karakter.getBoy() < KARE_YUKSEKLIK));

                int x1 = engelX;
                int x2 = engelX + karakter.getGenislik() - 1;
                int x3 = engelX + karakter.getGenislik() - 1;
                int x4 = engelX;

                int y1 = engelY;
                int y2 = engelY;
                int y3 = engelY + karakter.getBoy() - 1;
                int y4 = engelY + karakter.getBoy() - 1;

                kontrol = lokasyon.Kontrol(x1, x2, x3, x4, y1, y2, y3, y4); // 1 ise devam -1 ise başa dön

                if (kontrol == 1) {

                    karakter.setIlkKonumX(engelX);
                    karakter.setIlkKonumY(engelY);

                    lokasyon.KarakterKordinatYaz(karakter.getBoy(), karakter.getGenislik()
                            ,karakter.getIlkKonumX() + 1, karakter.getIlkKonumY() + 1);



                    break;
                }

            }



        Image imageKarakter = new Image(karakter.imagePath + karakter.ad);
        imageViewKarakter = new ImageView(imageKarakter);

        imageViewKarakter.setFitWidth(KARE_BOYUTU * karakter.genislik);
        imageViewKarakter.setFitHeight(KARE_BOYUTU * karakter.boy);
        imageViewKarakter.setX(karakter.getIlkKonumX() * KARE_BOYUTU);
        imageViewKarakter.setY(karakter.getIlkKonumY() * KARE_BOYUTU);


        root.getChildren().add(imageViewKarakter);
    }

    public static void karakterHareket() {

        AtomicInteger index = new AtomicInteger(0);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    Kordinat kordinat = kordinatArrayListKarakter.get(index.get());

                    imageViewKarakter.setX(kordinat.x * KARE_BOYUTU);
                    imageViewKarakter.setY(kordinat.y * KARE_BOYUTU);

                    for (Hazine hazine : hazineArrayListYedek){
                        if (hazine.getX() ==kordinat.x && hazine.getY() == kordinat.y){
                            int noktaIndex = hazine.getAd().indexOf('.');
                            String ad = hazine.getAd().substring(0, noktaIndex);
                            textBilgi.setText(ad + " ALINDI");




                            for (ImageView imageView : hazineImageViews){
                                if (imageView.getId().equals(hazine.getAd()) && imageView.getX() == (double)hazine.getX() * KARE_BOYUTU){
                                    imageView.setVisible(false);
                                }
                            }
                        }

                    }

                    gc.setFill(Color.web("#008000"));
                    gc.fillRect(kordinat.x * KARE_BOYUTU, kordinat.y* KARE_BOYUTU, KARE_BOYUTU, KARE_BOYUTU);
                    index.incrementAndGet();

                    if (index.get() >= kordinatArrayListKarakter.size()) {
                        timer.cancel();
                    }
                });
            }
        }, 0, 100); // 100 milisaniye (0.1 saniye) aralıklarla hareket et


    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public int getGenislik() {
        return genislik;
    }

    public void setGenislik(int genislik) {
        this.genislik = genislik;
    }

    public int getIlkKonumX() {
        return ilkKonumX;
    }

    public void setIlkKonumX(int ilkKonumX) {
        this.ilkKonumX = ilkKonumX;
    }

    public int getIlkKonumY() {
        return ilkKonumY;
    }

    public void setIlkKonumY(int ilkKonumY) {
        this.ilkKonumY = ilkKonumY;
    }



}
