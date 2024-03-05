package org.efs.demo;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

import static org.efs.demo.HelloApplication.*;

public class HareketsizEngelYaz extends HareketsizEngel {

    public HareketsizEngelYaz(String imagePath, String ad, int engelX, int engelY, int engelBoy, int engelGenislik) {
        super(imagePath, ad, engelX, engelY, engelBoy, engelGenislik);

    }

    static Engel agac = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "agac.png",-1,-1,5,5);
    static Engel dag = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "dag.png",-1,-1,5,5);
    static Engel duvar = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "duvar.png",-1,-1,3,3);
    static Engel kaya = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "kaya.png",-1,-1,3,3);
    static Engel gunes = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "gunes.png",-1,-1,2,2);

    static Engel[] yazEngelleri = {agac,dag,duvar,kaya,gunes};
    static ArrayList<HareketsizEngelYaz> hareketsizEngelYazArrayList = new ArrayList<>();



    public static void YazEngelOlustur(Lokasyon lokasyon, Group root) throws CloneNotSupportedException {

        int kontrol;

        for (int i = 0; i<10;i++){

            while (true){

                int yazEngelSayisi = yazEngelleri.length;
                Random random = new Random();
                int a = random.nextInt(yazEngelSayisi);
                HareketsizEngelYaz yerlestirilecekYazEngeli = (HareketsizEngelYaz) yazEngelleri[a].clone();

                int engelX;
                int engelY;

                do{
                    engelX = random.nextInt(KARE_GENISLIK) + KARE_GENISLIK/2; // indisi veriyor
                }while (!(engelX + yerlestirilecekYazEngeli.getEngelGenislik() < KARE_GENISLIK));

                do{
                    engelY = (int) (Math.random() * KARE_YUKSEKLIK);  // indisi veriyor
                }while (!(engelY < KARE_YUKSEKLIK - yerlestirilecekYazEngeli.getEngelBoy()));


                int x1 = engelX ;
                int x2 = engelX  + yerlestirilecekYazEngeli.getEngelGenislik() - 1;
                int x3 = engelX  + yerlestirilecekYazEngeli.getEngelGenislik() - 1;
                int x4 = engelX ;

                int y1 = engelY ;
                int y2 = engelY ;
                int y3 = engelY + yerlestirilecekYazEngeli.getEngelBoy() -1;
                int y4 = engelY + yerlestirilecekYazEngeli.getEngelBoy() -1;

                kontrol = lokasyon.Kontrol(x1,x2,x3,x4,y1,y2,y3,y4); // 1 ise devam -1 ise başa dön

                if (kontrol == 1){

                    yerlestirilecekYazEngeli.setEngelX(engelX);
                    yerlestirilecekYazEngeli.setEngelY(engelY);

                    lokasyon.HareketsizEngelYazKordinatYaz(yerlestirilecekYazEngeli.getEngelBoy(),yerlestirilecekYazEngeli.getEngelGenislik()
                            ,yerlestirilecekYazEngeli.getEngelX()+1, yerlestirilecekYazEngeli.getEngelY()+1);

                    hareketsizEngelYazArrayList.add(yerlestirilecekYazEngeli);

                    break;
                }
            }
        }


        for (HareketsizEngelYaz hareketsizEngelYaz : hareketsizEngelYazArrayList){

            Image imageYazEngel = new Image(hareketsizEngelYaz.getImagePath() + hareketsizEngelYaz.getAd());
            ImageView imageView = new ImageView(imageYazEngel);
            imageView.setId(hareketsizEngelYaz.getAd());

            imageView.setFitWidth(KARE_BOYUTU * hareketsizEngelYaz.getEngelGenislik());
            imageView.setFitHeight(KARE_BOYUTU * hareketsizEngelYaz.getEngelBoy());
            imageView.setX(hareketsizEngelYaz.getEngelX() * KARE_BOYUTU);
            imageView.setY(hareketsizEngelYaz.getEngelY() * KARE_BOYUTU);

            //ilerde arraylist<ImageView> oluşuturulabilir
            root.getChildren().add(imageView);

        }


    }


}
