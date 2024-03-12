package org.example.arayuz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        Button button = new Button("Değeri Al");
        Label label = new Label();

        button.setOnAction(e -> {
            String value = textField.getText();
            label.setText("Girilen Değer: " + value);
        });

        VBox vbox = new VBox(10, textField, button, label);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Kullanıcıdan Değer Al");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
