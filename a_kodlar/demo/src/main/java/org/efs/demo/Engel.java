package org.efs.demo;

public class Engel implements Cloneable {

    private String ad;
    private String imagePath;
    private int engelX;
    private int engelY;
    private int engelBoy;
    private int engelGenislik;

    public Engel(String imagePath,String ad, int engelX, int engelY, int engelBoy, int engelGenislik) {
        this.setEngelX(engelX);
        this.setEngelY(engelY);
        this.engelBoy = engelBoy;
        this.engelGenislik = engelGenislik;
        this.ad = ad;
        this.imagePath = imagePath;
    }


    public int getEngelX() {
        return engelX;
    }

    public void setEngelX(int engelX) {
        this.engelX = engelX;
    }

    public int getEngelY() {
        return engelY;
    }

    public void setEngelY(int engelY) {
        this.engelY = engelY;
    }

    protected Engel clone(){
        try {
            return (Engel) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
