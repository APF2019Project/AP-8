package model.repository;

import model.entity.Account;
import model.entity.Card;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Shop {

    private static Scanner input ;
    private static HashMap<String , Integer> shop = new HashMap<>();
    private static HashMap<String , Card> plants= new HashMap<>();
    private static HashMap<String , Card> zombies = new HashMap<>();
    private static HashMap<Integer,Card> plant = new HashMap<>();
    private static HashMap<Integer,Card> zombie = new HashMap<>();

    public static void setInput(Scanner scanner) {
        input = scanner;
    }
    public static void takeInputForShop(){
        System.out.println("------------SHOP-----------");
        System.out.println("enter one of below commands" +
                "showShop" +
                "showCollection" +
                "buy cardName" +
                "Money" +
                "back");
        switch (input.nextLine()){
            case "showShop":
                showShop();
                takeInputForShop();
                break;
            case "showCollection" :
                showCollection();
        }
    }
    public static void showShop(){
        for (String key: shop.keySet()) {
            System.out.println(key + ":" + shop.get(key) +shop.values());
        }
    }
    public static void Buy(String name ){
    //    if()
    }
    public static void addToShop(String name){
        shop.put("name",randomAccess(6,9));
    }
    public static void showCollection(){
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(Account.loggedInAccount.getPlants());
        temp.addAll(Account.loggedInAccount.getZombies());
        for (String name:shop.keySet()) {
            if(temp.contains(name)){
                System.out.println(name + " : " + shop.get(name));
            }
        }
    }
    public static void loadShop(){
        File dicetory = new File("src/view/allPlants/");

    }
    public static int randomAccess(int start, int finish) {
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(Math.abs(finish - start) + 1);
        rand_int1 = rand_int1 + start;
        return rand_int1;
    }
}
