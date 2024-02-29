package org.efs.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Timer;


import static org.efs.demo.HareketliEngel.hareketEttir;
import static org.efs.demo.HareketliEngel.hareketliEngelOlustur;
import static org.efs.demo.HareketsizEngelKis.KisEngelOlustur;
import static org.efs.demo.HareketsizEngelYaz.YazEngelOlustur;


public class HelloApplication extends Application{

     static final int GENISLIK = 1000;
     static final int YUKSEKLIK = 1000;
     static final int KARE_YUKSEKLIK = 25;
     static final int KARE_GENISLIK = 25;
     static final int KARE_BOYUTU = GENISLIK / KARE_YUKSEKLIK;

    static GraphicsContext gc;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws CloneNotSupportedException {

        primaryStage.setTitle("OTONOM HAZİNE AVCISI");
        Group root = new Group();
        Canvas canvas = new Canvas(GENISLIK, YUKSEKLIK);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        gc = canvas.getGraphicsContext2D();
        run();
        YazEngelOlustur();
        KisEngelOlustur();
        hareketliEngelOlustur(root);
        hareketEttir();

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

}
