package model.sevice;

import model.repository.PlayerType;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class DayGame extends Game {
    public DayGame() {
        super(false, PlayerType.GIYAHKAR , PlayerType.ZOMBEI ,3);
    }
    ArrayList<Card> cards = new ArrayList<Card>();
    //command methodes
    public void showHands(){
    }

}
