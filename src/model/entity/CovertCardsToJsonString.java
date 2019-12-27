package model.entity;

import com.google.gson.Gson;
import model.exeptions.InvalidZombieTypeExeption;
import model.repository.PlayerType;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CovertCardsToJsonString {

    Scanner scanner = new Scanner(System.in);
    String[] string = scanner.nextLine().split(",");

    public void createPlants(Plant plant) throws InvalidZombieTypeExeption {
        String jsonPlant = new Gson().toJson(plant);
        try {
            FileWriter fileWriter = new FileWriter(plant.getPlantType() + ".json");
            fileWriter.write(jsonPlant);
            fileWriter.close();
        } catch (IOException e) {
            throw new InvalidZombieTypeExeption("invalid zombie");
        }
    }

    public void createZombies(Zombie zombie) throws InvalidZombieTypeExeption {
        String jsonZombie = new Gson().toJson(zombie);
        try {
            FileWriter fileWriter = new FileWriter(zombie.getZombeiType() + ".json");
            fileWriter.write(jsonZombie);
            fileWriter.close();
        } catch (IOException e) {
            throw new InvalidZombieTypeExeption("invalid zombie");
        }
    }

    public Zombie setZombieFields(Scanner scanner) {
        String name = string[0];
        int lifeNumber = Integer.parseInt(string[1]);
        boolean hascap = Boolean.parseBoolean(string[2]);
        boolean iswater = Boolean.parseBoolean(string[3]);
        boolean isbaloon = Boolean.parseBoolean(string[4]);
        int bumper = Integer.parseInt(string[1]);
        int bumperNumber = Integer.parseInt(string[1]);
        int speed = Integer.parseInt(string[1]);
        int cost = Integer.parseInt(string[1]);
        Cell position1 = new Cell(0, 0, CellType.LAND);
        Cell position2 = new Cell(0, 0, CellType.WATER);
        Zombie z = new Zombie(name, CardType.ZOMBIE, lifeNumber, hascap, bumper, position1, speed, bumperNumber, iswater, isbaloon);
        return z;
    }
    public Plant setPlantFields(Scanner scanner ) {
        String name = string[0];
        int health = Integer.parseInt(string[1]);
        int sun = Integer.parseInt(string[2]);
        int plantPrice = Integer.parseInt(string[3]);
        BulletType bulletType = setBulletType(name);
        PlantType plantType = setPlantType(name);
        int coolDown = Integer.parseInt(string[4]);
        boolean isPrickly = Boolean.parseBoolean(string[5]);
        boolean isMagnate = Boolean.parseBoolean(string[6]);


        int cost = Integer.parseInt(string[1]);

        Plant p = new Plant(name,health, CardType.PLANT,plantType,coolDown,plantPrice,sun,bulletType,isMagnate,isPrickly);
        return p;
    }
    public BulletType setBulletType(String name){
        BulletType b = BulletType.EXPLODE_O_NOT;
        return b;
    }
    public PlantType setPlantType(String name){
       PlantType p = PlantType.TANGLE_KELP;// ino ba if bayad bezanam
        return p;
    }
}
