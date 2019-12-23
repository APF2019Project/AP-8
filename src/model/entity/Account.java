package model.entity;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Account {
    // list of  zombies and plants most be declare
    private String name;
    private int  id;
    private String password;
    private int coins; //we have two modle coin one is this , that is usefull for shoping , other is in game type
    private int numberOfKiledZombies = 0;
    private model.repository.Collection Collection;
    private ArrayList<String> plants ;
    private ArrayList<String> Zombies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getNumberOfKiledZombies() {
        return numberOfKiledZombies;
    }

    public void setNumberOfKiledZombies(int numberOfKiledZombies) {
        this.numberOfKiledZombies = numberOfKiledZombies;
    }

    public model.repository.Collection getCollection() {
        return Collection;
    }

    public void setCollection(model.repository.Collection collection) {
        Collection = collection;
    }

    public ArrayList<String> getPlants() {
        return plants;
    }

    public void setPlants(ArrayList<String> plants) {
        this.plants = plants;
    }

    public ArrayList<String> getZombies() {
        return Zombies;
    }

    public void setZombies(ArrayList<String> zombies) {
        Zombies = zombies;
    }

    public Account(String name, int id, String password, int coins, int numberOfKiledZombies, ArrayList<String> plants, ArrayList<String> zombies) {
        this.name = name;
        if(this.setID(id)){
            System.out.println("your account created");
        }else{
            System.out.println("invalid id : please give another id");
        }
        this.password = password;
        this.coins = coins;
        this.numberOfKiledZombies = numberOfKiledZombies;
        this.plants = plants;
        Zombies = zombies;
        saveAccountInJson(this);
    }
    public boolean chekPass (String pass){
        if(pass.matches(this.password)){
            return true;
        }
        return false;
    }
    public static Account getAccountById(int id){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(id+".json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            Account account = new Gson().fromJson(stringBuilder.toString(), Account.class);
            return account;
        } catch (IOException e) {
            System.out.println("--invalid id , account not exist");
            return null;
        }
    }
    private void saveAccountInJson(Account account){
        String jsonAccount = new Gson().toJson(account);
        try {
            FileWriter fileWriter = new FileWriter(account.getId()+".json");
            fileWriter.write(jsonAccount);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("accound dosent saved");
            e.printStackTrace();
        }
    }
    private boolean setID(int id){
        FileWriter like ;
        Path path = Paths.get("E:\\AP-8\\"+id +".json");
        if(Files.exists(path)){
            System.out.println("id befor was used");
            return false;
        }else {
            this.id=id;
            return true;
        }
    }
}
