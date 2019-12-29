package model.entity;

import com.google.gson.Gson;
import model.exeptions.InvalidBulletTypeExeption;
import model.exeptions.InvalidPlantTypeExeption;
import model.exeptions.InvalidZombieTypeExeption;
import model.repository.Menu;

import java.io.*;
import java.util.Scanner;

public class CovertCardsToJsonString {

    private static Scanner input ;
    public void setInput(Scanner input) {
        this.input = input;
    }
    public static void creatCardMenu( ){
        System.out.println("----------------------CREATE CARD MENU-------------------------");
        System.out.println("enter one of these :createZombie, createPlant , back " );
        String str = input.nextLine();
        switch(str) {
            case "createZombie":
                setZombieFields();
                creatCardMenu();
                break;
            case "createPlant":
                setPlantFields();
                creatCardMenu();
                break;
            case "back" :
                Menu.menuGetInput();
                break;
            default:
                creatCardMenu();

        }
    }
    public  static void createPlants(Plant plant) throws InvalidPlantTypeExeption {
        String jsonPlant = new Gson().toJson(plant);
        try {
            FileWriter fileWriter = new FileWriter(plant.getName() + ".json");
            fileWriter.write(jsonPlant);
            fileWriter.close();
        } catch (IOException e) {
            throw new InvalidPlantTypeExeption("invalid plant");
        }
    }

    public static void createZombies(Zombie zombie) throws InvalidZombieTypeExeption {
        String jsonZombie = new Gson().toJson(zombie);
        try {
            FileWriter fileWriter = new FileWriter(zombie.getName() + ".json");
            fileWriter.write(jsonZombie);
            fileWriter.close();
        } catch (IOException e) {
            throw new InvalidZombieTypeExeption("invalid zombie");
        }
    }

    public  static void setZombieFields()  {
        try {
            System.out.println("---------------creating new zombie card menu--------------");
            System.out.println("please enter a name for card :");
            String name = input.nextLine();
            System.out.println("please enter the initilizing health for zombie :");
            int lifeNumber = Integer.parseInt(input.nextLine());
            System.out.println("enter the your zombie cost :");
            int cost = Integer.parseInt(input.nextLine());
            System.out.println("enter the zombie speed :");
            int speed = Integer.parseInt(input.nextLine());
            System.out.println("enter the number of bumper your zombie will hava :");
            int bumper = Integer.parseInt(input.nextLine());
            System.out.println("enter your zombie has cap or no(true or false ): ");
            boolean hascap = Boolean.parseBoolean(input.nextLine());
            System.out.println("enter your zombie isBallon (true or false ):");
            boolean isbaloon = Boolean.parseBoolean(input.nextLine());
            System.out.println("enter your zombie boomper type:");
            int bumperNumber = Integer.parseInt(input.nextLine());
            System.out.println("enter your zombie isWater :");
            boolean iswater = Boolean.parseBoolean(input.nextLine());
            Zombie z = new Zombie(name, CardType.ZOMBIE, setZombieType(name), lifeNumber, hascap, bumper, speed, bumperNumber, iswater, isbaloon);
            createZombies(z);
        }catch (Exception | InvalidZombieTypeExeption e){
            System.out.println(e.getMessage());
        }
    }

    public static void setPlantFields()  {
        System.out.println("-------------- creating new plant card menu --------------");
        System.out.println("enter a name for your plant :");
        String name = input.nextLine();
        System.out.println("enter a number for health field :");
        int health = Integer.parseInt(input.nextLine());
        System.out.println("enter number of suns your plant will create in turns :");
        int sun = Integer.parseInt(input.nextLine());
        System.out.println("enter plant price of your plant :");
        int plantPrice = Integer.parseInt(input.nextLine());
        System.out.println("enter bullet name of zombie ");
        String bulletName = input.nextLine();
        System.out.println("enter isMagnate (true or false ):");
        boolean isMagnate = Boolean.parseBoolean(input.nextLine());
        System.out.println("enter isPrickly (true or false ):");
        boolean isPrickly = Boolean.parseBoolean(input.nextLine());
        System.out.println("enter coolDown for your plant :");
        int coolDown = Integer.parseInt(input.nextLine());
        Plant p = null;
        try {
            p = new Plant(name, health, CardType.PLANT, setPlantType(name), coolDown, plantPrice, sun, setBullletType(bulletName), isMagnate, isPrickly);
            createPlants(p);
        } catch (InvalidPlantTypeExeption | InvalidBulletTypeExeption e) {
            System.out.println(e.getMessage());
        }

    }


    public static PlantType setPlantType(String name) throws InvalidPlantTypeExeption {
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

    public  static ZombeiType setZombieType(String name) throws InvalidZombieTypeExeption {
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

    public static BulletType setBullletType(String name) throws InvalidBulletTypeExeption {
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

    public static Plant getPlantFromJsonString(String name) throws InvalidPlantTypeExeption, InvalidBulletTypeExeption, FileNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(name + ".json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            Plant plant = new Gson().fromJson(stringBuilder.toString(), Plant.class);
            return plant;
        } catch (Exception e) {
            throw new InvalidPlantTypeExeption("invalid plant");
        }
    }
}