package org.efs.demo;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
            "kus.png", 0, 0, 5, 5, "Y", 5);
    static Engel ari = new HareketliEngel("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Hareketli Engeller/",
            "ari.png", 0, 0, 5, 5, "X", 5);
    static Engel[] hareketliEngeller = {kus,ari};
    private static List<HareketliEngel> hareketliEngelArrayList = new ArrayList<>();
    private static List<ImageView> hareketliEngelImageViews = new ArrayList<>();


    public static void hareketliEngelOlustur(Lokasyon lokasyon,Group root) throws CloneNotSupportedException {

        for (int i = 0; i < 10; i++) {
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
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (ImageView imageView : hareketliEngelImageViews) {

                    double x = imageView.getX();
                    double y = imageView.getY();

                    for (HareketliEngel hareketliEngel : hareketliEngelArrayList) {
                        if (imageView.getId().equals(hareketliEngel.getAd())) {
                            switch (hareketliEngel.hareketYonu) {

                                case "Y":
                                    y += hareketliEngel.hareketBoyutu;
                                    if (y >= KARE_YUKSEKLIK * KARE_BOYUTU - hareketliEngel.hareketBoyutu || y < 0) {
                                        hareketliEngel.hareketBoyutu *= -1; // Change direction
                                    }
                                    break;
                                case "X":
                                    x += hareketliEngel.hareketBoyutu;
                                    if (x >= KARE_GENISLIK * KARE_BOYUTU - hareketliEngel.hareketBoyutu || x < 0) {
                                        hareketliEngel.hareketBoyutu *= -1; // Change direction
                                    }
                                    break;
                            }

                            imageView.setX(x);
                            imageView.setY(y);
                        }
                    }
                }
            }
        };
        timer.start();
    }


}
