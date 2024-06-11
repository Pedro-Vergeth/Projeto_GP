module com.example.projetogp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.projetogp to javafx.fxml;
    exports com.example.projetogp;
    exports com.example.projetogp.controllers;
    opens com.example.projetogp.controllers to javafx.fxml;
}