module com.alurachallenge2conversor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alurachallenge2conversor to javafx.fxml;
    exports com.alurachallenge2conversor;
}