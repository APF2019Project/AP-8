package model;

public class Card {
    private String name ;
    private CardType cardType;

    public Card(String name, CardType cardType) {
        this.name = name;
        this.cardType = cardType;
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
}
