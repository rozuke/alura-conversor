module com.alurachallenge2conversor {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires com.google.gson;
    requires okhttp3;


    opens com.alurachallenge2conversor to javafx.fxml;
    exports com.alurachallenge2conversor;
    exports com.alurachallenge2conversor.model;
    exports com.alurachallenge2conversor.controller;
}