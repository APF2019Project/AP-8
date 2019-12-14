package model;

import java.util.ArrayList;

public class Collection {
    private Card type;
    private int maxSize;
    private ArrayList<Card> cards = new ArrayList<Card>();

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

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
