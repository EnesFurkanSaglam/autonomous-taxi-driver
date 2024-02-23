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
import java.util.Random;

public class HelloApplication extends Application {
    private static final int GENISLIK = 1000;
    private static final int YUKSEKLIK = 1000;
    private static final int KARE_YUKSEKLIK = 20;
    private static final int KARE_GENISLIK = 20;
    private static final int KARE_BOYUTU = GENISLIK / KARE_YUKSEKLIK;
    private int engelX;
    private int engelY;

    private GraphicsContext gc;

    private Image imageEngel;

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
        EngelOlustur();
        run();
    }

    private void run() {
        drawBackground(gc);
        EngelCiz(gc);
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

    private void EngelOlustur() {
        engelX = (int) (Math.random() * KARE_YUKSEKLIK);
        engelY = (int) (Math.random() * KARE_GENISLIK);

        String imagePath = "file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/";
        imageEngel = new Image(imagePath + YAZ_ENGEL[(int) (Math.random() * YAZ_ENGEL.length)]);
    }

    private void EngelCiz(GraphicsContext gc) {
        gc.drawImage(imageEngel, engelX * KARE_BOYUTU, engelY * KARE_BOYUTU, KARE_BOYUTU, KARE_BOYUTU);
    }
}
