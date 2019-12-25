package model.repository;

import model.entity.Account;

import java.io.IOException;
import java.util.HashMap;

public class Menu {
    public HashMap<Integer, Account> accounts = new HashMap<>(); //save accounts with password
    private Account loggedInAccount;
    // a method to login with id and pass
    public boolean login(int id , String pass) throws Exception {
        Account account = Account.getAccountById((new Integer(id)).toString());
       if (account!=null){
            if(this.accounts.get(id).chekPass(pass)){
                System.out.println("----------Logged in--------------");
                this.loggedInAccount = this.accounts.get(id);
                return true;
            }else {
                System.out.println("incorect pass");
                return false;
           }
       }else {
           System.out.println("invalid account");
           return false;
       }
    }
}
