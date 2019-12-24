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
    private int id;
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

    public Account(String name, String id, String password, int coins, int numberOfKiledZombies, ArrayList<String> plants, ArrayList<String> zombies) throws Exception {
      try {
          this.name = name;
          this.setID(id);
          this.password = password;
          this.coins = coins;
          this.numberOfKiledZombies = numberOfKiledZombies;
          this.plants = plants;
          Zombies = zombies;
          saveAccountInJson(this);
      }catch (Exception e){
          throw e ;
      }
    }
    public boolean chekPass (String pass) throws Exception {
           if(pass.matches(this.password))
                 return true;
           throw new Exception("InvalidPassWordExeption");
    }
    public static Account getAccountById(String inputStr) throws IOException {
        int id = Math.abs(inputStr.hashCode());
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
            throw  e;
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
    private boolean setID(String strId) throws Exception {
        int id = Math.abs(strId.hashCode());
        Path path = Paths.get(id +".json");
        if(Files.exists(path)){
            System.out.println("id befor was used , pelease inter another");
            throw new Exception("InvalidIdExeption");
        }else {
            this.id=id;
            return true;
        }
    }
}
