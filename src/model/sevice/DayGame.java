package model.sevice;

import model.repository.Player;
import model.repository.PlayerType;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Random;

public class DayGame extends Game {
    ArrayList<Card> cards = new ArrayList<Card>();
    private Player player;
    private int turn = 0;

    public DayGame() {
        super(false, PlayerType.GIYAHKAR, PlayerType.ZOMBEI, 3);
    }

    public void playGame() {
        player.setNumberOfSun(2);
        while (true) {
            if (turn % 1 == 0 || turn % 2 == 0) {
               // player.setNumberOfSun(randomAccess());
            }
            turn++;
        }
    }


    public int randomAccess( int  start , int finish) {
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(Math.abs(finish- start)+1);
        rand_int1 = rand_int1 +start ;
        return rand_int1;
    }
}
