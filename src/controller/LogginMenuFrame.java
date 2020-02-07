package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogginMenuFrame implements Initializable {
    private static Stage login;
    private static Stage createAccount;
    @FXML
    Button loggin ;
    @FXML
    Button create;
    @FXML
    Button leader;
    public static Stage getLogin(){
        return login ;
    }
    public static Stage getCreate(){
        return createAccount;
    }

    private static void handleCreateMenuView(ActionEvent event) {
        createAccount = new Stage();
        createAccount.setResizable(false);
        try {
            createAccount.setScene(new Scene(FXMLLoader.load(ViewHandler.class.getResource("/controller/FXMLS/createAccount.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        createAccount.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggin.setOnMouseClicked(event -> {
            login = new Stage();
            login.setResizable(false);
            login.setTitle("loggin");
            try {
                login.setScene(new Scene(FXMLLoader.load(ViewHandler.class.getResource("/controller/FXMLS/logginFrame.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            login.show();
        });
        create.setOnAction(LogginMenuFrame::handleCreateMenuView);
    }
}
