package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class LogginMenuFrame implements Initializable {
    @FXML
    Button loggin ;
    @FXML
    Button create;
    @FXML
    Button leader;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggin.setOnMouseClicked(event -> {
        });
    }
}
