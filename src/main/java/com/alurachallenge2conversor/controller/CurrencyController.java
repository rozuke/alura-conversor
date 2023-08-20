package com.alurachallenge2conversor.controller;

import com.alurachallenge2conversor.component.CountryListCell;
import com.alurachallenge2conversor.constans.CountryConstant;
import com.alurachallenge2conversor.model.Country;
import com.alurachallenge2conversor.model.Currency;
import com.alurachallenge2conversor.util.Util;
import com.jfoenix.controls.JFXTextArea;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class CurrencyController implements Initializable{
    @FXML
    public JFXComboBox<Country> comboCurrencyInput;
    @FXML
    public JFXComboBox<Country> comboCurrencyOutput;
    @FXML
    public JFXTextArea textAreaInput;
    @FXML
    public JFXTextArea textAreaOutput;
    @FXML
    public Label labelResult;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void uploadDataToComboBox() {
        CountryConstant.setCountries();
        ObservableList<Country> listCountries = FXCollections.observableArrayList(CountryConstant.countries);
        setItemIntoComboBox(listCountries);
    }
    public void checkTextArea() {
        textAreaInput.setTextFormatter(setFormatter());
        textAreaOutput.setTextFormatter(setFormatter());
        textAreaInput.setText("");
        textAreaOutput.setText("");

    }
    public void addListenerToComponents(Currency currency) {

        comboCurrencyInput.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateConversion(currency);
                });
        textAreaInput.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.isEmpty()) {
                        textAreaOutput.setText("");
                    } else {
                        updateConversion(currency);
                    }
                }
        );
        comboCurrencyOutput.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateConversion(currency);
                }
        );


    }

    public void swapComboBoxValue() {
        int indexInput = comboCurrencyInput.getSelectionModel().getSelectedIndex();
        int indexOutput = comboCurrencyOutput.getSelectionModel().getSelectedIndex();

        if (indexOutput >= 0 && indexInput >= 0) {
            comboCurrencyInput.getSelectionModel().select(indexOutput);
            comboCurrencyOutput.getSelectionModel().select(indexInput);
        }
    }

    private void updateConversion(Currency currencyResponse) {
        Country countryInput = comboCurrencyInput.getSelectionModel().getSelectedItem();
        Country countryOutput = comboCurrencyOutput.getSelectionModel().getSelectedItem();
        String numberInput = textAreaInput.getText();
        if (countryInput != null && countryOutput != null && !numberInput.equals("")) {

            double inputValue = 0.0;
            try {
                inputValue = Double.parseDouble(numberInput);
            } catch (NumberFormatException numberFormatException) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("!!Aviso!!");
                alert.setHeaderText("Los valores ingresados no son correctos");
                alert.setContentText("Corrije los valores ingresados");
                alert.showAndWait();
            }
            String outputValue = Util.convertCurrency(inputValue, Util.getRatesFromAPI(currencyResponse, countryInput.getCodeCurrency()), Util.getRatesFromAPI(currencyResponse, countryOutput.getCodeCurrency()));
            System.out.println(outputValue);
            Platform.runLater(() -> {
                textAreaOutput.clear();
                textAreaOutput.appendText(outputValue);
            });
        }
    }
    private void updateTextOutput(double value) {
        textAreaOutput.setText(String.valueOf(value));
    }

    private TextFormatter<Integer> setFormatter() {
        return new TextFormatter<Integer>(new IntegerStringConverter(), 0,
                change -> change.getControlNewText().matches("\\d*\\.?\\d*") ? change : null
        );
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
