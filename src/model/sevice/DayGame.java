package model.sevice;

import model.entity.Map;
import model.entity.Plant;
import model.entity.PlantType;
import model.entity.Zombie;
import model.exeptions.InvalidZombieTypeExeption;
import model.repository.Player;
import model.repository.PlayerType;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Random;

import static controller.Main.covertCardsToJsonString;

public class DayGame extends Game {
    ArrayList<Card> cards = new ArrayList<Card>();
    Map map = new Map("land");
    private Player player;
    private int turn = 0;
    private int sunFlowerTurned = 2;
    private int getSunCounter = randomAccess(1, 2);
    private int numberOdfPlants = 7;
    private ArrayList<Plant> plants = new ArrayList<Plant>();
    private int waveTurn = 7;
    private int firstWaveTurn = 3;
    public static void takeInput(){

    }
    public DayGame() {
        super(false, PlayerType.GIYAHKAR, PlayerType.ZOMBEI, 3);
    }

    public void playGame() {
        player.setNumberOfSun(2);

    }


    public int randomAccess(int start, int finish) {
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(Math.abs(finish - start) + 1);
        rand_int1 = rand_int1 + start;
        return rand_int1;
    }

    public void getSunForPlayer() {
        System.out.println("random sun");
        player.setNumberOfSun(randomAccess(2, 5));
        this.getSunCounter--;
        if (getSunCounter == 0) {
            player.setNumberOfSun(randomAccess(2, 5));
        }
    }

    public void decreaseSunForPlayer() {
        //age ke az sun estefade kardim az sun player byad kam she.
    }

    public ArrayList<Zombie> waveZombies() {
        ArrayList<Zombie> zombies = new ArrayList<Zombie>();
        int numberOFWaveZombie = randomAccess(4, 10);
        System.out.println(numberOFWaveZombie); // tedade zombie haye random k dar yek moj miad.
        for (int i = 0; i < numberOFWaveZombie; i++) {
            try {
                Zombie z = covertCardsToJsonString.getZombeiFromJsonString("RegularZombei");
                zombies.add(z);
                return zombies;
            } catch (Exception | InvalidZombieTypeExeption e) {
                System.out.println("invalid zombie exeption");
            }
        }
        return null;
    }

    public void runWave(ArrayList<Zombie> zombies) {
        if (this.turn == 3 || this.waveTurn == 0) {
            for (Zombie z : zombies) {
                z.put_Zombie();
                this.waveTurn--;
            }
        }
    }

    public void addSunForPlayerBySunFlower() {
        System.out.println("addSunForPlayerBySunFlower");
        for (Plant p : plants) {
            if (p.getPlantType() == PlantType.SUNFLOWER || p.getPlantType() == PlantType.TWINSUNFLOWER) {
                if (sunFlowerTurned == 0) {
                    player.setNumberOfSun(player.getNumberOfSun() + p.getSunOutTurn());
                }
            }
        }
    }
}