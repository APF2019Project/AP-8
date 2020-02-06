package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {
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
}
