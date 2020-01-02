package model.repository;

import model.entity.Card;

import java.util.ArrayList;

public class Collection {
    private Card type;
    private int maxSize;
    private ArrayList<Card> selectedCards = new ArrayList<Card>();

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

    public ArrayList<Card> getSelectedCards() {
        return selectedCards;
    }

    public void setSelectedCards(ArrayList<Card> cards) {
        this.selectedCards = cards;
    }
    public static ArrayList<Card> takeInputForCollection(String cardType){
        System.out.println("---------COLLECTION_MENU---------");
        System.out.println("enter"+cardType + "names you want to use in game:");
    }


}
