module org.efs.imagesinifi {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.efs.imagesinifi to javafx.fxml;
    exports org.efs.imagesinifi;
}