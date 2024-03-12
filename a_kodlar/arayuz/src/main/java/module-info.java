module org.example.arayuz {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.arayuz to javafx.fxml;
    exports org.example.arayuz;
}