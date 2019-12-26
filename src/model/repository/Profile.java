package model.repository;

import model.entity.Account;
import model.exeptions.InvalidIdException;
import model.exeptions.InvalidPasswordException;

import java.util.Scanner;

public class Profile extends Account {
    private static Scanner input;

    private static void profileGetInput() {
        System.out.println("-------------------profile------------------");
        System.out.println("enter once of this commands to continio \nchange\nrename\ndelete\ncreate\nback");
        String str = input.nextLine();
        switch (str) {
            case "change":
                change();
                profileGetInput();
                break;
            case "rename":
                rename();
                profileGetInput();
                break;
            case "delete":
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

    public static void change() {
        System.out.println("enter your id: ");
        String id = input.nextLine();
        System.out.println("enter your password: ");
        String password = input.nextLine();
        logOut();
        System.out.println("you log out :)))");
        try {
            loggIn(id, password);
        } catch (InvalidIdException | InvalidPasswordException e) {
            System.out.println(e.getMessage());
            System.out.println("invalid password or id enter back to return profile menu , or enter change to take input again");
        }
    }

    public static void delete() {
        System.out.println("-----delete account part of profile------");
        System.out.println("enter account id: ");
        String id = input.nextLine();
        System.out.println("enter account password: ");
        String password = input.nextLine();
        try {
            deleteAccount(id, password);
        } catch (InvalidIdException | InvalidPasswordException e) {
            System.out.println("invalid password or id enter back to return profile menu , or enter delete to take input again");
            String str = input.nextLine();
            if (str.matches("delete")) {
                delete();
            }
        }
    }

    public static void rename() {
        System.out.println("----------rename part of profile-------");
        System.out.println("enter an id: ");
        String id = input.nextLine();
        System.out.println("enter new name:");
        String newName = input.nextLine();
        try {
            renameAccount(id, newName);
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
            System.out.println(" enter back to return profile menu , or enter rename to take input again");
            String str = input.nextLine();
            if (str.matches("rename")) {
                rename();
            }
        }
    }

}
