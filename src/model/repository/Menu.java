package model.repository;

import model.entity.Account;
import model.exeptions.InvalidIdException;
import model.exeptions.InvalidPasswordException;

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

    public static void menuGetInput(){

    }
    private static void  createAccount(String name , String id , String password) throws Exception {
        Account account = new Account(name , id , password , 0 , 0 ,defualtPlants, defualtZombies );
        System.out.println(name+"account created , Hello " + name +"\n");
        System.out.println("for enjoing game , please login.");
    }
    public static void login( String id, String password) throws InvalidIdException , InvalidPasswordException {
        Account ac = new Account();
        ac.loggIn(id , password);
        System.out.println("you are logged in" + " ,Hello " + Account.getLoggedInAccount().getName());
    }
    private boolean stringMatching ( String str1 , String str2){
        return str1.matches(str2);
    }
    public static void takeInputForCreateAccount() {
      try {
          System.out.println("you are creating account , please input a name :");
          String name =input.nextLine();
          System.out.println("please input an id : ");
          String id  = input.nextLine();
          System.out.println("please input an password:");
          String password1 = input.nextLine();
          System.out.println("please repeat your password : ");
          String password2 = input.nextLine();
          if(password1.matches(password2)){
              createAccount(name , id , password1);
          }else{
              System.out.println("your passwords didnt match");
              takeInputForCreateAccount();
          }
      }catch (Exception e){
          System.out.println(e.getMessage());
          takeInputForCreateAccount();
      }
    }
        public static void getInputForLogin() {
       try {
           System.out.println("---------login menu-----------");
           System.out.println("please enter your id :");
           String id = input.nextLine();
           System.out.println("please enter your password : ");
           String password = input.nextLine();
           login(id , password);
       } catch (Exception i){
           System.out.println(i.getMessage());
           getInputForLogin();
       }
        }
}
