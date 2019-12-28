package controller;

import model.entity.CovertCardsToJsonString;
import model.sevice.DayGame;
import view.Command;

import java.util.Scanner;


public class Main {
    public static Command command = new Command();
    public static DayGame dayGame = new DayGame();
    public static CovertCardsToJsonString covertCardsToJsonString = new CovertCardsToJsonString();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        //covertCardsToJsonString.setZombieFields(scanner);
        //covertCardsToJsonString.setPlantFields(scanner);
        System.out.println(dayGame.randomAccess());
    }
}
