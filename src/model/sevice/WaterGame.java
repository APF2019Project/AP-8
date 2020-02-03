package model.sevice;

import controller.boxExeption.InvalidBulletTypeExeption;
import controller.boxExeption.InvalidPlantTypeExeption;
import model.entity.Card;
import model.entity.CovertCardsToJsonString;
import model.entity.Map;
import model.entity.Plant;
import model.repository.Collection;
import model.repository.CollectionInterFace;
import model.repository.Player;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class WaterGame extends Game {
    private static ArrayList<Card> cards = new ArrayList<Card>(7);
    private static Scanner input;
    private static Player player;
    private static Plant temp;
    private static Map map = new Map("water");


    public WaterGame() {
        super(false, 3, "WATER");
    }

    public static void setInput(Scanner scanner) {
        input = scanner;
    }

    public static void takeInput() throws Exception {
        System.out.println("---------WATER GAME---------");
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
                cards = CollectionInterFace.returnCards("DAY");
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
        for (Card c : cards) {
            if (c instanceof Plant) {
                System.out.println(c.getName() + c.getCardType() + ((Plant) c).getCooLDown() + ((Plant) c).getPlantingPrice());
            }
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


    public static void showLawn() {

    }

    public static void endTurn(Boolean isEndTurn) {
        while (isEndTurn == true) {

        }
    }

}
