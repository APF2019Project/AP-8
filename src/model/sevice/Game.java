package model.sevice;

import model.entity.*;
import controller.boxExeption.InvalidZombieTypeExeption;
import model.repository.Player;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    CovertCardsToJsonString covertCardsToJsonString = new CovertCardsToJsonString();
    ArrayList<Card> cards = new ArrayList<Card>();
    Map map = new Map("land");
    Scanner scanner = new Scanner(System.in);
    String commands = scanner.nextLine();
    private boolean isGamePVP = false;
    private GameState gameState;
    private GameType gameType;
    private int turn = 0;
    private static Player player;
    private int wave = 3; // chanta moj dare
    private int sunFlowerTurned = 2;
    private int getSunCounter = randomAccess(1, 2);
    private int numberOdfPlants = 7;
    private ArrayList<Plant> plants = new ArrayList<Plant>();
    private int waveTurn = 7;
    private int firstWaveTurn = 3;
    private int bungeeTuen = 3;


    public Game(boolean isGamePVP, int wave, String name) {
        this.isGamePVP = isGamePVP;
        this.wave = wave;
        setGameType(name);
    }

    public GameType setGameType(String name) {
        switch (name) {
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


    public int getTurn() {
        return turn;
    }
    // constructor

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public CovertCardsToJsonString getCovertCardsToJsonString() {
        return covertCardsToJsonString;
    }

    public void setCovertCardsToJsonString(CovertCardsToJsonString covertCardsToJsonString) {
        this.covertCardsToJsonString = covertCardsToJsonString;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getSunFlowerTurned() {
        return sunFlowerTurned;
    }

    public void setSunFlowerTurned(int sunFlowerTurned) {
        this.sunFlowerTurned = sunFlowerTurned;
    }

    public int getGetSunCounter() {
        return getSunCounter;
    }

    public void setGetSunCounter(int getSunCounter) {
        this.getSunCounter = getSunCounter;
    }

    public int getNumberOdfPlants() {
        return numberOdfPlants;
    }

    public void setNumberOdfPlants(int numberOdfPlants) {
        this.numberOdfPlants = numberOdfPlants;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    public int getWaveTurn() {
        return waveTurn;
    }

    public void setWaveTurn(int waveTurn) {
        this.waveTurn = waveTurn;
    }

    public int getFirstWaveTurn() {
        return firstWaveTurn;
    }

    public void setFirstWaveTurn(int firstWaveTurn) {
        this.firstWaveTurn = firstWaveTurn;
    }

    public int getBungeeTuen() {
        return bungeeTuen;
    }

    public void setBungeeTuen(int bungeeTuen) {
        this.bungeeTuen = bungeeTuen;
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
