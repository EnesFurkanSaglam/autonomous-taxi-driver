package org.efs.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static org.efs.demo.HareketliEngel.hareketEttir;
import static org.efs.demo.HareketliEngel.hareketliEngelOlustur;
import static org.efs.demo.HareketsizEngelKis.KisEngelOlustur;
import static org.efs.demo.HareketsizEngelYaz.YazEngelOlustur;
import static org.efs.demo.Hazine.HazineOlustur;
import static org.efs.demo.Hazine.enYakinHazineBul;
import static org.efs.demo.Karakter.*;
import static org.efs.demo.Kordinat.kordinatArrayListKarakter;
import static org.efs.demo.Lokasyon.KORDINATLAR;
import static org.efs.demo.Uygulama.findShortestPath;


public class HelloApplication extends Application{

     static  int GENISLIK = 1000;
     static  int YUKSEKLIK = 1000;
     static  int KARE_YUKSEKLIK = 50;
     static  int KARE_GENISLIK = 50;
     static final int KARE_BOYUTU = GENISLIK / KARE_YUKSEKLIK;
     static GraphicsContext gc;
     Button button1 = new Button("Devam et");
     Button button2 = new Button("Devam et");
     Button button3 = new Button("Oyunu Bitir");
     Button button4Baslat = new Button("Oyunu Başlat");
     Button button5Sifirla = new Button("Haritayı Sıfırla");

