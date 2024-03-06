package org.efs.demo;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

import static org.efs.demo.HelloApplication.*;

public class Hazine  implements Cloneable {

    public Hazine(String imagePath, String ad, int x, int y, int boy, int genislik) {
        this.setAd(ad);
        this.setImagePath(imagePath);
        setX(x);
        setY(y);
        setBoy(boy);
        setGenislik(genislik);
    }

    private String ad;
    private String imagePath;
    private int X;
    private int Y;
    private int Boy;
    private int Genislik;


    static Hazine altin = new Hazine("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/hazine/",
            "altin.png",0,0,2,2);
    static Hazine bakir = new Hazine("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/hazine/",
            "bakir.png",0,0,2,2);
    static Hazine gumus = new Hazine("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/hazine/",
            "gumus.png",0,0,2,2);
    static Hazine zumrut = new Hazine("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/hazine/",
            "zumrut.png",0,0,2,2);


    static Hazine [] hazineler = {altin,bakir,gumus,zumrut};

    static ArrayList<Hazine> hazineArrayList = new ArrayList<>();


    public static void HazineOlustur(Lokasyon lokasyon, Group root) throws CloneNotSupportedException{


        lokasyon.MatrisiBirle();

        int kontrol;

        for (int j = 0;j<5;j++){
            for (int i = 0; i<hazineler.length; i++){

                while (true){

                    Random random = new Random();
                    Hazine yerlestirilecekHazine = (Hazine) hazineler[i].clone();

                    int engelX;
                    int engelY;

                    do {

                        engelX = random.nextInt(KARE_GENISLIK);

                    } while (!(engelX + yerlestirilecekHazine.getGenislik() < KARE_GENISLIK));

                    do {

                        engelY = random.nextInt(KARE_YUKSEKLIK);

                    } while (!(engelY + yerlestirilecekHazine.getGenislik() < KARE_YUKSEKLIK));


                    int x1 = engelX;
                    int x2 = engelX + yerlestirilecekHazine.getGenislik() - 1;
                    int x3 = engelX + yerlestirilecekHazine.getGenislik() - 1;
                    int x4 = engelX;

                    int y1 = engelY;
                    int y2 = engelY;
                    int y3 = engelY + yerlestirilecekHazine.getBoy() - 1;
                    int y4 = engelY + yerlestirilecekHazine.getBoy() - 1;



                    kontrol = lokasyon.Kontrol(x1, x2, x3, x4, y1, y2, y3, y4);  // 1 ise devam -1 ise başa dön

                    if (kontrol == 1) {

                        yerlestirilecekHazine.setX(engelX);
                        yerlestirilecekHazine.setY(engelY);

                        lokasyon.HazineKordinatYaz(yerlestirilecekHazine.getBoy(), yerlestirilecekHazine.getGenislik()
                                ,yerlestirilecekHazine.getX() + 1, yerlestirilecekHazine.getY() + 1);

                        hazineArrayList.add(yerlestirilecekHazine);

                        break;
                    }

                }
            }
        }



        for (Hazine hazine : hazineArrayList){

            Image imageHazine = new Image(hazine.imagePath + hazine.ad);
            ImageView imageView = new ImageView(imageHazine);

            imageView.setFitWidth(KARE_BOYUTU * hazine.Genislik);
            imageView.setFitHeight(KARE_BOYUTU * hazine.Boy);
            imageView.setX(hazine.getX() * KARE_BOYUTU);
            imageView.setY(hazine.getY() * KARE_BOYUTU);

            //ilerde arraylist<ImageView> oluşuturulabilir
            root.getChildren().add(imageView);
        }

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

    public int getBoy() {
        return Boy;
    }

    public void setBoy(int boy) {
        Boy = boy;
    }

    public int getGenislik() {
        return Genislik;
    }

    public void setGenislik(int genislik) {
        Genislik = genislik;
    }
}
