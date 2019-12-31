package model.sevice;

import model.exeptions.InvalidZombieTypeExeption;
import model.repository.Player;
import model.repository.PlayerType;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Random;

import static controller.Main.covertCardsToJsonString;

public class DayGame extends Game {
    ArrayList<Card> cards = new ArrayList<Card>();
    private Player player;
    private int turn = 0;
    private int getSunCounter = randomAccess(1,2);
    private int numberOdfPlants =7;
    private ArrayList<Card> plants ;

    public DayGame() {
        super(false, PlayerType.GIYAHKAR, PlayerType.ZOMBEI, 3);
    }

    public void playGame() {
        player.setNumberOfSun(2);
    }


    public int randomAccess( int  start , int finish) {
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(Math.abs(finish- start)+1);
        rand_int1 = rand_int1 +start ;
        return rand_int1;
    }
    public void getSunForPlayer(){
        System.out.println("random sun");
        player.setNumberOfSun(randomAccess(2,5));
        this.getSunCounter--;
        if (getSunCounter == 0){
            player.setNumberOfSun(randomAccess(2,5));
        }
    }
    public void decreaseSunForPlayer(){
        //age ke az sun estefade kardim az sun player byad kam she.
    }
    public void runWave(){
        for (int i =0 ; i< randomAccess(4,10);i++){
            try {
                covertCardsToJsonString.getZombeiFromJsonString("RegularZombei").put_Zombie();
            }catch (Exception | InvalidZombieTypeExeption e){
                System.out.println("invalid zombie exeption");
            }
        }
    }
}
