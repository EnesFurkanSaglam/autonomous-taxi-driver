package org.efs.demo;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

import static org.efs.demo.HelloApplication.*;
import static org.efs.demo.HelloApplication.KARE_BOYUTU;

public class HareketsizEngelKis extends HareketsizEngel {

    public HareketsizEngelKis(String imagePath, String ad, int engelX, int engelY, int engelBoy, int engelGenislik) {
        super(imagePath, ad, engelX, engelY, engelBoy, engelGenislik);

    }

    static Engel buzdagi = new HareketsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
            "buz dagi.png",0,0,15,15);
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


    public static void KisEngelOlustur() throws CloneNotSupportedException { // sol taraf kış

        int kisEngelSayisi = kisEngelleri.length;

        for (int i = 0;i<3;i++){
            Random random = new Random();
            int a = random.nextInt(kisEngelSayisi);
            HareketsizEngelKis yerlestirilecekKisEngeli = (HareketsizEngelKis) kisEngelleri[a].clone();
            int engelX = (int) (Math.random() * KARE_YUKSEKLIK -   KARE_YUKSEKLIK/2 );
            int engelY = (int) (Math.random() * KARE_GENISLIK);
            yerlestirilecekKisEngeli.setEngelX(engelX);
            yerlestirilecekKisEngeli.setEngelY(engelY);
            hareketsizEngelKisArrayList.add(yerlestirilecekKisEngeli);
        }

        for (HareketsizEngelKis hareketsizEngelKis : hareketsizEngelKisArrayList){
            Image imageKisEngel = new Image(hareketsizEngelKis.getImagePath() + hareketsizEngelKis.getAd());
            gc.drawImage(imageKisEngel,hareketsizEngelKis.getEngelX() * KARE_BOYUTU,hareketsizEngelKis.getEngelY() * KARE_BOYUTU,KARE_BOYUTU,KARE_BOYUTU);
        }
    }



}
