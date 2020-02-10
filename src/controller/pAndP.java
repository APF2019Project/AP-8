package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class pAndP implements Initializable {
    @FXML
    Button profile;
    @FXML
    Button play;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        profile.setOnAction(event -> {
            try {
                ViewHandler.Profile();
            } catch (IOException e) {
                System.out.println("error in profile menu");
            }
        });
        play.setOnAction(event -> {
            try {
                ViewHandler.playMenu();
            } catch (IOException e) {
                CreateAccountFrame.errorMessage("an error in play menu");
            }
        });
    }
}
