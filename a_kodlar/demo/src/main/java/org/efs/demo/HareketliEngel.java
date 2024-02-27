package org.efs.demo;


import java.util.ArrayList;

import static org.efs.demo.HelloApplication.KARE_GENISLIK;
import static org.efs.demo.HelloApplication.KARE_YUKSEKLIK;

public class HareketliEngel extends Engel {

    private String hareketYonu;
    private int hareketBoyutu;

    private Engel kus = new HareketliEngel("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Hareketli Engeller/",
            "kus.png",0,0,2,2,"Y",5);
    private Engel ari = new HareketliEngel("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Hareketli Engeller/",
            "ari.png",0,0,2,2,"X",3);

    ArrayList<HareketliEngel> hareketliEngelArrayList = new ArrayList<>();


    public HareketliEngel(String imagePath, String ad, int engelX, int engelY, int engelBoy, int engelGenislik,String hareketYonu,int hareketBoyutu) {
        super(imagePath, ad, engelX, engelY, engelBoy, engelGenislik);
        this.hareketBoyutu = hareketBoyutu;
        this.hareketYonu = hareketYonu;

        hareketliEngelArrayList.add((HareketliEngel) kus);
        hareketliEngelArrayList.add((HareketliEngel) ari);


    }
}
