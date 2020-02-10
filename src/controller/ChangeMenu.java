package controller;

import controller.boxExeption.InvalidIdException;
import controller.boxExeption.InvalidPasswordException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.entity.Account;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangeMenu implements Initializable {
    @FXML
    TextField id;
    @FXML
    PasswordField password;
    @FXML
    Button change;
    @FXML
    Button back;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        back.setOnAction(event -> {
            try {
                ViewHandler.Profile();
            } catch (IOException e) {
                CreateAccountFrame.errorMessage("an error in profile Menu");
            }
        });
        change.setOnAction(event -> {
            Account.logOut();
            try {
                Account.loggIn(id.getText() , password.getText());
                ViewHandler.Profile();
            } catch (InvalidIdException e) {
                CreateAccountFrame.errorMessage("invalid id");
            } catch (InvalidPasswordException e) {
                CreateAccountFrame.errorMessage("invalid password");
            } catch (IOException e) {
                CreateAccountFrame.errorMessage("an error in profile menu");
            }
        });
    }
}
