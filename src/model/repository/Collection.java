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
    public boolean selectCard(Card newCard){
        System.out.println("selectCard start");
        if(selectedCards.size()==this.maxSize||newCard.isSelected()){
            System.out.println("selectCard finsh by returning false");
            return false;
        }
        else{
            System.out.println("selectCard finish by returning true");
            newCard.setSelected(true);
            this.selectedCards.add(newCard);
            return true;
        }

    }
}
