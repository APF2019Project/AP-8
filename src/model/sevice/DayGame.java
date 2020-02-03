package model.sevice;

import model.entity.*;
import model.repository.Collection;
import model.repository.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static model.sevice.WaterGame.showLawn;

public class DayGame extends Game {
    private static Scanner input;
    private static int coolDown;
    private static int turn = 0;
    private static int waveTurn = 7;
    private static int wave = 3; // chanta moj dare
    private static Map map = new Map("land");
    private static Player player;
    private static Plant temp;
    private static ArrayList<Card> cards = new ArrayList<Card>(7);
    private int sunFlowerTurned = 2;
    private int getSunCounter = randomAccess(1, 2);
    private int numberOdfPlants = 7;
    private ArrayList<Plant> plants = new ArrayList<Plant>();
    private int firstWaveTurn = 3;
    private int bungeeTuen = 3;
    private boolean endTurn = false;

    public DayGame() {
        super(false, 3, "DAY");
    }

    public static void setInput(Scanner scanner) {
        input = scanner;
    }

    public static void takeInput() throws Exception {

        System.out.println("---------DAY GAME---------");
        System.out.println("enter one of below commands " +
                "showHand " +
                "select " +
                "plant " +
                "remove " +
                "end turn " +
                "show lawn ");
        String[] splitedInput = input.nextLine().split(" ");
        switch (splitedInput[0]) {
            case "showHand":
                showHand();
                takeInput();
                break;
            case "select":
                selectCards(splitedInput[1]);
                takeInput();
            case "plant":
                temp.plantingByXandY(Integer.parseInt(splitedInput[1]), Integer.parseInt(splitedInput[2]));
                takeInput();
            case "remove":
                if (map.getCell(Integer.parseInt(splitedInput[1]), Integer.parseInt(splitedInput[2])).isHasPlant() == true) {
                    map.getCell(Integer.parseInt(splitedInput[1]), Integer.parseInt(splitedInput[2])).removeAllPlantInThisCell();
                    takeInput();
                }
                break;
            case "end turn":

            case "show lawn":
                showLawn();

        }
    }

    private static void showHand() {
        for (String name : Collection.selectedCards.keySet()) {
            Plant plant = new Plant(name, CardType.PLANT);
            System.out.print(plant.getPlantType() + " ");
            System.out.print(plant.getPlantingPrice() + " ");
            System.out.print(plant.getCoolDownCeil() + " ");
        }
    }

    private static void selectCards(String n) {
        for (String name : Collection.selectedCards.keySet()) {
            if (n.equals(name)) {
                Plant plant = new Plant(name, CardType.PLANT);
                plant.planting();
            }
        }
    }

//    public static Plant selectCard(String name) throws Exception {
//        if (Collection.getCollection().containsKey(name)) {
//            try {
//                if (CovertCardsToJsonString.getPlantFromJsonString(name).getPlantingPrice() <= player.getNumberOfSun() && CovertCardsToJsonString.getPlantFromJsonString(name).charging() == true) {
//                    return CovertCardsToJsonString.getPlantFromJsonString(name);
//                }
//            } catch (InvalidPlantTypeExeption | InvalidBulletTypeExeption | FileNotFoundException invalidPlantTypeExeption) {
//                invalidPlantTypeExeption.printStackTrace();
//            }
//        }
//        return null;
//    }
//

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
            } catch (Exception e) {
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

