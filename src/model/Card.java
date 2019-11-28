package model;

public class Card {
    private String name ;
    private CardType cardType;

    public Coin getShopingPrice() {
        return shopingPrice;
    }

    public void setShopingPrice(Coin shopingPrice) {
        this.shopingPrice = shopingPrice;
    }

    private Coin shopingPrice;


    public Card(String name, CardType cardType, Coin shopingPrice) {
        this.name = name;
        this.cardType = cardType;
        this.shopingPrice = shopingPrice;
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
