package controller;

import controller.boxExeption.DosentMatchPasswordException;
import controller.boxExeption.InvalidIdException;
import controller.boxExeption.InvalidPasswordException;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
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
            try {
                Account.createAccount(name.getText() , id.getText() , password.getText() , repassword.getText());
                LogginMenuFrame.getCreate().close();
            } catch (DosentMatchPasswordException e) {
                errorMessage("passwords dosent Matched");
            } catch (InvalidIdException e) {
                errorMessage("Id is Invalid ");
            } catch (InvalidPasswordException e) {
                errorMessage("Invalid password");
            }
        });
    }
    public static void errorMessage(String string){
        Stage error = new Stage();
        Group root = new Group();
        Scene errorScene = new Scene(root , 20 , 20);
        error.setResizable(false);
        Label errorLable = new Label(string);
        root.getChildren().add(errorLable);
        error.setScene(errorScene);
        error.show();
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(event -> {
            error.close();
        });
        delay.play();
    }
}
