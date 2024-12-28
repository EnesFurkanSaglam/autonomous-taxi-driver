package org.efs.demo;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Objects;

import static org.efs.demo.HelloApplication.*;
import static org.efs.demo.HelloApplication.KARE_BOYUTU;


public class Sis implements Cloneable{

    static Sis sis = new Sis(Objects.requireNonNull(Sis.class.getResource("/png/")).toExternalForm(),"sis.png", 0, 0);

    static ArrayList<ImageView> sisArrayListImageView = new ArrayList<>();

    public Sis(String imagePath, String ad , int x, int y) {
        this.setAd(ad);
        this.setImagePath(imagePath);
        setX(x);
        setY(y);
    }

        private String ad;
        private String imagePath;
        private int X;
        private int Y;

        public static void Sisle(Group root){
            for (int i = 0;i<KARE_YUKSEKLIK;i++){
                for (int j = 0;j<KARE_GENISLIK;j++){
                    Image imageSis = new Image(sis.getImagePath() + sis.getAd());
                    ImageView imageView = new ImageView(imageSis);
                    imageView.setFitWidth(KARE_BOYUTU);
                    imageView.setFitHeight(KARE_BOYUTU);
                    imageView.setX(i * KARE_BOYUTU);
                    imageView.setY(j * KARE_BOYUTU);

                    sisArrayListImageView.add(imageView);
                    root.getChildren().add(imageView);
                }
            }
        }


    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }


    protected Engel clone() throws CloneNotSupportedException {
        try {
            return (Engel) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