    TextField textFieldEngelYaz = new TextField();
    TextField textFieldEngelKis = new TextField();
    TextField textFieldEngelHareketli = new TextField();
    TextField textFieldHazine = new TextField();
    TextField textFieldHaritaXY = new TextField();
    static int engelYazSayisi;
    static int engelKisSayisi;
    static int hareketliEngelSayi;
    static int hazineSayisi;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage){

        Group group1 = new Group();
        sayfa1(group1,primaryStage);

        button1.setOnAction(actionEventIlk ->{

            Group group2 = new Group();
            sayfa2(group2,primaryStage);

            button2.setOnAction(actionEvent -> {

                KARE_YUKSEKLIK = Integer.parseInt(textFieldHaritaXY.getText());
                KARE_GENISLIK = Integer.parseInt(textFieldHaritaXY.getText());
                engelYazSayisi = Integer.parseInt(textFieldEngelYaz.getText());
                engelKisSayisi =  Integer.parseInt(textFieldEngelKis.getText());
                hareketliEngelSayi = Integer.parseInt(textFieldEngelHareketli.getText()) ;
                hazineSayisi = Integer.parseInt(textFieldHazine.getText());

                Group group3 = new Group();
                sayfa3(group3,primaryStage);

                button4Baslat.setOnAction(actionEvent1 -> {

                });

                button5Sifirla.setOnAction(actionEvent1 -> {

                    group3.getChildren().clear();
                    sayfa3(group3,primaryStage);

                });
            });
        });
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


    private void sayfa1(Group group,Stage primaryStage){

        primaryStage.setTitle("ANA EKRAN 1");
        Canvas canvas1 = new Canvas(GENISLIK,YUKSEKLIK);

        group.getChildren().add(canvas1);
        Scene scene1 = new Scene(group);
        primaryStage.setScene(scene1);
        primaryStage.show();
        gc = canvas1.getGraphicsContext2D();

        button1.setLayoutX(700);
        button1.setLayoutY(850);
        group.getChildren().add(button1);

        Text text1Ust = new Text("AKASYA DURAĞI");
        text1Ust.setFont(Font.font("Arial",60));
        text1Ust.setX(250);
        text1Ust.setY(100);
        group.getChildren().add(text1Ust);

        Text text1Alt =new Text(" Hoşgeldin oyuncu. Nasılsın,\n bugün seninle beraber amansız \n bir yolculuğa çıkacağız. Hazır mısın ? \n O zaman BAŞLAAAA ");
        text1Alt.setFont(Font.font("Arial",18));
        text1Alt.setX(600);
        text1Alt.setY(720);
        group.getChildren().add(text1Alt);

        Image imageUst = new Image("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/AnaEkran/" + "fotoUst.jpg");
        ImageView imageViewUst = new ImageView(imageUst);
        imageViewUst.setFitWidth(799);
        imageViewUst.setFitHeight(444);
        imageViewUst.setX(100);
        imageViewUst.setY(150);
        group.getChildren().add(imageViewUst);

        Image imageAlt = new Image("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/AnaEkran/" + "doblo.png");
        ImageView imageViewAlt = new ImageView(imageAlt);
        imageViewAlt.setX(50);
        imageViewAlt.setY(550);
        group.getChildren().add(imageViewAlt);

    }

    private void sayfa2(Group group,Stage primaryStage){

        primaryStage.setTitle("ANA EKRAN 2");
        Canvas canvas2 = new Canvas(GENISLIK,YUKSEKLIK);

        group.getChildren().add(canvas2);
        Scene scene2 = new Scene(group);
        primaryStage.setScene(scene2);
        primaryStage.show();
        gc = canvas2.getGraphicsContext2D();

        button2.setLayoutX(700);
        button2.setLayoutY(850);
        group.getChildren().add(button2);

        Image imageAlt = new Image("file:///C:/BEN/Kodlar/Proje/Proje_9_Uni_ProLab2_1/a_png/AnaEkran/" + "doblo.png");
        ImageView imageViewAlt = new ImageView(imageAlt);
        imageViewAlt.setX(100);
        imageViewAlt.setY(50);
        group.getChildren().add(imageViewAlt);

        Text textUst = new Text("Tekrar merhaba oyuncu \naşağıyı doldurman lazım\n\nEn iyi deneyim için\nharita boyutunu50*50 seçiniz");
        textUst.setFont(Font.font("Arial",24));
        textUst.setX(650);
        textUst.setY(250);
        group.getChildren().add(textUst);

        Text textEngelYaz = new Text("Yaz Engel Sayısı:");
        textEngelYaz.setFont(Font.font("Arial",24));
        textEngelYaz.setX(50);
        textEngelYaz.setY(600);
        group.getChildren().add(textEngelYaz);

        textFieldEngelYaz.setLayoutX(370);
        textFieldEngelYaz.setLayoutY(582);
        group.getChildren().add(textFieldEngelYaz);

        Text textEngelKis = new Text("Kış Engel Sayısı:");
        textEngelKis.setFont(Font.font("Arial",24));
        textEngelKis.setX(50);
        textEngelKis.setY(650);
        group.getChildren().add(textEngelKis);

        textFieldEngelKis.setLayoutX(370);
        textFieldEngelKis.setLayoutY(632);
        group.getChildren().add(textFieldEngelKis);

        Text textEngelHareketli = new Text("Harketli Engel Sayısı:");
        textEngelHareketli.setFont(Font.font("Arial",24));
        textEngelHareketli.setX(50);
        textEngelHareketli.setY(700);
        group.getChildren().add(textEngelHareketli);

        textFieldEngelHareketli.setLayoutX(370);
        textFieldEngelHareketli.setLayoutY(682);
        group.getChildren().add(textFieldEngelHareketli);


        Text textHazine = new Text("Kaçar Tane Hazine (4 çeşit) : ");
        textHazine.setFont(Font.font("Arial",24));
        textHazine.setX(50);
        textHazine.setY(750);
        group.getChildren().add(textHazine);


        textFieldHazine.setLayoutX(370);
        textFieldHazine.setLayoutY(732);
        group.getChildren().add(textFieldHazine);


        Text textHaritaXY = new Text("Harita Boyutu (AxA) :");
        textHaritaXY.setFont(Font.font("Arial",24));
        textHaritaXY.setX(50);
        textHaritaXY.setY(800);
        group.getChildren().add(textHaritaXY);


        textFieldHaritaXY.setLayoutX(370);
        textFieldHaritaXY.setLayoutY(782);
        group.getChildren().add(textFieldHaritaXY);
    }

    private void sayfa3(Group root, Stage primaryStage) {

        primaryStage.setTitle("OTONOM HAZİNE AVCISI");
        Canvas canvas = new Canvas(GENISLIK, YUKSEKLIK);
        root.getChildren().add(canvas);

        // Yeni bir Group oluşturarak sahne oluşturuluyor

        Scene scene = new Scene(new Group(root), GENISLIK, YUKSEKLIK);
        primaryStage.setScene(scene);
        primaryStage.show();
        gc = canvas.getGraphicsContext2D();
        run();
        Lokasyon lokasyon = new Lokasyon();

        button3.setLayoutX(900);
        button3.setLayoutY(950);
        root.getChildren().add(button3);

        button4Baslat.setLayoutX(20);
        button4Baslat.setLayoutY(20);
        root.getChildren().add(button4Baslat);

        button5Sifirla.setLayoutX(120);
        button5Sifirla.setLayoutY(20);
        root.getChildren().add(button5Sifirla);

        try {

            HazineOlustur(lokasyon, root);
            hareketliEngelOlustur(lokasyon, root);
            YazEngelOlustur(lokasyon, root);
            KisEngelOlustur(lokasyon, root);

            KarakterOlustur(lokasyon, root);
            lokasyon.HaritaMatrisYazdir();

            while (true) {

                Hazine hazine = enYakinHazineBul();
                if (hazine == null) {
                    System.out.println("Oyun bitti");
                    break;
                } else {

                    int[] start = {karakter.getIlkKonumY(), karakter.getIlkKonumX()};    // Karakterin başlangıç noktası ---  y-x die gircez
                    int[] target = {hazine.getY(), hazine.getX()};   // Hedef nokta (0 noktası)    -----   y-x die gircez
                    List<int[]> path = findShortestPath(KORDINATLAR, start, target);

                    if (path.size() == 0) {
                        System.out.println("Hedefe ulaşılamadı.");
                    } else {
                        System.out.println("En kısa yol:");
                        for (int[] point : path) {
                            System.out.println(Arrays.toString(point));

                            Kordinat kordinat = new Kordinat(point[1], point[0]);
                            kordinatArrayListKarakter.add(kordinat);
                        }
                    }

                    int[] sonKonum = path.get(path.size() - 1);
                    karakter.setIlkKonumX(sonKonum[1]);
                    karakter.setIlkKonumY(sonKonum[0]);

                }
            }

            karakterHareket();
            hareketEttir();

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }


}
