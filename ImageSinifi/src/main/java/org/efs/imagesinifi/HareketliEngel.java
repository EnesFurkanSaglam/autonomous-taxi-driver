package org.efs.imagesinifi;

import javafx.scene.image.Image;

import java.io.InputStream;

public class HareketliEngel extends Image implements IEngel {




    public HareketliEngel(String s) {
        super(s);
    }

    public HareketliEngel(String s, boolean b) {
        super(s, b);
    }

    public HareketliEngel(String s, double v, double v1, boolean b, boolean b1) {
        super(s, v, v1, b, b1);
    }

    public HareketliEngel(String s, double v, double v1, boolean b, boolean b1, boolean b2) {
        super(s, v, v1, b, b1, b2);
    }

    public HareketliEngel(InputStream inputStream) {
        super(inputStream);
    }

    public HareketliEngel(InputStream inputStream, double v, double v1, boolean b, boolean b1) {
        super(inputStream, v, v1, b, b1);
    }

    @Override
    public int getEngelX() {
        return 0;
    }

    @Override
    public void setEngelX(int engelX) {

    }

    @Override
    public int getEngelY() {
        return 0;
    }

    @Override
    public void setEngelY(int engelY) {

    }

    @Override
    public String getImagePath() {
        return null;
    }

    @Override
    public void setImagePath(String imagePath) {

    }

    @Override
    public String getAd() {
        return null;
    }

    @Override
    public void setAd(String ad) {

    }

    @Override
    public IEngel clone() throws CloneNotSupportedException {
        return null;
    }
}

