package org.efs.demo;

public class HareketliEngel extends Engel {

    private String hareketYonu;
    private int hareketBoyutu;


    public HareketliEngel(String imagePath, String ad, int engelX, int engelY, int engelBoy, int engelGenislik,String hareketYonu,int hareketBoyutu) {
        super(imagePath, ad, engelX, engelY, engelBoy, engelGenislik);
        this.hareketBoyutu = hareketBoyutu;
        this.hareketYonu = hareketYonu;
    }
}
