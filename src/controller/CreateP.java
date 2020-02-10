package controller;

import controller.boxExeption.DosentMatchPasswordException;
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

public class CreateP implements Initializable {
    @FXML
    TextField name;
    @FXML
    TextField id;
    @FXML
    PasswordField pass;
    @FXML
    PasswordField repass;
    @FXML
    Button create;
    @FXML
    Button back;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        create.setOnAction(event -> {
            try {
                Account.createAccount(name.getText() , id.getText(),pass.getText() , repass.getText());
            } catch (InvalidIdException e) {
                CreateAccountFrame.errorMessage("Invalid id");
            } catch (InvalidPasswordException e) {
                CreateAccountFrame.errorMessage("Invalid Pass");
            } catch (DosentMatchPasswordException e) {
                CreateAccountFrame.errorMessage("invalid pass");
            }
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
