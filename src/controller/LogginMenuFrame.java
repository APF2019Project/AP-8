package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.entity.Account;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
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
        leader.setOnAction(event -> {
            Stage leader = new Stage();
            Group root = new Group();
            Scene scene = new Scene(root , 300 , 450);
            ListView<String> listView = new ListView();
            Account.getAccounts().sort(Comparator.comparingInt(Account::getNumberOfKiledZombies));
            for (Account ac: Account.getAccounts()) {
                listView.getItems().add(ac.getName() + "----------" + ac.getNumberOfKiledZombies());
            }
            if(listView.getItems().size()==0)
                listView.getItems().add("not loaded any account");
            HBox box = new HBox(listView );
            root.getChildren().add(box);
            leader.setScene(scene);
            leader.show();
        });
    }
}
