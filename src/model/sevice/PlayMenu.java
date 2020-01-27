package model.sevice;

import model.repository.MainMenu;

import java.util.Scanner;

public class PlayMenu {
    private static Scanner input ;
    public static void setInput(Scanner input) {
        PlayMenu.input = input;
    }
    public static void takeInputForPlayMenu(){
        try {
            System.out.println("----------PLAY_MENU-----------");
            System.out.println("enter one of this game types" +
                    "day" +
                    "water" +
                    "pvp" +
                    "zombie" +
                    "rail" +
                    "back");
            String str = input.nextLine();
            switch (str) {
                case "day":
                    DayGame.takeInput();
                    takeInputForPlayMenu();
                    break;
                case "water":
                    WaterGame.takeInput();
                    takeInputForPlayMenu();
                    break;
                case "pvp":
                    PvpGame.takeInput();
                    takeInputForPlayMenu();
                    break;
                case "zombie":
                    ZombeiGame.takeInput();
                    takeInputForPlayMenu();
                    break;
                case "rail":
                    RailGame.takeInput();
                    takeInputForPlayMenu();
                    break;
                case "back":
                    MainMenu.mainMenuGetInput();
                    break;
                default:
                    takeInputForPlayMenu();

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
