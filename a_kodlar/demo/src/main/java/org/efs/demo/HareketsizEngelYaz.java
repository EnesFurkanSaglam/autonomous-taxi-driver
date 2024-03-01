package org.efs.demo;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

import static org.efs.demo.HelloApplication.*;

public class HareketsizEngelYaz extends HareketsizEngel {

    public HareketsizEngelYaz(String imagePath, String ad, int engelX, int engelY, int engelBoy, int engelGenislik) {
        super(imagePath, ad, engelX, engelY, engelBoy, engelGenislik);

    }

    static Engel agac = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "agac.png",0,0,5,5);
    static Engel dag = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "dag.png",0,0,5,5);
    static Engel duvar = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "duvar.png",0,0,3,3);
    static Engel kaya = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "kaya.png",0,0,3,3);
    static Engel gunes = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "gunes.png",0,0,5,5);

    static Engel[] yazEngelleri = {agac,dag,duvar,kaya,gunes};
    static ArrayList<HareketsizEngelYaz> hareketsizEngelYazArrayList = new ArrayList<>();



    public static void YazEngelOlustur(Lokasyon lokasyon) throws CloneNotSupportedException {


        int yazEngelSayisi = yazEngelleri.length;

        for (int i = 0; i<1;i++){

            Random random = new Random();
            int a = random.nextInt(yazEngelSayisi);
            HareketsizEngelYaz yerlestirilecekYazEngeli = (HareketsizEngelYaz) yazEngelleri[a].clone();
            int engelX = random.nextInt(KARE_GENISLIK / 2 - yerlestirilecekYazEngeli.getEngelGenislik()) + KARE_GENISLIK / 2 + 1;

            int engelY;

            do{
                engelY = (int) (Math.random() * KARE_YUKSEKLIK);
            }while (!(engelY < KARE_YUKSEKLIK - yerlestirilecekYazEngeli.getEngelBoy()));


            yerlestirilecekYazEngeli.setEngelX(engelX);
            yerlestirilecekYazEngeli.setEngelY(engelY);
            hareketsizEngelYazArrayList.add(yerlestirilecekYazEngeli);

            lokasyon.HareketsizEngelYazKordinatYaz(yerlestirilecekYazEngeli.getEngelBoy(),
                    yerlestirilecekYazEngeli.getEngelGenislik(),yerlestirilecekYazEngeli.getEngelX()+1,yerlestirilecekYazEngeli.getEngelY()+1);

        }

        for (HareketsizEngelYaz hareketsizEngelYaz : hareketsizEngelYazArrayList){
            Image imageYazEngel = new Image(hareketsizEngelYaz.getImagePath() + hareketsizEngelYaz.getAd());
            gc.drawImage(imageYazEngel, hareketsizEngelYaz.getEngelX() * KARE_BOYUTU, hareketsizEngelYaz.getEngelY() * KARE_BOYUTU, KARE_BOYUTU*hareketsizEngelYaz.getEngelBoy(), KARE_BOYUTU * hareketsizEngelYaz.getEngelGenislik());

        }


    }
}
