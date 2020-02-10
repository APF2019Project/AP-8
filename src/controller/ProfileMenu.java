package controller;

import javafx.fxml.FXML;
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

public class ProfileMenu implements Initializable {
    @FXML
    Button show;
    @FXML
    Button delete;
    @FXML
    Button change;
    @FXML
    Button rename;
    @FXML
    Button create;
    @FXML
    Button back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        show.setOnAction(event -> {
            showProfile();
        });
        back.setOnAction(event -> {
            try {
                ViewHandler.loggedInManu();
            } catch (IOException e) {
                System.out.println("error in logged in menu");
            }
        });
        delete.setOnAction(event1 -> {
            System.out.println("delete clicked");
            try {
                ViewHandler.deleteMenu();
            } catch (IOException e) {
                CreateAccountFrame.errorMessage("an error in delete menu");
            }
        });
        change.setOnAction(event -> {
            try {
                ViewHandler.changeMenu();
            } catch (IOException e) {
                CreateAccountFrame.errorMessage("an error in change menu");
            }
        });
        rename.setOnAction(event -> {
            try {
                ViewHandler.renameMenu();
            } catch (IOException e) {
                CreateAccountFrame.errorMessage("an error in rename menu");
            }
        });
        create.setOnAction(event -> {
            try {
                ViewHandler.createP();
            } catch (IOException e) {
                CreateAccountFrame.errorMessage("an error in createP");
            }
        });
    }

    public void showProfile() {
        Stage showProfile = new Stage();
        Group root = new Group();
        Button back = new Button();
        root.getChildren().add(back);
        back.setText("back");
        back.relocate(100 , 415);
        back.setOnAction(event -> {
            try {
                ViewHandler.Profile();
                showProfile.close();
            } catch (IOException e) {
                System.out.println("error in profil");
            }
        });
        Scene scene = new Scene(root, 300, 450);
        ListView<String> listView = new ListView();
        Account.getAccounts().sort(Comparator.comparingInt(Account::getNumberOfKiledZombies));
        listView.getItems().add( "name: "+ Account.loggedInAccount.getName());
        listView.getItems().add("Killed Zombies: " +Integer.toString(Account.loggedInAccount.getNumberOfKiledZombies()));
        listView.getItems().add("coins : "+Integer.toString(Account.loggedInAccount.getCoins()));
        HBox box = new HBox(listView);
        root.getChildren().add(box);
        showProfile.setScene(scene);
        showProfile.show();
    }
}
