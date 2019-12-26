package model.repository;

import model.entity.Account;

import java.util.Scanner;

public class Profile extends Account {
    private static Scanner input ;
    private static void profileGetInput(){
        System.out.println("------profile------");
        System.out.println("enter once of this commands to continio \nchange\nrename\ndelete\ncreate\nback");
        String str = input.nextLine();
        switch (str){
            case "change" :
                change();
                profileGetInput();
                break;
            case "rename" :
                rename();
                profileGetInput();
                break;
            case "delete" :
                delete();
                profileGetInput();
                break;
            case "create":
                Menu.takeInputForCreateAccount();
                profileGetInput();
                break;
            case "back":
                Menu.menuGetInput();
                break;
            default:
                profileGetInput();

        }
    }
    public static void change( ){
        System.out.println("enter your password: " );
    }
    public static void delete(){

    }
    public static void rename(){

    }


}
