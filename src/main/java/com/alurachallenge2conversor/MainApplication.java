package com.alurachallenge2conversor;

import com.alurachallenge2conversor.constans.CountryConstant;
import com.alurachallenge2conversor.controller.CurrencyController;
import com.alurachallenge2conversor.model.Country;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1086, 646);

        CurrencyController currencyController = fxmlLoader.getController();
        currencyController.uploadDataToComboBox();
        stage.setTitle("Challenge 2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        CountryConstant.setMapCountries();
//        for (Map.Entry<String, Country> entry : CountryConstant.mapCountries.entrySet()) {
//            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue().getCodeCurrency() + " - " + entry.getValue().getCountryNameCurrency());
//        }
        launch();
    }
}