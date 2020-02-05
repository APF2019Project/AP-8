package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.entity.CovertCardsToJsonString;
import model.repository.*;
import model.sevice.DayGame;
import model.sevice.PlayMenu;
import model.sevice.PvpGame;
import model.sevice.WaterGame;
import view.Command;

import java.io.IOException;
import java.util.Scanner;


public class Main extends Application {
    public static Command command = new Command();
    public static DayGame dayGame = new DayGame();
    public static CovertCardsToJsonString covertCardsToJsonString = new CovertCardsToJsonString();

        static void commandLine(Scanner scanner){

            LogginMenu.setInput(scanner);
            MainMenu.setInput(scanner);
            Profile.setInput(scanner);
            Shop.setInput(scanner);
            LeaderBoard.setInput(scanner);
            PlayMenu.setInput(scanner);
            DayGame.setInput(scanner);
            PvpGame.setInput(scanner);
            WaterGame.setInput(scanner);
            Collection.setInput(scanner);
            LogginMenu.getInputForLogginMenu();
        }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Loading...");
        primaryStage.setScene(new Scene( FXMLLoader.load(getClass().getResource("controller/FXMLS/loadingFrame.fxml"))));
        primaryStage.show();
}
    public static void main(String[] args)  {
        launch(args);
        //Scanner scanner = new Scanner(System.in);
        //commandLine(scanner);
        // covertCardsToJsonString.setZombieFields(scanner);
//        covertCardsToJsonString.setInput(scanner);
//        covertCardsToJsonString.setPlantFields();
        }
}
