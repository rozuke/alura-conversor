package com.alurachallenge2conversor.component;

import com.alurachallenge2conversor.model.Country;
import com.jfoenix.controls.JFXListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class CountryListCell extends JFXListCell<Country> {
    @Override
    public void updateItem(Country country, boolean empty) {
        super.updateItem(country, empty);
        if (empty || country == null) {
            setText("");
            setGraphic(null);
        } else {
            setText(country.toString());
            ImageView imageView = new ImageView();
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);

            String fileLocation = "/com/alurachallenge2conversor/assets/countries/" + country.getCodeFlag() + ".png";
            Image image = new Image(getClass().getResource(fileLocation).toExternalForm());

            imageView.setImage(image);
            setGraphic(imageView);
        }
    }
}
