package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {
    public static Stage stage;
    public void play(){
        AudioClip audioClip = new AudioClip(getClass().getResource("/controller/FXMLS/04. Day of the Dead.mp3").toString());
        audioClip.play();
    }
    public static void loadingFrame(Stage stage) throws IOException {

        stage.setTitle("Loading...");
        // primaryStage.setScene(new Scene( FXMLLoader.load(getClass().getResource("controller/FXMLS/loadingFrame.fxml"))));
        stage.setScene(new Scene(FXMLLoader.load(ViewHandler.class.getResource("/controller/FXMLS/loadingFrame.fxml"))));
        stage.show();
    }
    public static void logginMenu(Stage stage) throws IOException {
        stage.setTitle("logginMenu");
        stage.setScene(new Scene(FXMLLoader.load(ViewHandler.class.getResource("/controller/FXMLS/logginMenu.fxml"))));
        stage.show();
    }
    public static void loggedInManu() throws IOException {
        stage.setTitle("loggedInMenu");
        stage.setScene(new Scene(FXMLLoader.load(ViewHandler.class.getResource("/controller/FXMLS/pANDp.fxml"))));
        stage.show();
    }
    public static void Profile() throws IOException {
        stage.close();
        stage.setTitle("Profile");
        stage.setScene(new Scene(FXMLLoader.load(ViewHandler.class.getResource("/controller/FXMLS/ProfileMenu.fxml"))));
        stage.show();
    }
    public static void deleteMenu() throws IOException {
        stage.close();
        stage.setTitle("deleteMenu");
        stage.setScene(new Scene(FXMLLoader.load(ViewHandler.class.getResource("/controller/FXMLS/DeleteMenu.fxml"))));
        stage.show();
    }
    public static void changeMenu() throws IOException {
        stage.close();
        stage.setTitle("changeMenu");
        stage.setScene(new Scene(FXMLLoader.load(ViewHandler.class.getResource("/controller/FXMLS/ChangeMenu.fxml"))));
        stage.show();
    }
    public static void renameMenu() throws IOException {
        stage.close();
        stage.setTitle("renameMenu");
        stage.setScene(new Scene(FXMLLoader.load(ViewHandler.class.getResource("/controller/FXMLS/RenameMenu.fxml"))));
        stage.show();
    }
    public static void createP() throws IOException {
        stage.close();
        stage.setTitle("createAccount");
        stage.setScene(new Scene(FXMLLoader.load(ViewHandler.class.getResource("/controller/FXMLS/CreateAccountP.fxml"))));
        stage.show();
    }
    public static void playMenu() throws IOException {
        stage.close();
        stage.setTitle("PlayMenu");
        stage.setScene(new Scene(FXMLLoader.load(ViewHandler.class.getResource("/controller/FXMLS/PlayMenu.fxml"))));
        stage.show();
    }

}
