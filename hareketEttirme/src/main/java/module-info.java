module org.efs.hareketettirme {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.efs.hareketettirme to javafx.fxml;
    exports org.efs.hareketettirme;
}