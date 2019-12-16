package model;

import java.util.ArrayList;

public class Card {
    private String name;
    private CardType cardType;
    private Coin shopingPrice;

    private boolean isSelected = false;
    private ArrayList<String> doOptions; // listing methods for each object that has its perfarmans , we have three type cards : plant , zombie , bullet
    // start setters and getters methods ,and constructor decaration
    public ArrayList<String> getDoOptions() {
        return doOptions;
    }

    public void setDoOptions(ArrayList<String> doOptions) {
        this.doOptions = doOptions;
    }


    public Coin getShopingPrice() {
        return shopingPrice;
    }

    public void setShopingPrice(Coin shopingPrice) {
        this.shopingPrice = shopingPrice;
    }


    public Card(String name, CardType cardType, Coin shopingPrice, ArrayList<String> doOptions) {
        this.name = name;
        this.cardType = cardType;
        this.shopingPrice = shopingPrice;
        this.doOptions = doOptions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    // finis declaring setters and getters

}
