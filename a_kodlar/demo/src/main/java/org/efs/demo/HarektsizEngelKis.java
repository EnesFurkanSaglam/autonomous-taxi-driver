package org.efs.demo;

import java.util.ArrayList;

import static org.efs.demo.HelloApplication.KARE_GENISLIK;
import static org.efs.demo.HelloApplication.KARE_YUKSEKLIK;

public class HarektsizEngelKis extends HareketsizEngel {

    private Engel buzdagi = new HarektsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
            "buz dagi.png",(int) 0,0,15,15);
    private Engel kutupayisi = new HarektsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
            "kutup ayisi.png",0,0,5,5);
     private Engel penguen = new HarektsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
            "penguen.png",0,0,5,5);
    private Engel kardanadam = new HarektsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
            "kardan adam.png",0,0,5,5);
    private Engel buz = new HarektsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
            "buz.png",0,0,2,2);

    ArrayList<HarektsizEngelKis> harektsizEngelKisArrayList = new ArrayList<>();


    public HarektsizEngelKis(String imagePath, String ad, int engelX, int engelY, int engelBoy, int engelGenislik) {
        super(imagePath, ad, engelX, engelY, engelBoy, engelGenislik);

        harektsizEngelKisArrayList.add((HarektsizEngelKis) buzdagi);
        harektsizEngelKisArrayList.add((HarektsizEngelKis) kutupayisi);
        harektsizEngelKisArrayList.add((HarektsizEngelKis) penguen);
        harektsizEngelKisArrayList.add((HarektsizEngelKis) kardanadam);
        harektsizEngelKisArrayList.add((HarektsizEngelKis) buz);
    }
}
