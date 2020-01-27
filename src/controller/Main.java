package controller;

import model.entity.CovertCardsToJsonString;
import model.repository.*;
import model.sevice.DayGame;
import model.sevice.PlayMenu;
import model.sevice.PvpGame;
import model.sevice.WaterGame;
import view.Command;

import java.util.Scanner;


public class Main {
    public static Command command = new Command();
    public static DayGame dayGame = new DayGame();
    public static CovertCardsToJsonString covertCardsToJsonString = new CovertCardsToJsonString();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        LogginMenu.setInput(scanner);
        MainMenu.setInput(scanner);
        Profile.setInput(scanner);
        Shop.setInput(scanner);
        LeaderBoard.setInput(scanner);
        PlayMenu.setInput(scanner);
        DayGame.setInput(scanner);
        PvpGame.setInput(scanner);
        WaterGame.setInput(scanner);
        LogginMenu.getInputForLogginMenu();
       // covertCardsToJsonString.setZombieFields(scanner);
//        covertCardsToJsonString.setInput(scanner);
//        covertCardsToJsonString.setPlantFields();
        }
}
