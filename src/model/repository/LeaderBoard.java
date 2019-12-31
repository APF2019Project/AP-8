package model.repository;

import java.util.Scanner;

public class LeaderBoard {
    private static Scanner input;

    public static void setInput(Scanner input) {
        LeaderBoard.input = input;
    }
    public static void leaderBoardTakeInput(){
        System.out.println("----------LEADER BOARD-------------");
        System.out.println("enter \"back\" to back loggin menu");

    }
}
