package model.sevice;

import model.entity.*;
import model.exeptions.InvalidZombieTypeExeption;
import model.repository.Player;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Random;

import static controller.Main.covertCardsToJsonString;

public class Game {
    ArrayList<Card> cards = new ArrayList<Card>();
    Map map = new Map("land");
    private boolean isGamePVP = false;
    private GameState gameState;
    private int endTurnTime;
    private GameType gameType;
    private int turn = 0;
    private Player player;
    private int wave = 3; // chanta moj dare
    private int sunFlowerTurned = 2;
    private int getSunCounter = randomAccess(1, 2);
    private int numberOdfPlants = 7;
    private ArrayList<Plant> plants = new ArrayList<Plant>();
    private int waveTurn = 7;
    private int firstWaveTurn = 3;
    private int bungeeTuen = 3;


    public Game(boolean isGamePVP, int wave ,String name) {
        this.isGamePVP = isGamePVP;
        this.wave = wave;
        setGameType(name);
    }
    public GameType setGameType(String name){
        switch (name){
            case "RAIL":
                this.gameType = GameType.RAIL;
            case "WATER":
                this.gameType = GameType.WATER;
            case "DAY":
                return this.gameType = GameType.DAY;
            case "PVP":
                return this.gameType = GameType.PVP;
            case "ZOMBEI":
                return this.gameType = GameType.ZOMBEI;
        }
        return null;
    }
    // getter & setter
    public boolean isGamePVP() {
        return isGamePVP;
    }

    public void setGamePVP(boolean gamePVP) {
        isGamePVP = gamePVP;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }

    public int getEndTurnTime() {
        return endTurnTime;
    }

    public void setEndTurnTime(int endTurnTime) {
        this.endTurnTime = endTurnTime;
    }

    public int getTurn() {
        return turn;
    }
    // constructor

    public void setTurn(int turn) {
        this.turn = turn;
    }

    // game methods
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
        if (this.turn == 3) {
            for (Zombie z : zombies) {
                z.put_Zombie();
            }
        } else if (this.waveTurn == 0) {
            for (Zombie z : zombies) {
                z.put_Zombie();
                this.waveTurn = 7;
            }
        }
        this.waveTurn--;
    }

    public void addSunForPlayerBySunFlower() {
        System.out.println("addSunForPlayerBySunFlower");
        for (Plant p : plants) {
            if (p.getPlantType() == PlantType.SUNFLOWER || p.getPlantType() == PlantType.TWINSUNFLOWER) {
                if (sunFlowerTurned == 0) {
                    player.setNumberOfSun(player.getNumberOfSun() + p.getSunOutTurn());
                    sunFlowerTurned = 2;
                }
                sunFlowerTurned--;
            }
        }
    }

    public void putCards(ArrayList<model.entity.Card> cards) {
        //put kardane zombie ha
        for (model.entity.Card c : cards) {
            if (c instanceof Zombie) {
                if (((Zombie) c).getZombeiType() == ZombeiType.Bungee) {
                    ((Zombie) c).BungeeZombiePut();
                } else {
                    ((Zombie) c).put_Zombie();
                }
            } else if (c instanceof Plant) {
                ((Plant) c).planting();
            }
        }
    }

    public void stillPlantByBungeeZombie(Zombie zombie) {
        System.out.println("stillPlantByBungeeZombie");
        if (bungeeTuen == 0 && zombie.getZombeiType() == ZombeiType.Bungee) {
            zombie.stillPlant();
            bungeeTuen = 3;
        }
        this.bungeeTuen--;
    }
}
