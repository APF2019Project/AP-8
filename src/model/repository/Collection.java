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
    private int maxSize =7;
    private static Scanner input;
    private static HashMap<String, Card> selectedCards = new HashMap<>(7);
    public static void setInput(Scanner scanner){
        input = scanner;
    }
    public static HashMap<String , Card> takeInputForCollection(String cardType){
        System.out.println("---------COLLECTION_MENU---------");
        System.out.println("enter one of below commands" +
                "showHand" +
                "play" +
                "select cardName" +
                "remove cardName" +
                "showCollection");
        System.out.println("if you select more than 7 cards , the result will be random of that set");
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
                return getCollection();
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
        return getCollection();
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
    public static HashMap<String , Card> getCollection(){
        HashMap<String , Card> temp = new HashMap<>();
        int counter = 0 ;
        for (String name : Collection.selectedCards.keySet()) {
            temp.put(name , Collection.selectedCards.get(name));
            counter++;
            if(counter==7)
                break;
        }
        return temp;
    }
}
