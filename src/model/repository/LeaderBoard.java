package model.repository;

import model.entity.Account;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LeaderBoard {
    private static Scanner input;

    public static void setInput(Scanner input) {
        LeaderBoard.input = input;
    }
    public static void leaderBoardTakeInput(){
        System.out.println("----------LEADER BOARD-------------");
        System.out.println("enter \"back\" to back loggin menu //another case will show leader board");
        String enr = input.nextLine();
        switch (enr){
            case "back":
                LogginMenu.getInputForLogginMenu();
                break;
            default:
                ArrayList<Account> temp = Account.getAccounts();
                temp.sort(Comparator.comparingInt(Account::getNumberOfKiledZombies));
                for (Account account: temp) {
                    System.out.println(account.getName()+ ": " +account.getNumberOfKiledZombies());
                }
                LogginMenu.getInputForLogginMenu();
        }
    }
}
