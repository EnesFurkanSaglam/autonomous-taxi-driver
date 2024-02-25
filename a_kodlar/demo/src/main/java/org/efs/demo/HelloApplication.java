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
    private static final int GENISLIK = 1000;
    private static final int YUKSEKLIK = 1000;
    private static final int KARE_YUKSEKLIK = 25;
    private static final int KARE_GENISLIK = 25;
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
        Engel kus = new HareketliEngel("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Hareketli Engeller/",
                "kus.png",(int) (Math.random() * KARE_YUKSEKLIK),(int) (Math.random() * KARE_GENISLIK),2,2,"Y",5);
        Engel ari = new HareketliEngel("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Hareketli Engeller/",
                "ari.png",(int) (Math.random() * KARE_YUKSEKLIK),(int) (Math.random() * KARE_GENISLIK),2,2,"X",3);
        Engel buzdagi = new HarektsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
                "buz dagi.png",(int) (Math.random() * KARE_YUKSEKLIK),(int) (Math.random() * KARE_GENISLIK),15,15);
        Engel kutupayisi = new HarektsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
                "kutup ayisi.png",(int) (Math.random() * KARE_YUKSEKLIK),(int) (Math.random() * KARE_GENISLIK),5,5);
        Engel penguen = new HarektsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
                "penguen.png",(int) (Math.random() * KARE_YUKSEKLIK),(int) (Math.random() * KARE_GENISLIK),5,5);
        Engel kardanadam = new HarektsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
                "kardan adam.png",(int) (Math.random() * KARE_YUKSEKLIK),(int) (Math.random() * KARE_GENISLIK),5,5);
        Engel buz = new HarektsizEngelKis("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Kış Engelleri/",
                "buz.png",(int) (Math.random() * KARE_YUKSEKLIK),(int) (Math.random() * KARE_GENISLIK),2,2);
        Engel agac = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
                "agac.png",(int) (Math.random() * KARE_YUKSEKLIK),(int) (Math.random() * KARE_GENISLIK),5,5);
        Engel dag = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
                "dag.png",(int) (Math.random() * KARE_YUKSEKLIK),(int) (Math.random() * KARE_GENISLIK),5,5);
        Engel duvar = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
                "duvar.png",(int) (Math.random() * KARE_YUKSEKLIK),(int) (Math.random() * KARE_GENISLIK),3,3);
        Engel kaya = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
                "kaya.png",(int) (Math.random() * KARE_YUKSEKLIK),(int) (Math.random() * KARE_GENISLIK),3,3);
        Engel gunes = new HareketsizEngelYaz("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/",
                "gunes.png",(int) (Math.random() * KARE_YUKSEKLIK),(int) (Math.random() * KARE_GENISLIK),5,5);

        ArrayList<HareketliEngel> hareketliEngelArrayList = new ArrayList<>();
        hareketliEngelArrayList.add((HareketliEngel) kus);
        hareketliEngelArrayList.add((HareketliEngel) ari);

        ArrayList<HareketsizEngelYaz> hareketsizEngelYazArrayList = new ArrayList<>();
        hareketsizEngelYazArrayList.add((HareketsizEngelYaz) agac);
        hareketsizEngelYazArrayList.add((HareketsizEngelYaz) dag);
        hareketsizEngelYazArrayList.add((HareketsizEngelYaz) duvar);
        hareketsizEngelYazArrayList.add((HareketsizEngelYaz) kaya);
        hareketsizEngelYazArrayList.add((HareketsizEngelYaz) gunes);

        ArrayList<HarektsizEngelKis> hareketsizEngelKisArrayList = new ArrayList<>();
        hareketsizEngelKisArrayList.add((HarektsizEngelKis) buzdagi);
        hareketsizEngelKisArrayList.add((HarektsizEngelKis) penguen);
        hareketsizEngelKisArrayList.add((HarektsizEngelKis) kardanadam);
        hareketsizEngelKisArrayList.add((HarektsizEngelKis) buz);
        hareketsizEngelKisArrayList.add((HarektsizEngelKis) kutupayisi);






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

        YazEngelOlustur();
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



    private void YazEngelOlustur() {   //

        engelX = (int) (Math.random() * KARE_YUKSEKLIK);
        engelY = (int) (Math.random() * KARE_GENISLIK);

        String imagePath = "file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/Yaz Engelleri/";

        imageYazEngel = new Image(imagePath + YAZ_ENGEL[(int) (Math.random() * YAZ_ENGEL.length)]);
        gc.drawImage(imageYazEngel, engelX * KARE_BOYUTU, engelY * KARE_BOYUTU, KARE_BOYUTU, KARE_BOYUTU);

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

    }




}
