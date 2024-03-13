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
        this.setEngelBoy(engelBoy);
        this.setEngelGenislik(engelGenislik);
        this.setAd(ad);
        this.setImagePath(imagePath);
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


    protected Engel clone() throws CloneNotSupportedException {
        try {
            return (Engel) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getEngelBoy() {
        return engelBoy;
    }

    public void setEngelBoy(int engelBoy) {
        this.engelBoy = engelBoy;
    }

    public int getEngelGenislik() {
        return engelGenislik;
    }

    public void setEngelGenislik(int engelGenislik) {
        this.engelGenislik = engelGenislik;
    }
}
