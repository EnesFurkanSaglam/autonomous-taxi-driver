package org.efs.demo;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.util.*;
import static org.efs.demo.HelloApplication.*;


public class HareketliEngel extends Engel {
    private String hareketYonu;
    private int hareketBoyutu;

    public HareketliEngel(String imagePath, String ad, int engelX, int engelY, int engelBoy, int engelGenislik, String hareketYonu, int hareketBoyutu) {
        super(imagePath, ad, engelX, engelY, engelBoy, engelGenislik);
        this.setHareketYonu(hareketYonu);
        this.setHareketBoyutu(hareketBoyutu);
    }

    static Engel kus = new HareketliEngel(Objects.requireNonNull(HareketliEngel.class.getResource("/png/")).toExternalForm(), "kus.png", 0, 0, 2, 2, "Y", 5);
    static Engel ari = new HareketliEngel(Objects.requireNonNull(HareketliEngel.class.getResource("/png/")).toExternalForm(), "ari.png", 0, 0, 2, 2, "X", 5);

    static Engel[] hareketliEngeller = {kus, ari};
    private static List<HareketliEngel> hareketliEngelArrayList = new ArrayList<>();
    private static List<ImageView> hareketliEngelImageViews = new ArrayList<>();
    public static void hareketliEngelOlustur(Lokasyon lokasyon, Group root) throws CloneNotSupportedException {

        root.getChildren().removeAll(hareketliEngelImageViews);
        hareketliEngelImageViews.clear();
        hareketliEngelArrayList.clear();

        for (int i = 0; i < hareketliEngelSayi; i++) {

            int kontrol;

            while (true) {

                Random random = new Random();
                int a = random.nextInt(hareketliEngeller.length);
                HareketliEngel yerlestirilecekHareketliEngel = (HareketliEngel) hareketliEngeller[a].clone();

                int engelX;
                int engelY;



                do {

                    engelX = random.nextInt(KARE_GENISLIK);

                } while (!(engelX - yerlestirilecekHareketliEngel.getHareketBoyutu() > 0 &&
                        KARE_GENISLIK - engelX > yerlestirilecekHareketliEngel.getHareketBoyutu() + yerlestirilecekHareketliEngel.getEngelGenislik()));


                do {

                    engelY = random.nextInt(KARE_YUKSEKLIK);

                } while (!(engelY - yerlestirilecekHareketliEngel.getHareketBoyutu() > 0
                        && engelY + yerlestirilecekHareketliEngel.getHareketBoyutu() + yerlestirilecekHareketliEngel.getEngelBoy() < KARE_YUKSEKLIK));


                if (yerlestirilecekHareketliEngel.getHareketYonu().equals("X")) {

                    int x1 = engelX - yerlestirilecekHareketliEngel.getHareketBoyutu();
                    int x2 = engelX + yerlestirilecekHareketliEngel.getHareketBoyutu() + yerlestirilecekHareketliEngel.getEngelGenislik() - 1;
                    int x3 = engelX + yerlestirilecekHareketliEngel.getHareketBoyutu() + yerlestirilecekHareketliEngel.getEngelGenislik() - 1;
                    int x4 = engelX - yerlestirilecekHareketliEngel.getHareketBoyutu();

                    int y1 = engelY;
                    int y2 = engelY;
                    int y3 = engelY + yerlestirilecekHareketliEngel.getEngelBoy() - 1;
                    int y4 = engelY + yerlestirilecekHareketliEngel.getEngelBoy() - 1;

                    kontrol = lokasyon.Kontrol(x1, x2, x3, x4, y1, y2, y3, y4); // 1 ise devam -1 ise başa dön
                } else {

                    int x1 = engelX;
                    int x2 = engelX + yerlestirilecekHareketliEngel.getEngelGenislik() - 1;
                    int x3 = engelX + yerlestirilecekHareketliEngel.getEngelGenislik() - 1;
                    int x4 = engelX;

                    int y1 = engelY - yerlestirilecekHareketliEngel.getHareketBoyutu();
                    int y2 = engelY - yerlestirilecekHareketliEngel.getHareketBoyutu();
                    int y3 = engelY + yerlestirilecekHareketliEngel.getHareketBoyutu() + yerlestirilecekHareketliEngel.getEngelBoy() - 1;
                    int y4 = engelY + yerlestirilecekHareketliEngel.getHareketBoyutu() + yerlestirilecekHareketliEngel.getEngelBoy() - 1;

                    kontrol = lokasyon.Kontrol(x1, x2, x3, x4, y1, y2, y3, y4); // 1 ise devam -1 ise başa dön


                }

                if (kontrol == 1) {

                    yerlestirilecekHareketliEngel.setEngelX(engelX);
                    yerlestirilecekHareketliEngel.setEngelY(engelY);

                    lokasyon.HareketliEngelKordinatYaz(yerlestirilecekHareketliEngel.getEngelBoy(), yerlestirilecekHareketliEngel.getEngelGenislik()
                            , yerlestirilecekHareketliEngel.getEngelX() + 1, yerlestirilecekHareketliEngel.getEngelY() + 1,
                            yerlestirilecekHareketliEngel.getHareketBoyutu(), yerlestirilecekHareketliEngel.getHareketYonu());

                    hareketliEngelArrayList.add(yerlestirilecekHareketliEngel);
                    engelArrayList.add(yerlestirilecekHareketliEngel);

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
                            yukariHareket.setByY(hareketliEngel.hareketBoyutu*KARE_BOYUTU);
                            yukariHareket.setAutoReverse(true);
                            yukariHareket.setCycleCount(TranslateTransition.INDEFINITE);

                            TranslateTransition asagiHareket = new TranslateTransition(Duration.seconds(1), imageView);
                            asagiHareket.setByY(-hareketliEngel.hareketBoyutu*KARE_BOYUTU);
                            asagiHareket.setAutoReverse(true);
                            asagiHareket.setCycleCount(TranslateTransition.INDEFINITE);

                            yukariHareket.play();
                            asagiHareket.play();

                            break;

                        case "X":

                            TranslateTransition sagaHareket = new TranslateTransition(Duration.seconds(1), imageView);
                            sagaHareket.setByX(hareketliEngel.hareketBoyutu*KARE_BOYUTU);
                            sagaHareket.setAutoReverse(true);
                            sagaHareket.setCycleCount(TranslateTransition.INDEFINITE);

                            TranslateTransition solaHareket = new TranslateTransition(Duration.seconds(1), imageView);
                            solaHareket.setByX(-hareketliEngel.hareketBoyutu*KARE_BOYUTU);
                            solaHareket.setAutoReverse(true);
                            solaHareket.setCycleCount(TranslateTransition.INDEFINITE);


                            sagaHareket.play();
                            solaHareket.play();

                            break;
                    }
                }
            }
        }
    }

    public String getHareketYonu() {
        return hareketYonu;
    }

    public void setHareketYonu(String hareketYonu) {
        this.hareketYonu = hareketYonu;
    }

    public int getHareketBoyutu() {
        return hareketBoyutu;
    }

    public void setHareketBoyutu(int hareketBoyutu) {
        this.hareketBoyutu = hareketBoyutu;
    }
}
