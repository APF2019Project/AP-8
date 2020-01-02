package model.sevice;

import controller.boxExeption.InvalidBulletTypeExeption;
import controller.boxExeption.InvalidPlantTypeExeption;
import model.entity.*;
import model.repository.Collection;
import model.repository.Player;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DayGame extends Game {
    static HashMap<String,Card> zombieHashmap = new HashMap<>(7);
    private static Scanner input;
    private static int coolDown;
    private static int turn = 0;
    private static int waveTurn = 7;
    private static int wave = 3; // chanta moj dare
    private static Map map = new Map("land");
    private static Player player;
    private static Plant temp;
    private static HashMap<String, Card> selectedPlantCards = new HashMap<>(7);
    private boolean endTurn = false;

    public DayGame() {
        super(false, 3, "DAY");
    }

    public static void takeInput() throws Exception {
        System.out.println("---------DAY GAME---------");
        System.out.println("enter one of below commands" +
                "showHand" +
                "select" +
                "plant" +
                "remove " +
                "end turn" +
                "show lawn");
        String[] splitedInput = input.nextLine().split(" ");
        switch (splitedInput[0]) {
            case "showHand":
                selectedPlantCards = Collection.getCollection();
                showSelectedCards();
                break;
            case "select":
                temp = selectCard(splitedInput[1]);
            case "plant":
                temp.plantingByXandY(Integer.parseInt(splitedInput[1]), Integer.parseInt(splitedInput[2]));
            case "remove":
                if (map.getCell(Integer.parseInt(splitedInput[1]), Integer.parseInt(splitedInput[2])).isHasPlant() == true) {
                    map.getCell(Integer.parseInt(splitedInput[1]), Integer.parseInt(splitedInput[2])).removeAllPlantInThisCell();
                }
                break;
            case "end turn":

            case "show lawn":


        }
    }

    private static void showSelectedCards() {
        for (String name : selectedPlantCards.keySet()) {
            System.out.println(selectedPlantCards.get(name).getName());
        }
    }

    public static Plant selectCard(String name) throws Exception {
        if (Collection.getCollection().containsKey(name)) {
            try {
                if (CovertCardsToJsonString.getPlantFromJsonString(name).getPlantingPrice() <= player.getNumberOfSun() && CovertCardsToJsonString.getPlantFromJsonString(name).charging() == true) {
                    return CovertCardsToJsonString.getPlantFromJsonString(name);
                }
            } catch (InvalidPlantTypeExeption | InvalidBulletTypeExeption | FileNotFoundException invalidPlantTypeExeption) {
                invalidPlantTypeExeption.printStackTrace();
            }
        }
        return null;
    }

    public static void setInput(Scanner scanner) {
        input = scanner;
    }

    public static void showLawn() {

    }

//    public static void runWave() {
//        if (turn == 3) {
//            for (Zombie z : zombies) {
//                z.put_Zombie();
//            }
//        } else if (waveTurn == 0) {
//            for (Zombie z : zombies) {
//                z.put_Zombie();
//                waveTurn = 7;
//            }
//        }
//        waveTurn--;
//    }
//    public static ArrayList<Zombie> addZombies(){
//        ArrayList<Zombie> zombies = new ArrayList<Zombie>();
//        for (String str: zombieHashmap.keySet()) {
//            CovertCardsToJsonString.getZombeiFromJsonString(zombieHashmap.keySet())
//        }
//    }
}


