package model.sevice;


import model.entity.Card;
import model.entity.Map;
import model.entity.Plant;
import model.repository.Player;
import model.repository.PlayerType;

import java.util.ArrayList;
import java.util.Scanner;

public class PvpGame extends Game {
    private static ArrayList<Card> cards = new ArrayList<Card>(7);
    private static Scanner input;
    private static Player GIYAHJAR;
    private static Player ZOMBIE;
    private static Plant temp;
    private static Map map = new Map("water");

    public PvpGame(PlayerType player_One_Type, PlayerType player_Two_Type, int wave) {
        super(true, wave, "PVP");
    }

    public static void setInput(Scanner scanner) {
        input = scanner;
    }

    public static void takeInput()throws Exception {
        System.out.println("---------pvp GAME---------");
        System.out.println("enter one of below commands" +
                "showHand" +
                "select" +
                "plant" +
                "remove " +
                "ready" +
                "show lawn");
        String[] splitedInput = input.nextLine().split(" ");
        if (splitedInput[0].equals("ready")) {
            ZombeiGame.takeInput();
        }else {
            DayGame.takeInput();
        }
    }
}
