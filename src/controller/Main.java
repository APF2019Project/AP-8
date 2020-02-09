package controller;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
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
    public void start(Stage stage) throws Exception  {
            new ViewHandler().play();
            ViewHandler.stage=stage;
            stage.setResizable(false);
            ViewHandler.loadingFrame(stage);
        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished( event -> {
            try {
                ViewHandler.logginMenu(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        delay.play();

    }
    public static void main(String[] args)throws Exception {
        launch(args);
        //Scanner scanner = new Scanner(System.in);
        //commandLine(scanner);
        // covertCardsToJsonString.setZombieFields();
//        covertCardsToJsonString.setPlantFields();
    }
}
