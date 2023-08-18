package com.alurachallenge2conversor.controller;

import com.alurachallenge2conversor.component.CountryListCell;
import com.alurachallenge2conversor.constans.CountryConstant;
import com.alurachallenge2conversor.model.Country;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrencyController implements Initializable{
    @FXML
    public JFXComboBox<Country> comboCurrencyInput;

    @FXML
    public JFXComboBox<Country> comboCurrencyOutput;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void uploadDataToComboBox() {
        CountryConstant.setCountries();
        ObservableList<Country> listCountries = FXCollections.observableArrayList(CountryConstant.countries);
        setItemIntoComboBox(listCountries);
    }

    private void setItemIntoComboBox(ObservableList<Country> listCountries) {
        comboCurrencyInput.setItems(listCountries);
        comboCurrencyInput.setCellFactory(param -> new CountryListCell());
        comboCurrencyInput.setButtonCell(new CountryListCell());

        comboCurrencyOutput.setItems(listCountries);
        comboCurrencyOutput.setCellFactory(param -> new CountryListCell());
        comboCurrencyOutput.setButtonCell(new CountryListCell());
    }
}
