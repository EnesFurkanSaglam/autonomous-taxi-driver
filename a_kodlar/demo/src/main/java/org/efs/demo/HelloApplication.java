package org.efs.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class HelloApplication extends Application {
     static final int GENISLIK = 1000;
     static final int YUKSEKLIK = 1000;
     static final int KARE_YUKSEKLIK = 25;
     static final int KARE_GENISLIK = 25;
    private static final int KARE_BOYUTU = GENISLIK / KARE_YUKSEKLIK;
    private int engelX;
    private int engelY;

    private GraphicsContext gc;

    private Image imageYazEngel;
    private Image imageKisEngel;
    private Image imageHazine;
    private Image imageKarakter;


    private static final String[] HARAKETLI_ENGEL =
            {"kus.png", "ari.png"};
    private static final String[] HAZINELER =
            {"altin.png", "gumus.png", "zumrut.png", "bakir.png"};
    private static final String[] KARAKTER =
            {"doblo.png"};
    private static final String[] KIS_ENGEL =
            {"buz dagi.png", "kutup ayisi.png", "penguen.png"};

    private static final String[] YAZ_ENGEL =
            {"agac.png", "dag.png", "duvar.png", "kaya.png"};
    private static final String[] SIS =
            {"sis.png"};

    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("OTONOM HAZİNE AVCISI");

        Group root = new Group();

        Canvas canvas = new Canvas(GENISLIK, YUKSEKLIK);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        gc = canvas.getGraphicsContext2D();
        run();


        KisEngelOlustur();
        KisEngelOlustur();
        KarakterOlustur();

    }

    private void run() {
        drawBackground(gc);
    }


    private void drawBackground(GraphicsContext gc) {
        for (int i = 0; i < KARE_YUKSEKLIK; i++) {
            for (int j = 0; j < KARE_GENISLIK; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web("#808080"));
                } else {
                    gc.setFill(Color.web("#ffffff"));
                }
                gc.fillRect(i * KARE_BOYUTU, j * KARE_BOYUTU, KARE_BOYUTU, KARE_BOYUTU);
            }
        }

    }



    private void KisEngelOlustur() {   //


        engelX = (int) (Math.random() * KARE_YUKSEKLIK);
        engelY = (int) (Math.random() * KARE_GENISLIK);

        String imagePath = "file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/";

        imageKisEngel = new Image(imagePath + KIS_ENGEL[(int) (Math.random() * KIS_ENGEL.length)]);
        gc.drawImage(imageKisEngel, engelX * KARE_BOYUTU, engelY * KARE_BOYUTU, KARE_BOYUTU, KARE_BOYUTU);

    }
    private void KarakterOlustur() {   //
        engelX = (int) (Math.random() * KARE_YUKSEKLIK);
        engelY = (int) (Math.random() * KARE_GENISLIK);

        String imagePath = "file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Karakter/";
        imageKarakter = new Image(imagePath + KARAKTER[0]);
        gc.drawImage(imageKarakter, engelX * KARE_BOYUTU, engelY * KARE_BOYUTU, KARE_BOYUTU, KARE_BOYUTU);

        HareketsizEngelYaz.YazEngelOlustur();

    }


}
