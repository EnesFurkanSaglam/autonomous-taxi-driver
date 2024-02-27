package org.efs.demo;

import javafx.scene.image.Image;

import java.util.ArrayList;

import static org.efs.demo.HelloApplication.KARE_GENISLIK;
import static org.efs.demo.HelloApplication.KARE_YUKSEKLIK;

public class HareketsizEngelYaz extends HareketsizEngel {

    public HareketsizEngelYaz(String imagePath, String ad, int engelX, int engelY, int engelBoy, int engelGenislik) {
        super(imagePath, ad, engelX, engelY, engelBoy, engelGenislik);

    }

    static HareketsizEngelYaz agac = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "agac.png",0,0,5,5);
    static Engel dag = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "dag.png",0,0,5,5);
    static Engel duvar = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "duvar.png",0,0,3,3);
    static Engel kaya = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "kaya.png",0,0,3,3);
    static Engel gunes = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
            "gunes.png",0,0,5,5);




    public static void YazEngelOlustur() { // 1 tane engel oluşturmaya çalışıyoruz




        /*
        int engelX = (int) (Math.random() * KARE_YUKSEKLIK);
        int engelY = (int) (Math.random() * KARE_GENISLIK);
        String imagePath = "file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/";
        imageYazEngel = new Image(imagePath + YAZ_ENGEL[(int) (Math.random() * YAZ_ENGEL.length)]);
        gc.drawImage(imageYazEngel, engelX * KARE_BOYUTU, engelY * KARE_BOYUTU, KARE_BOYUTU, KARE_BOYUTU);
        */
    }
}
