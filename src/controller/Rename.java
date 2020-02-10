package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.entity.Account;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Rename implements Initializable {
    @FXML
    TextField name;
    @FXML
    Button rename;
    @FXML
    Button back;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(Account.loggedInAccount.getName());
        rename.setOnAction(event -> {
            Account.loggedInAccount.setName(name.getText());
        });
        back.setOnAction(event -> {
            try {
                ViewHandler.Profile();
            } catch (IOException e) {
                CreateAccountFrame.errorMessage("an error in profile menu");
            }
        });
    }
}
