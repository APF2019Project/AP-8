package model.repository;

import model.entity.Account;
import model.entity.Card;
import model.entity.CovertCardsToJsonString;
import model.exeptions.InvalidZombieTypeExeption;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Collection {
    private Card type;
    private int maxSize =7;
    private static Scanner input;
    private HashMap<String, Card> selectedCards = new HashMap<>(7);

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
        System.out.println("enter"+cardType + "names you want to use in game:");
        System.out.println("enter end to go play");
        if(cardType.matches("zombie")){
            return takeInputForZombie();
        }else if(cardType.matches("plant")){
            return takeInputForPlant();
        }
    }

    private static HashMap<String, Card> takeInputForZombie() {
        String str = input.nextLine();
        switch (str){
            case "end":
                return Collection.
        }
    }

    public static boolean selectZombie(String name){
        if(Account.loggedInAccount.getZombies().contains(name)){
            return true;
        }else {
            return false;
        }
    }

}
