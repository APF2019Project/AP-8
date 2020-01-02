package model.sevice;

import model.entity.Card;
import model.entity.CovertCardsToJsonString;
import model.entity.Plant;
import model.exeptions.InvalidBulletTypeExeption;
import model.exeptions.InvalidPlantTypeExeption;
import model.repository.Collection;
import model.repository.Player;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DayGame extends Game {
    private static Scanner input;
    private static int coolDown;
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
                temp.plantingByXandY(Integer.parseInt(splitedInput[1]),Integer.parseInt(splitedInput[2]));
            case "remove":

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

    public void setInput(Scanner scanner) {
        input = scanner;
    }
}


