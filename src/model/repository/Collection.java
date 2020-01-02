package model.repository;

import model.entity.Account;
import model.entity.Card;
import model.entity.CovertCardsToJsonString;
import model.exeptions.InvalidBulletTypeExeption;
import model.exeptions.InvalidPlantTypeExeption;
import model.exeptions.InvalidZombieTypeExeption;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Collection {
    private Card type;
    private int maxSize =7;
    private static Scanner input;
    private static HashMap<String, Card> selectedCards = new HashMap<>(7);

    public Card getType() {
        return type;
    }

    public void setType(Card type) {
        this.type = type;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    public static HashMap<String , Card> takeInputForCollection(String cardType){
        System.out.println("---------COLLECTION_MENU---------");
        System.out.println("enter one of below commands" +
                "showHand" +
                "play" +
                "select cardName" +
                "remove cardName" +
                "showCollection");
        String str= input.nextLine();
        String[] splites = str.split(" ");
        switch (splites[0]){
            case "showHand":
                showSelectedCards();
                takeInputForCollection(cardType);
                break;
            case "showCollection" :
                showUnselectedCards(cardType);
                takeInputForCollection(cardType);
                break;
            case "play" :
                return Collection.selectedCards;
            case "select" :
                select(splites[1] , cardType);
                takeInputForCollection(cardType);
                break;
            case "remove":
                remove(splites[1]);
                takeInputForCollection(cardType);
                break;
            default: takeInputForCollection(cardType);
        }
        return Collection.selectedCards;
    }

    private static void select(String cardName, String cardType) {

       if(cardType.matches("zombie")){
           if(Account.loggedInAccount.getZombies().contains(cardName)){
               try {
                   selectedCards.put(cardName , CovertCardsToJsonString.getZombeiFromJsonString(cardName));
               } catch (InvalidZombieTypeExeption | FileNotFoundException invalidZombieTypeExeption) {
                   invalidZombieTypeExeption.printStackTrace();
               }
           }
       }else if(cardType.matches("plant")){
           if(Account.loggedInAccount.getPlants().contains(cardName)){
               try {
                   selectedCards.put(cardName , CovertCardsToJsonString.getPlantFromJsonString(cardName));
               } catch (InvalidPlantTypeExeption | InvalidBulletTypeExeption | FileNotFoundException invalidPlantTypeExeption) {
                   invalidPlantTypeExeption.printStackTrace();
               }
           }
       }
    }
    public static void remove(String cardName){
        selectedCards.remove(cardName);
    }
    private static void showUnselectedCards(String cardType) {
        switch (cardType){
            case "zombie":
                for (String name : Account.loggedInAccount.getZombies()) {
                    if(!selectedCards.containsKey(name)){
                        System.out.println(selectedCards.get(name).getName());
                    }
                }
                break;
            case "plant":
                for (String name : Account.loggedInAccount.getPlants()) {
                    if(!selectedCards.containsKey(name)){
                        System.out.println(selectedCards.get(name).getName());
                    }
                }
        }
    }

    private static void showSelectedCards() {
        for (String name : Collection.selectedCards.keySet()) {
            System.out.println(Collection.selectedCards.get(name).getName());
        }
    }


}
