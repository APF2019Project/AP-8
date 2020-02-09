package controller;

import controller.boxExeption.InvalidIdException;
import controller.boxExeption.InvalidPasswordException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.entity.Account;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class logginFrame implements Initializable {
    @FXML
    TextField id;
    @FXML
    TextField pass;
    @FXML
    Button loggin;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggin.setOnAction(event -> {
            try {
                Account.loggIn(id.getText() , pass.getText());
                System.out.println("logged in");
                ViewHandler.loggedInManu();
            } catch (InvalidIdException e) {
                System.out.println("invalid id");
                id.setText("invalid id");
            } catch (InvalidPasswordException e) {
             pass.setText("invalid pass");
            } catch (IOException e) {
                System.out.println("an error occured");
            }
            if(Account.getLoggedInAccount()!=null){
                LogginMenuFrame.getLogin().close();
            }
        });
    }
}
