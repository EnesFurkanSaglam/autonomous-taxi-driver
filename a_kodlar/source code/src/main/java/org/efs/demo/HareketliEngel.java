package org.efs.demo;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.*;

import static org.efs.demo.HelloApplication.*;

public class HareketliEngel extends Engel {

    private String hareketYonu;
    private int hareketBoyutu;
    public HareketliEngel(String imagePath, String ad, int engelX, int engelY, int engelBoy, int engelGenislik, String hareketYonu, int hareketBoyutu) {
        super(imagePath, ad, engelX, engelY, engelBoy, engelGenislik);
        this.hareketYonu = hareketYonu;
        this.hareketBoyutu = hareketBoyutu;
    }

    static Engel kus = new HareketliEngel("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Hareketli Engeller/",
            "kus.png", 0, 0, 2, 2, "Y", 5);
    static Engel ari = new HareketliEngel("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Hareketli Engeller/",
            "ari.png", 0, 0, 2, 2, "X", 5);
    static Engel[] hareketliEngeller = {kus,ari};
    private static List<HareketliEngel> hareketliEngelArrayList = new ArrayList<>();
    private static List<ImageView> hareketliEngelImageViews = new ArrayList<>();


    public static void hareketliEngelOlustur(Lokasyon lokasyon,Group root) throws CloneNotSupportedException {

        root.getChildren().removeAll(hareketliEngelImageViews);
        hareketliEngelImageViews.clear();
        hareketliEngelArrayList.clear();


        for (int i = 0; i < hareketliEngelSayi; i++) {
            int kontrol;

            while(true) {

            Random random = new Random();
            int a = random.nextInt(hareketliEngeller.length);
            HareketliEngel yerlestirilecekHareketliEngel = (HareketliEngel) hareketliEngeller[a].clone();

            int engelX;
            int engelY;


            do {

                engelX = random.nextInt(KARE_GENISLIK);

            } while (!(engelX - yerlestirilecekHareketliEngel.hareketBoyutu > 0 &&
                    KARE_GENISLIK - engelX > yerlestirilecekHareketliEngel.hareketBoyutu + yerlestirilecekHareketliEngel.getEngelGenislik()));


            do {

                engelY = random.nextInt(KARE_YUKSEKLIK);

            } while (!(engelY - yerlestirilecekHareketliEngel.hareketBoyutu > 0
                    && engelY + yerlestirilecekHareketliEngel.hareketBoyutu + yerlestirilecekHareketliEngel.getEngelBoy() < KARE_YUKSEKLIK));


            if (yerlestirilecekHareketliEngel.hareketYonu.equals("X"))
            {
                int x1 = engelX - yerlestirilecekHareketliEngel.hareketBoyutu;
                int x2 = engelX + yerlestirilecekHareketliEngel.hareketBoyutu + yerlestirilecekHareketliEngel.getEngelGenislik() - 1;
                int x3 = engelX + yerlestirilecekHareketliEngel.hareketBoyutu + yerlestirilecekHareketliEngel.getEngelGenislik() - 1;
                int x4 = engelX - yerlestirilecekHareketliEngel.hareketBoyutu;

                int y1 = engelY ;
                int y2 = engelY ;
                int y3 = engelY + yerlestirilecekHareketliEngel.getEngelBoy() -1;
                int y4 = engelY + yerlestirilecekHareketliEngel.getEngelBoy() -1;

                kontrol = lokasyon.Kontrol(x1, x2, x3, x4, y1, y2, y3, y4); // 1 ise devam -1 ise başa dön
            }else {

                int x1 = engelX ;
                int x2 = engelX  + yerlestirilecekHareketliEngel.getEngelGenislik() - 1;
                int x3 = engelX  + yerlestirilecekHareketliEngel.getEngelGenislik() - 1;
                int x4 = engelX ;

                int y1 = engelY - yerlestirilecekHareketliEngel.hareketBoyutu;
                int y2 = engelY - yerlestirilecekHareketliEngel.hareketBoyutu;
                int y3 = engelY + yerlestirilecekHareketliEngel.hareketBoyutu + yerlestirilecekHareketliEngel.getEngelBoy() -1;
                int y4 = engelY + yerlestirilecekHareketliEngel.hareketBoyutu + yerlestirilecekHareketliEngel.getEngelBoy() -1;

                kontrol = lokasyon.Kontrol(x1, x2, x3, x4, y1, y2, y3, y4); // 1 ise devam -1 ise başa dön

            }


            if (kontrol == 1) {

                yerlestirilecekHareketliEngel.setEngelX(engelX);
                yerlestirilecekHareketliEngel.setEngelY(engelY);

                lokasyon.HareketliEngelKordinatYaz(yerlestirilecekHareketliEngel.getEngelBoy(), yerlestirilecekHareketliEngel.getEngelGenislik()
                        ,yerlestirilecekHareketliEngel.getEngelX() + 1, yerlestirilecekHareketliEngel.getEngelY() + 1,
                        yerlestirilecekHareketliEngel.hareketBoyutu,yerlestirilecekHareketliEngel.hareketYonu);

                hareketliEngelArrayList.add(yerlestirilecekHareketliEngel);

                break;
            }
        }

        }

        for (HareketliEngel hareketliEngel : hareketliEngelArrayList) {
            Image imageHareketliEngel = new Image(hareketliEngel.getImagePath() + hareketliEngel.getAd());
            ImageView imageView = new ImageView(imageHareketliEngel);
            imageView.setId(hareketliEngel.getAd());

            imageView.setFitWidth(KARE_BOYUTU * hareketliEngel.getEngelGenislik());
            imageView.setFitHeight(KARE_BOYUTU * hareketliEngel.getEngelBoy());
            imageView.setX(hareketliEngel.getEngelX() * KARE_BOYUTU);
            imageView.setY(hareketliEngel.getEngelY() * KARE_BOYUTU);

            hareketliEngelImageViews.add(imageView);
            root.getChildren().add(imageView);
        }
    }


