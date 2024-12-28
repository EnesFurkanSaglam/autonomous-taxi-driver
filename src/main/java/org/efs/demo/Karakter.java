package org.efs.demo;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import static org.efs.demo.Engel.engelArrayList;
import static org.efs.demo.Hazine.*;
import static org.efs.demo.HelloApplication.*;
import static org.efs.demo.HelloApplication.KARE_YUKSEKLIK;
import static org.efs.demo.Kordinat.kordinatArrayListKarakter;
import static org.efs.demo.Sis.sisArrayListImageView;

public class Karakter {

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

    static Karakter karakter = new Karakter(1, "doblo.png",
            Objects.requireNonNull(Karakter.class.getResource("/png/")).toExternalForm(),
            0, 0, 1, 1);




    static ArrayList<Hazine> hazineKesfedilen = new ArrayList<>();
    static ArrayList<Engel> engelKesfedilen = new ArrayList<>();





    public static void KarakterOlustur(Lokasyon lokasyon, Group root){

        imageViewKarakter = null;
        hazineKesfedilen.clear();
        engelKesfedilen.clear();



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


                    for (ImageView imageView : sisArrayListImageView){

                        for (int i = kordinat.x - 3; i <= kordinat.x + 3; i++) {

                            for (int j = kordinat.y - 3; j <= kordinat.y + 3; j++) {

                                if ((double) i * KARE_BOYUTU == imageView.getX() && (double) j * KARE_BOYUTU == imageView.getY()) {

                                    imageView.setVisible(false);

                                    for (Engel engel : engelArrayList){

                                        if (engel.getEngelX() == i && engel.getEngelY() == j){

                                            int noktaIndex = engel.getAd().indexOf('.');
                                            String ad = engel.getAd().substring(0, noktaIndex);
                                            ad = ad.toUpperCase();
                                            textBilgiKesfedilen.setText(ad + " KEŞFEDİLDİ");

                                            if (!engelKesfedilen.contains(engel)){
                                                engelKesfedilen.add(engel);
                                            }

                                        }



                                    }

                                    for (Hazine hazine : hazineArrayListYedek){

                                        if (hazine.getX() == i && hazine.getY() == j){
                                            int noktaIndex = hazine.getAd().indexOf('.');
                                            String ad = hazine.getAd().substring(0, noktaIndex);
                                            ad = ad.toUpperCase();

                                            textBilgiKesfedilen.setText(ad + " KEŞFEDİLDİ");

                                            if (!hazineKesfedilen.contains(hazine)){
                                                hazineKesfedilen.add(hazine);
                                            }

                                        }
                                    }

                                }
                            }
                        }
                    }



                    for (Hazine hazine : hazineArrayListYedek){
                        if (hazine.getX() ==kordinat.x && hazine.getY() == kordinat.y){
                            int noktaIndex = hazine.getAd().indexOf('.');
                            String ad = hazine.getAd().substring(0, noktaIndex);
                            ad = ad.toUpperCase();
                            if (!hazineArrayListToplamaSirasi.contains(hazine)){
                                hazineArrayListToplamaSirasi.add(hazine);
                            }
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
        }, 0, 100);
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public int getBoy() {
        return boy;
    }
    public int getGenislik() {
        return genislik;
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
