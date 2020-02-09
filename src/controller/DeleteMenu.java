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

public class DeleteMenu implements Initializable {
    @FXML
    TextField id;
    @FXML
    PasswordField pass;
    @FXML
    Button delete;
    @FXML
    Button back;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        back.setOnAction(event -> {
            try {
                ViewHandler.Profile();
            } catch (IOException e) {
                CreateAccountFrame.errorMessage("an error in profile");
            }
        });
        delete.setOnAction(event1 -> {
            try {
                Account.deleteAccount(id.getText() , pass.getText());
                CreateAccountFrame.errorMessage("account deleted");
                ViewHandler.Profile();
            } catch (InvalidIdException e) {
                CreateAccountFrame.errorMessage("invalid ID" );
            } catch (InvalidPasswordException e) {
                CreateAccountFrame.errorMessage("Invalid password");
            } catch (IOException e) {
                CreateAccountFrame.errorMessage("an error in profile");
            }
        });
    }
}
