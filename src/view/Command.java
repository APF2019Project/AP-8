package view;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class Command {
    Scanner scanner = new Scanner(System.in);

    public void getInputFromMenu() {
        String string;
        String [] input =scanner.nextLine().split(" ");
        while (true) {
            if (input[0] == "\n"){
                //go to main menu
                //chejuri bayad bezanim k inja main menu ro biyare
            }else if (input[0].equals("create") && input[1].equals("account")){
                System.out.println("Please Enter Your UserNmae: ");
                    //inja bayad user ro azash bgirim
                System.out.println("Please Enter Youer Password: ");
                //inja byd password r zash bgirim
            }else {
                break;
            }
        }
    }public void getInputFromGame(){

    }
}
