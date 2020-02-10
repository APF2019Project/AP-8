package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayMenu implements Initializable {
    @FXML
    Button collection;
    @FXML
    Button day;
    @FXML
    Button water;
    @FXML
    Button zombie;
    @FXML
    Button rail;
    @FXML
    Button pVp;
    @FXML
    Button back;
    @FXML
    Button newCard;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        back.setOnAction(event -> {
            try {
                ViewHandler.loggedInManu();
            } catch (IOException e) {
                CreateAccountFrame.errorMessage("error in logged in menu");
            }
        });
}
}
