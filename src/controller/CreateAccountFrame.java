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

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccountFrame implements Initializable {

    @FXML
    TextField name;
    @FXML
    TextField id;
    @FXML
    PasswordField password;
    @FXML
    PasswordField repassword;
    @FXML
    Button create;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        create.setOnAction(event -> {
//            try {
//               // Account.createAccount(name.getText() , id.getText() , password.getText() , repassword.getText());
//            } catch (DosentMatchPasswordException e) {
//                //new Stage().setScene(new );
//            } catch (InvalidIdException e) {
//
//            } catch (InvalidPasswordException e) {
//                e.printStackTrace();
//            }
        });
    }
}
