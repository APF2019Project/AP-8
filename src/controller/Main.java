package controller;

import model.entity.BulletType;
import view.Command;
import model.entity.CovertCardsToJsonString;

import java.util.Scanner;

public class Main {
    public  static Command command = new Command();
    public static CovertCardsToJsonString covertCardsToJsonString = new CovertCardsToJsonString();
    public static void main(String[] args)throws Exception {
       //    JsonCards.makeZombiesFile();
        //   JsonCards.makePlantsFile();
        Scanner scanner = new Scanner(System.in);
        BulletType bulletType;

       covertCardsToJsonString.createZombies(covertCardsToJsonString.setZombieFields(scanner));
       //covertCardsToJsonString.createPlants(covertCardsToJsonString.setPlantFields(scanner));

    }
}