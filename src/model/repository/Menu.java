package model.repository;

import model.entity.Account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static String state ;
    private static ArrayList<String> defualtPlants ;
    private static ArrayList<String> defualtZombies ;
    private static Scanner input;

    public static Scanner getInput() {
        return input;
    }

    public static void setInput(Scanner input) {
        Menu.input = input;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        Menu.state = state;
    }

    public static ArrayList<String> getDefualtPlants() {
        return defualtPlants;
    }

    public static void setDefualtPlants(ArrayList<String> defualtPlants) {
        Menu.defualtPlants = defualtPlants;
    }

    public static ArrayList<String> getDefualtZombies() {
        return defualtZombies;
    }

    public static void setDefualtZombies(ArrayList<String> defualtZombies) {
        Menu.defualtZombies = defualtZombies;
    }

    private static void  createAccount(String name , String id , String password) throws Exception {
        Account account = new Account(name , id , password , 0 , 0 ,defualtPlants, defualtZombies );
        System.out.println(name+"account created , Hello " + name +"\n");
        System.out.println("for enjoing game , please login.");
    }
    public void login( String id, String password) throws Exception {
        Account ac = new Account();
        ac.loggIn(id , password);
        System.out.println("you are logged in" + " ,Hello " + Account.getLoggedInAccount());
    }
    private boolean stringMatching ( String str1 , String str2){
        return str1.matches(str2);
    }
    public void takeInputForCreateAccount() {
      try {
          System.out.println("you are creating account , please input a name :"+ "\n");
          String name =input.nextLine();
          System.out.println("please input an id : \n");
          String id  = input.nextLine();
          System.out.println("please input an password:\n");
          String password1 = input.nextLine();
          System.out.println("please repeat your password : \n");
          String password2 = input.nextLine();
          if(stringMatching(password1 , password2)){
              createAccount(name , id , password1);
          }else{
              System.out.println("incorrect password \n");
              takeInputForCreateAccount();
          }
      }catch (Exception e){
          System.out.println(e.getMessage());
          takeInputForCreateAccount();
      }
    }
        public void getInputForLogin() {
       try {
           System.out.println("---------login menu-----------\n");
           System.out.println("please enter your id :\n");
           String id = input.nextLine();
           System.out.println("please enter your password : \n");
           String password = input.nextLine();
           login(id , password);
       }catch (IOException e){
           System.out.println("your id is invalid , please enter correct:\n");
           getInputForLogin();
       }catch (Exception e){
           System.out.println(e.getMessage());
           getInputForLogin();
       }
        }
}
