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
            "kus.png", 0, 0, 2, 2, "Y", 5);
    static Engel ari = new HareketliEngel("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Hareketli Engeller/",
            "ari.png", 0, 0, 6, 6, "X", 3);
    static Engel[] hareketliEngeller = {kus, ari};
    private static List<HareketliEngel> hareketliEngelArrayList = new ArrayList<>();
    private static List<ImageView> hareketliEngelImageViews = new ArrayList<>();



    public static void hareketliEngelOlustur(Group root) throws CloneNotSupportedException {
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int a = random.nextInt(hareketliEngeller.length);
            HareketliEngel yerlestirilecekHareketliEngel = (HareketliEngel) hareketliEngeller[a].clone();
            int engelX = (int) (Math.random() * KARE_YUKSEKLIK);
            int engelY = (int) (Math.random() * KARE_GENISLIK);
            yerlestirilecekHareketliEngel.setEngelX(engelX);
            yerlestirilecekHareketliEngel.setEngelY(engelY);
            hareketliEngelArrayList.add(yerlestirilecekHareketliEngel);
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
