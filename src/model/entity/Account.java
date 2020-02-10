package model.entity;

import com.google.gson.Gson;
import controller.boxExeption.DosentMatchPasswordException;
import controller.boxExeption.InvalidIdException;
import controller.boxExeption.InvalidPasswordException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    // list of  zombies and plants most be declare

    public static Account loggedInAccount = null;
    private static HashMap<Integer, Integer> accountsInfo = new HashMap<>();
    private static ArrayList<Account> accounts = new ArrayList<>();
    private String name;
    private int id;
    private boolean online;
    private int password;
    private int coins; //we have two modle coin one is this , that is usefull for shoping , other is in game type
    private int numberOfKiledZombies = 0;
    private model.repository.Collection Collection;
    private ArrayList<String> plants;

    public static void createAccount(String name, String id, String pass, String repass) throws InvalidIdException , InvalidPasswordException, DosentMatchPasswordException{
        if(!pass.matches(repass))
            throw new DosentMatchPasswordException("password dosent Matched");
        else
            new Account(name , id , pass , 0  ,0, null , null);
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    private ArrayList<String> Zombies;
    private static ArrayList<Account> onlineAccounts = new ArrayList<>();
    private ArrayList<String> messages = new ArrayList<>();


    public Account() {
        //ino baraye on ac ke tooye menu hast gozashtam
    }

    public Account(String name, String id, String password, int coins, int numberOfKiledZombies, ArrayList<String> plants, ArrayList<String> zombies) throws  InvalidIdException {
        try {
            this.name = name;
            this.setID(id);
            this.setPassword(password);
            this.coins = coins;
            this.numberOfKiledZombies = numberOfKiledZombies;
            this.plants = plants;
            Zombies = zombies;
            saveAccountInJson(this);
        } catch (InvalidIdException e) {
            throw e;
        }
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static Account getLoggedInAccount() {
        return loggedInAccount;
    }

    private static void setLoggedInAccount(Account loggedInAccount) {
        Account.loggedInAccount = loggedInAccount;
    }

    public static void logOut() {
      //  accountsInfo.put(loggedInAccount.getId(), loggedInAccount.getPassword());
        setLoggedInAccount(null);
        //saveAccountsInfo();
    }
    public void logout(){
        accountsInfo.put(this.getId(), this.getPassword());
        this.online = false;
    }

    public static void loggIn(String id, String password) throws InvalidIdException, InvalidPasswordException {
        loadAllAccounts();
        setLoggedInAccount(getAccountByIdAndPassword(id, password));
        Account account = findById(id);
        if (account != null) {
            account.online = true;
        }
    }
    public void login(){

    }
    private static Account findById(String id){
        for (Account account:accounts
             ){
            if (account.name.equals(id))
                    return account;
        }
        return null;
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

    public static Account getAccountById(Integer id) throws InvalidIdException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(id + ".json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
            Account account = new Gson().fromJson(stringBuilder.toString(), Account.class);
            return account;
        } catch (Exception e) {
            throw new InvalidIdException("your id is invalid");
        }
    }

    private static Account getAccountByIdAndPassword(String id, String password) throws InvalidPasswordException, InvalidIdException {
        Account account = getAccountById(id);
        if (account.chekPass(password))
            return account;
        return null;
    }

    private static Account getAccountByIdAndPassword(Integer id, Integer password) throws InvalidPasswordException, InvalidIdException {
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
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new InvalidIdException("invalid id");
        }
    }


    private boolean setID(String strId) throws  InvalidIdException {
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
                accountsInfo.put(this.getId(), this.getPassword());
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

    public static void deleteAccount(String id, String password) throws InvalidIdException, InvalidPasswordException {
        Account account = getAccountById(id);
        if (account.chekPass(password)) {
            accounts.remove(account.getId());
            try {
                Files.delete(Paths.get(account.getId() + ".json"));
            } catch (IOException e) {
                System.out.println("exception in delet account method at this path = modele.repsitory.account");
            }
        }else{
            throw new InvalidPasswordException("invalid pass");
        }
    }

    public static void renameAccount(String id, String newName) throws InvalidIdException {
        if (id.matches(loggedInAccount.getName())) {
            loggedInAccount.setName(newName);
        }
        throw new InvalidIdException("invalid id");
    }

    private static void readAccountsInfo() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("accounts.json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            accountsInfo = new Gson().fromJson(stringBuilder.toString(), HashMap.class);
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadAllAccounts() {
                readAccountsInfo();
        for (Integer id : accountsInfo.keySet()) {
            try {
                accounts.add(Account.getAccountByIdAndPassword(id, accountsInfo.get(id)));
            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());
            } catch (InvalidIdException e) {
                e.printStackTrace();
            }
        }

    }

    public static void saveAccountsInfo() {
        String jsonAccounts = new Gson().toJson(Account.accountsInfo);
        try {
            FileWriter fileWriter = new FileWriter("accounts.json");
            fileWriter.write(jsonAccounts);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public static ArrayList<Account> getOnlineAccounts() {
        return onlineAccounts;
    }

    public static void setOnlineAccounts(ArrayList<Account> onlineAccounts) {
        Account.onlineAccounts = onlineAccounts;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
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

    public boolean chekPass(String pass) throws InvalidPasswordException {
        if (getStringHash(pass) == this.getPassword())
            return true;
        throw new InvalidPasswordException("your password is invalid");
    }

    public boolean chekPass(Integer pass) throws InvalidPasswordException {
        if (pass == this.getPassword())
            return true;
        throw new InvalidPasswordException("your password is invalid");
    }

}