    public static void hareketEttir() {

                for (ImageView imageView : hareketliEngelImageViews) {

                    for (HareketliEngel hareketliEngel : hareketliEngelArrayList) {
                        if (imageView.getId().equals(hareketliEngel.getAd())) {
                            switch (hareketliEngel.hareketYonu) {
                                case "Y":


                                    TranslateTransition yukariHareket = new TranslateTransition(Duration.seconds(1), imageView);
                                    yukariHareket.setByY(hareketliEngel.hareketBoyutu); // Resmi HAREKET_UZAKLIGI kadar sağa hareket ettirin
                                    yukariHareket.setAutoReverse(true); // Orijinal konuma geri dön
                                    yukariHareket.setCycleCount(TranslateTransition.INDEFINITE); // Sürekli tekrarla

                                    TranslateTransition asagiHareket = new TranslateTransition(Duration.seconds(1), imageView);
                                    asagiHareket.setByY(-hareketliEngel.hareketBoyutu*2); // Resmi HAREKET_UZAKLIGI kadar sağa hareket ettirin
                                    asagiHareket.setAutoReverse(true); // Orijinal konuma geri dön
                                    asagiHareket.setCycleCount(TranslateTransition.INDEFINITE); // Sürekli tekrarla




                                    yukariHareket.play();
                                    asagiHareket.play();


                                    break;

                                case "X":

                                    TranslateTransition sagaHareket = new TranslateTransition(Duration.seconds(1), imageView);
                                    sagaHareket.setByX(hareketliEngel.hareketBoyutu); // Resmi HAREKET_UZAKLIGI kadar sağa hareket ettirin
                                    sagaHareket.setAutoReverse(true); // Orijinal konuma geri dön
                                    sagaHareket.setCycleCount(TranslateTransition.INDEFINITE); // Sürekli tekrarla

                                    TranslateTransition solaHareket = new TranslateTransition(Duration.seconds(1), imageView);
                                    solaHareket.setByX(-hareketliEngel.hareketBoyutu*2); // Resmi HAREKET_UZAKLIGI kadar sola hareket ettirin
                                    solaHareket.setAutoReverse(true); // Orijinal konuma geri dön
                                    solaHareket.setCycleCount(TranslateTransition.INDEFINITE); // Sürekli tekrarla

                                    sagaHareket.play();
                                    solaHareket.play();

                                    break;
                            }
                        }
                    }

                }

    }


}
