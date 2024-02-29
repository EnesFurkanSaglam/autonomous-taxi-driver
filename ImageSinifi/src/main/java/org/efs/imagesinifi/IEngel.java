package org.efs.imagesinifi;

public interface IEngel {

     String ad = null;
     String imagePath = null;
     int engelX = 0;
     int engelY = 0 ;
     int engelBoy = 0;
     int engelGenislik = 0;


    int getEngelX();

    void setEngelX(int engelX);

    int getEngelY();

    void setEngelY(int engelY);

    String getImagePath();

    void setImagePath(String imagePath);

    String getAd();

    void setAd(String ad);

    IEngel clone() throws CloneNotSupportedException;

}
