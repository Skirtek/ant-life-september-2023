module com.codecool.antlife {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens com.codecool.antlife to javafx.fxml;
    exports com.codecool.antlife;
}