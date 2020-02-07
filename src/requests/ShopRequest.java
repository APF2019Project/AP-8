package requests;

import model.entity.CardType;

public class ShopRequest extends BaseRequest {
    private String cardname;
    private CardType cardType;
    private int numberOfCard;

    public String getCardname() {
        return cardname;
    }

    public CardType getCardType() {
        return cardType;
    }

    public int getNumberOfCard() {
        return numberOfCard;
    }

    public ShopRequest(RequestType type, String cardname, CardType cardType, int numberOfCard) {
        super(type,ShopRequest.class.getName());
        this.cardname = cardname;
        this.cardType = cardType;
        this.numberOfCard = numberOfCard;
    }
}
