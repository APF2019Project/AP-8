package model.repository;

import controller.boxExeption.InvalidGameTypeExeption;
import model.entity.Card;
import model.entity.Plant;
import model.entity.Zombie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CollectionInterFace {
    public static ArrayList<Card> returnCards(String gameType) throws InvalidGameTypeExeption {
        // dadane card haye har bazi
        ArrayList<Card> cards = new ArrayList<Card>(7);
        ArrayList<Card> additionalCards = new ArrayList<Card>(10);
        ArrayList<Card> nulls = null;

        switch (gameType) {
            case "DAY":
                for (Card c : convertHashmapTOArraylist(model.repository.Collection.getCollection())) {
                    if (c instanceof Plant) {
                        cards.add(c);
                        return cards;
                    }
                }
                return nulls;
            case "WATER":
                for (Card c : convertHashmapTOArraylist(model.repository.Collection.getCollection())) {
                    if (c instanceof Plant) {
                        cards.add(c);
                        return cards;
                    }
                }
                return nulls;
            case "RAIL":
                for (Card c : convertHashmapTOArraylist(model.repository.Collection.getCollection())) {
                    if (c instanceof Plant) {
                        cards.add(c);
                        return cards;
                    }
                    for (Card c1 : convertHashmapTOArraylist(model.repository.Collection.getAddtionalCollectionForRAIL())) {
                        if (c1 instanceof Plant) {
                            additionalCards.add(c1);
                            return additionalCards;
                        }
                    }
                }
                return nulls;
            case "ZOMBIE":
                for (Card c : convertHashmapTOArraylist(model.repository.Collection.getCollection())) {
                    if (c instanceof Zombie) {
                        cards.add(c);
                        return cards;
                    }
                }
                return nulls;
            default:
                throw new InvalidGameTypeExeption("invalid game type");
        }
    }


    public static ArrayList<Card> convertHashmapTOArraylist(HashMap<String, Card> map) {

        //Getting Collection of values from HashMap

        Collection<Card> values = map.values(); // ... java collection ba collection ma farq dare ...

        //Creating an ArrayList of values

        ArrayList<Card> listOfValues = new ArrayList<Card>(values);
        return listOfValues;
    }
}
