package model.entity;

import com.google.gson.Gson;
import controller.boxExeption.InvalidBulletTypeExeption;
import controller.boxExeption.InvalidPlantTypeExeption;
import controller.boxExeption.InvalidZombieTypeExeption;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CovertCardsToJsonString {
    private Object zombie;
    String jsonZombie = new Gson().toJson(zombie);

    public static Zombie getZombeiFromJsonString(String name) throws InvalidZombieTypeExeption, FileNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(name + ".json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            Zombie zombie = new Gson().fromJson(stringBuilder.toString(), Zombie.class);
            return zombie;
        } catch (Exception e) {
            throw new InvalidZombieTypeExeption("invalid zombie");
        }
    }

    public static Plant getPlantFromJsonString(String name) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(name + ".json"));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        Plant plant = new Gson().fromJson(stringBuilder.toString(), Plant.class);
        return plant;
    }

    public static ArrayList<Plant> makeArrayOfPlants() throws Exception {
        ArrayList<Plant> plants = new ArrayList<>();
        Plant p = getPlantFromJsonString("PEASHOOTER");
        plants.add(p);
        p = getPlantFromJsonString("JALAPENO");
        plants.add(p);
        p = getPlantFromJsonString("TWINSUNFLOWER");
        plants.add(p);
        p = getPlantFromJsonString("EXPLODE_O_NUT");
        plants.add(p);
        p = getPlantFromJsonString("SPLIT_PEA");
        plants.add(p);
        p = getPlantFromJsonString("EXPLODE_O_NUT");
        plants.add(p);
        p = getPlantFromJsonString("TANGLE_KELP");
        plants.add(p);
        p = getPlantFromJsonString("LILYPAD");
        plants.add(p);
        p = getPlantFromJsonString("CABBAGE_PULT");
        plants.add(p);
        p = getPlantFromJsonString("REPEATER");
        plants.add(p);
        p = getPlantFromJsonString("POTATO_MINE");
        plants.add(p);
        return plants;
    }

    public void createPlants(Plant plant) throws InvalidPlantTypeExeption {
        String jsonPlant = new Gson().toJson(plant);
        try {
            FileWriter fileWriter = new FileWriter(plant.getName() + ".json");
            fileWriter.write(jsonPlant);
            fileWriter.close();
        } catch (IOException e) {

            throw new InvalidPlantTypeExeption("invalid plant");
        }
    }

    public void createZombies(Zombie zombie) throws Exception {

        FileWriter fileWriter = new FileWriter(zombie.getName() + ".json");
        fileWriter.write(jsonZombie);
        fileWriter.close();

    }

    public void setZombieFields(Scanner scanner) {
        String[] string = scanner.nextLine().split(",");
        try {
            String name = string[0];
            int lifeNumber = Integer.parseInt(string[1]);
            int cost = Integer.parseInt(string[2]);
            int speed = Integer.parseInt(string[3]);
            int bumper = Integer.parseInt(string[4]);
            boolean hascap = Boolean.parseBoolean(string[5]);
            boolean isbaloon = Boolean.parseBoolean(string[6]);
            int bumperNumber = Integer.parseInt(string[7]);
            boolean iswater = Boolean.parseBoolean(string[8]);
            Zombie z = new Zombie(name, CardType.ZOMBIE, setZombieType(name), lifeNumber, hascap, bumper, speed, bumperNumber, iswater, isbaloon);
            //  createZombies(z);
        } catch (InvalidZombieTypeExeption e) {
            e.printStackTrace();
        }

    }

    public void setPlantFields(Scanner scanner) throws InvalidPlantTypeExeption, InvalidBulletTypeExeption {
        String[] string = scanner.nextLine().split(",");
        String name = string[0];
        int health = Integer.parseInt(string[1]);
        int sun = Integer.parseInt(string[2]);
        int plantPrice = Integer.parseInt(string[3]);
        String bulletName = string[4];
        boolean isMagnate = Boolean.parseBoolean(string[5]);
        boolean isPrickly = Boolean.parseBoolean(string[6]);
        int coolDown = Integer.parseInt(string[7]);

        Plant p = new Plant(name, health, CardType.PLANT, setPlantType(name), coolDown, plantPrice, sun, setBulletType(bulletName), isMagnate, isPrickly);
        createPlants(p);
    }

    public BulletType setBulletType(String name) {
        BulletType b = BulletType.EXPLODE_O_NOT;
        return b;
    }

    public PlantType setPlantType(String name) throws InvalidPlantTypeExeption {
        switch (name) {
            case "PEASHOOTER":
                return PlantType.PEASHOOTER;
            case "SNOW_PEA":
                return PlantType.SNOW_PEA;
            case "CABBAGE_PULT":
                return PlantType.CABBAGE_PULT;
            case "REPEATER":
                return PlantType.REPEATER;
            case "THREEPEATER":
                return PlantType.THREEPEATER;
            case "CACTUS":
                return PlantType.CACTUS;
            case "GATLING_PEA":
                return PlantType.GATLING_PEA;
            case "SCAREDY_SHROOM":
                return PlantType.SCAREDY_SHROOM;
            case "KARNEL_PULT":
                return PlantType.KARNEL_PULT;
            case "SPLIT_PEA":
                return PlantType.SPLIT_PEA;
            case "EXPLODE_O_NUT":
                return PlantType.EXPLODE_O_NUT;
            case "MELON_PULT":
                return PlantType.MELON_PULT;
            case "LILYPAD":
                return PlantType.LILYPAD;
            case "WINTERMELON":
                return PlantType.WINTERMELON;
            case "WALL_NUT":
                return PlantType.WALL_NUT;
            case "TANGLE_KELP":
                return PlantType.TANGLE_KELP;
            case "TALL_NUT":
                return PlantType.TALL_NUT;
            case "CATTAIL":
                return PlantType.CATTAIL;
            case "POTATO_MINE":
                return PlantType.POTATO_MINE;
            case "MAGNET_SHROOM":
                return PlantType.MAGNET_SHROOM;
            case "CHERRY_BOMB":
                return PlantType.CHERRY_BOMB;
            case "SUNFLOWER":
                return PlantType.SUNFLOWER;
            case "TWINSUNFLOWER":
                return PlantType.TWINSUNFLOWER;
            case "JALAPENO":

            default:
                throw new InvalidPlantTypeExeption("invalid plant type");
        }
    }

    public ZombeiType setZombieType(String name) throws InvalidZombieTypeExeption {
        switch (name) {
            case "RegularZombei":
                return ZombeiType.RegularZombei;
            case "Footballer":
                return ZombeiType.Footballer;
            case "Buckethead":
                return ZombeiType.Buckethead;
            case "Conehead":
                return ZombeiType.Conehead;
            case "Zomboni":
                return ZombeiType.Zomboni;
            case "Catapult":
                return ZombeiType.Catapult;
            case "Bungee":
                return ZombeiType.Bungee;
            case "Balloon":
                return ZombeiType.Balloon;
            case "Newspaper":
                return ZombeiType.Newspaper;
            case "Target":
                return ZombeiType.Target;
            case "ScreenDoor":
                return ZombeiType.ScreenDoor;
            case "GigaGargantuar":
                return ZombeiType.GigaGargantuar;
            case "Pogo":
                return ZombeiType.Pogo;
            case "SNORKEL":
                return ZombeiType.SNORKEL;
            case "DOLPHINRIDER":
                return ZombeiType.DOLPHINRIDER;
            default:
                throw new InvalidZombieTypeExeption("invalid zombie type");
        }
    }

    public BulletType setBullletType(String name) throws InvalidBulletTypeExeption {
        switch (name) {
            case "PEA":
                return BulletType.PEA;
            case "LETTUCE":
                return BulletType.LETTUCE;
            case "SNOW_PEA":
                return BulletType.SNOW_PEA;
            case "EXPLODE_O_NOT":
                return BulletType.EXPLODE_O_NOT;
            case "WATERMELON":
                return BulletType.WATERMELON;
            case "MAIZE":
                return BulletType.MAIZE;
            case "WINTER_MELLON":
                return BulletType.WINTER_MELLON;
            default:
                throw new InvalidBulletTypeExeption("invalid bullet type");
        }
    }
}