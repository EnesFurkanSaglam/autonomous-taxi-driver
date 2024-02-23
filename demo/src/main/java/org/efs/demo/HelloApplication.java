package org.efs.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    private static final int GENISLIK = 1000000;
    private static final int YUKSEKLIK = 1000000;
    private static final int KARE_YUKSEKLIK = 1000;
    private static final int KARE_GENISLIK = 1000;
    private static final int KARE_BOYUTU = KARE_GENISLIK / KARE_YUKSEKLIK;
    private GraphicsContext gc;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("OTONOM HAZİNE AVCISI");
        Group root = new Group();
        Canvas canvas = new Canvas(GENISLIK,YUKSEKLIK);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        gc = canvas.getGraphicsContext2D();
        run();
    }

    private void run(){
        drawBackground(gc);
    }

    private void drawBackground(GraphicsContext gc){
        for(int i = 0; i< KARE_YUKSEKLIK; i++){
            for (int j = 0; j<KARE_GENISLIK; j++){
                if((i+j) % 2==0){
                    gc.setFill(Color.web("#000000"));
                }else {
                    gc.setFill(Color.web("#FFFFFF"));
                }
                gc.fillRect( i * KARE_BOYUTU,  j * KARE_BOYUTU, KARE_BOYUTU, KARE_BOYUTU);
            }
        }
    }


}