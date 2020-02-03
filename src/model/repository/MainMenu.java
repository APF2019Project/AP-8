package model.repository;

import model.sevice.PlayMenu;

import java.util.Scanner;

public class MainMenu {

    private static Scanner input;

    public static void setInput(Scanner scanner) {
        input = scanner;
    }

    public static void mainMenuGetInput() {
        System.out.println("-------------MAIN_MENU-----------------");
        System.out.println("enter one if this commands " +
                "play " +
                "profile " +
                "shop ");
        String str = input.nextLine();
        switch (str) {
            case "play":
                PlayMenu.takeInputForPlayMenu();
            case "profile":
                Profile.profileGetInput();
            case "shop":
                Shop.takeInputForShop();
            default:
                mainMenuGetInput();
        }

    }


}
