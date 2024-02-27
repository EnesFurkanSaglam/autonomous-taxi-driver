package org.efs.hareketettirme;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class  HelloApplication extends Application {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int RADIUS = 20;
    private static final int SPEED = 5;

    private Circle circle;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        circle = new Circle(RADIUS, Color.RED);
        circle.relocate(WIDTH / 2, HEIGHT / 2);

        root.getChildren().add(circle);

        // Hareket animasyonunu oluştur
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.01),
                        e -> moveCircle())
        );
        timeline.setCycleCount(Animation.INDEFINITE); // Sonsuz döngü
        timeline.play();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void moveCircle() {
        // Dairenin X koordinatı
        double x = circle.getCenterX();
        // Dairenin hareket hızı ve yönü
        double dx = SPEED;
        if (x + RADIUS >= WIDTH || x - RADIUS <= 0) {
            // Eğer kenarlara ulaşıldıysa, yönü tersine çevir
            dx *= -1;
        }
        // Yeni X koordinatını ayarla
        circle.setCenterX(x + dx);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
