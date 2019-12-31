package model.entity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.exeptions.InvalidIdException;
import model.exeptions.InvalidPasswordException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    // list of  zombies and plants most be declare

    private static HashMap<String , String > accountsInfo = new HashMap<>();
    public static Account loggedInAccount = null;
    private String name;
    private int id;
    private int password;
    private int coins; //we have two modle coin one is this , that is usefull for shoping , other is in game type
    private int numberOfKiledZombies = 0;
    private model.repository.Collection Collection;
    private ArrayList<String> plants;
    private ArrayList<String> Zombies;

    public Account() {
        //ino baraye on ac ke tooye menu hast gozashtam
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(String strPass) {
        this.password = getStringHash(strPass);
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

    public static Account getLoggedInAccount() {
        return loggedInAccount;
    }

    private static void setLoggedInAccount(Account loggedInAccount) {
        Account.loggedInAccount = loggedInAccount;
    }

    public Account(String name, String id, String password, int coins, int numberOfKiledZombies, ArrayList<String> plants, ArrayList<String> zombies) throws Exception, InvalidPasswordException {
        try {
            this.name = name;
            this.setID(id);
            this.setPassword(password);
            this.coins = coins;
            this.numberOfKiledZombies = numberOfKiledZombies;
            this.plants = plants;
            Zombies = zombies;
            saveAccountInJson(this);
        } catch (Exception e) {
            throw e;
        }
    }
    public static void  logOut() {
        setLoggedInAccount(null);
    }

    public static void loggIn(String id, String password) throws InvalidIdException , InvalidPasswordException{
        setLoggedInAccount(getAccountByIdAndPassword(id, password));
    }

    public boolean chekPass(String pass) throws InvalidPasswordException{
        if (getStringHash(pass) == this.getPassword())
            return true;
        throw new InvalidPasswordException("your password is invalid");
    }

    public static Account getAccountById(String inputStr) throws InvalidIdException {
        int id = Math.abs(inputStr.hashCode());
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(id + ".json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            Account account = new Gson().fromJson(stringBuilder.toString(), Account.class);
            return account;
        } catch (Exception e) {
            throw new InvalidIdException("your id is invalid");
        }
    }

    private static Account getAccountByIdAndPassword(String id, String password) throws InvalidPasswordException , InvalidIdException {
        Account account = getAccountById(id);
        if (account.chekPass(password))
            return account;
        return null;
    }

    private void saveAccountInJson(Account account) throws InvalidIdException {
        String jsonAccount = new Gson().toJson(account);
        try {
            FileWriter fileWriter = new FileWriter(account.getId() + ".json");
            fileWriter.write(jsonAccount);
            fileWriter.close();
        } catch (IOException e) {
            throw new InvalidIdException("invalid id");
        }
    }


    private boolean setID(String strId) throws Exception, InvalidIdException {
        int id = getStringHash(strId);
        Path path = Paths.get(id + ".json");
        if (Files.exists(path)) {
            throw new InvalidIdException("this id used before");
        } else {
            this.id = id;
            return true;
        }
    }

    public void editePassword(String pass, String newPass1, String newPass2) throws InvalidPasswordException {
        if (this.getPassword() == getStringHash(pass)) {
            if (getStringHash(newPass1) == getStringHash(newPass2)) {
                this.setPassword(newPass1);
            } else {
                throw new InvalidPasswordException("your new passwords didnt match");
            }
        } else {
            throw new InvalidPasswordException("your password is not correct");
        }
    }

    private static int getStringHash(String str) {
        return Math.abs(str.hashCode());
    }
    public static void deleteAccount(String id , String password) throws InvalidIdException, InvalidPasswordException {
        Account account = getAccountById(id);
        if(account.chekPass(password)){
            try {
                Files.delete(Paths.get(account.getId()+".json"));
            } catch (IOException e) {
                System.out.println("exception in delet account method at this path = modele.repsitory.account");
            }
        }
    }
    public static void renameAccount(String id , String newName) throws InvalidIdException {
        if(id.matches(loggedInAccount.getName())){
            loggedInAccount.setName(newName);
        }
        throw new InvalidIdException("invalid id");
    }
    private static JsonObject makeJson(String id , String password){
        JsonObject result = new JsonObject();
        result.addProperty("id" , id);
        result.addProperty("password" , password);
        return result;
    }
    private static void setAccountsInfo(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader( "accounts.json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            accountsInfo = new Gson().fromJson(stringBuilder.toString(), HashMap.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static  void getAllAccounts(){
        ArrayList<Account> accounts = new ArrayList<>();
        for (String id : accountsInfo.keySet()) {
            try {
                accounts.add(Account.getAccountByIdAndPassword(id , accountsInfo.get(id)));
            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());
            } catch (InvalidIdException e) {
                e.printStackTrace();
            }
        }

    }
    private static void saveAccountsInfo(){
        String jsonAccounts = new Gson().toJson(Account.accountsInfo);
        try {
            FileWriter fileWriter = new FileWriter("accounts.json");
            fileWriter.write(jsonAccounts);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
