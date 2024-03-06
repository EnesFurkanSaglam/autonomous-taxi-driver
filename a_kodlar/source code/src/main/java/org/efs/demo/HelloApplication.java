package org.efs.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




import static org.efs.demo.HareketliEngel.hareketliEngelOlustur;
import static org.efs.demo.HareketsizEngelKis.KisEngelOlustur;
import static org.efs.demo.HareketsizEngelYaz.YazEngelOlustur;
import static org.efs.demo.Hazine.HazineOlustur;
import static org.efs.demo.Karakter.KarakterOlustur;

public class HelloApplication extends Application{

     static final int GENISLIK = 1000;
     static final int YUKSEKLIK = 1000;
     static final int KARE_YUKSEKLIK = 30;
     static final int KARE_GENISLIK = 30;
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

        Lokasyon lokasyon = new Lokasyon();


        HazineOlustur(lokasyon,root);
        hareketliEngelOlustur(lokasyon,root);
        YazEngelOlustur(lokasyon,root);
        KisEngelOlustur(lokasyon,root);
        KarakterOlustur(lokasyon,root);

        //hareketEttir();
        lokasyon.HaritaMatrisYazdir();

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
    /*
    public static void playMusic(String musicFilePath) {
        String musicFilePath = "C:\\BEN\\Kodlar\\Proje\\Proje_9_Uni_ProLab2_1\\a_vaw\\a.wav"; // müzik dosyasının yolu
        playMusic(musicFilePath);
        try {
            FileInputStream fileInputStream = new FileInputStream(musicFilePath);
            Player player = new Player(fileInputStream);
            player.play();

        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }


    }

     */

}
