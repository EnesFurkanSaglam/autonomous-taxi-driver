package org.efs.demo;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.efs.demo.HelloApplication.*;
import static org.efs.demo.HelloApplication.KARE_BOYUTU;

public class HareketsizEngelKis extends HareketsizEngel {

    public HareketsizEngelKis(String imagePath, String ad, int engelX, int engelY, int engelBoy, int engelGenislik) {
        super(imagePath, ad, engelX, engelY, engelBoy, engelGenislik);
    }

    static Engel buzdagi = new HareketsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
            "buz dagi.png",0,0,6,6);
    static Engel kutupayisi = new HareketsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
            "kutup ayisi.png",0,0,5,5);
     static Engel penguen = new HareketsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
            "penguen.png",0,0,5,5);
    static Engel kardanadam = new HareketsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
            "kardan adam.png",0,0,5,5);
    static Engel buz = new HareketsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
            "buz.png",0,0,2,2);

    static Engel[] kisEngelleri = {buzdagi,kutupayisi,penguen,kardanadam,buz};
    static ArrayList<HareketsizEngelKis> hareketsizEngelKisArrayList = new ArrayList<>();
    static List<ImageView> hareketsizEngelKisImageViews  = new ArrayList<>();


    public static void KisEngelOlustur(Lokasyon lokasyon, Group root) throws CloneNotSupportedException {

        root.getChildren().removeAll(hareketsizEngelKisImageViews);
        hareketsizEngelKisImageViews.clear();
        hareketsizEngelKisArrayList.clear();

        int kontrol;

        for (int i = 0;i<engelKisSayisi;i++){

            while (true) {

                int kisEngelSayisi = kisEngelleri.length;
                Random random = new Random();
                int a = random.nextInt(kisEngelSayisi);
                HareketsizEngelKis yerlestirilecekKisEngeli = (HareketsizEngelKis) kisEngelleri[a].clone();

                int engelX;
                int engelY;

                do {
                    engelX = random.nextInt(KARE_GENISLIK / 2);
                } while (!(engelX + yerlestirilecekKisEngeli.getEngelGenislik() < KARE_GENISLIK / 2));

                do {
                    engelY = (int) (Math.random() * KARE_YUKSEKLIK);
                } while (!(engelY < KARE_YUKSEKLIK - yerlestirilecekKisEngeli.getEngelBoy()));

                int x1 = engelX;
                int x2 = engelX + yerlestirilecekKisEngeli.getEngelGenislik() - 1;
                int x3 = engelX + yerlestirilecekKisEngeli.getEngelGenislik() - 1;
                int x4 = engelX;

                int y1 = engelY;
                int y2 = engelY;
                int y3 = engelY + yerlestirilecekKisEngeli.getEngelBoy() - 1;
                int y4 = engelY + yerlestirilecekKisEngeli.getEngelBoy() - 1;

                kontrol = lokasyon.Kontrol(x1, x2, x3, x4, y1, y2, y3, y4); // 1 ise devam -1 ise başa dön

                if (kontrol == 1) {

                    yerlestirilecekKisEngeli.setEngelX(engelX);
                    yerlestirilecekKisEngeli.setEngelY(engelY);

                    lokasyon.HareketsizEngelKisKordinatYaz(yerlestirilecekKisEngeli.getEngelBoy(), yerlestirilecekKisEngeli.getEngelGenislik()
                            ,yerlestirilecekKisEngeli.getEngelX() + 1, yerlestirilecekKisEngeli.getEngelY() + 1);

                    hareketsizEngelKisArrayList.add(yerlestirilecekKisEngeli);
                    engelArrayList.add(yerlestirilecekKisEngeli);

                    break;
                }
            }
        }

        for (HareketsizEngelKis hareketsizEngelKis : hareketsizEngelKisArrayList){

            Image imageKisEngel = new Image(hareketsizEngelKis.getImagePath() + hareketsizEngelKis.getAd());
            ImageView imageView = new ImageView(imageKisEngel);
            imageView.setFitWidth(KARE_BOYUTU * hareketsizEngelKis.getEngelGenislik());
            imageView.setFitHeight(KARE_BOYUTU * hareketsizEngelKis.getEngelBoy());
            imageView.setX(hareketsizEngelKis.getEngelX() * KARE_BOYUTU);
            imageView.setY(hareketsizEngelKis.getEngelY() * KARE_BOYUTU);

            hareketsizEngelKisImageViews.add(imageView);
            root.getChildren().add(imageView);
        }
    }
}
