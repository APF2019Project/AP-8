package model.entity;

import java.util.ArrayList;

public class Account {
    // list of  zombies and plants most be declare
    private String name;
    private int  id;
    private String password;
    private int coins; //we have two modle coin one is this , that is usefull for shoping , other is in game type
    private int numberOfKiledZombies = 0;
    private model.repository.Collection Collection;
    private ArrayList<String> plants ;
    private ArrayList<String> Zombies;
    public boolean chekPass (String pass){
        if(pass.matches(this.password)){
            return true;
        }
        return false;
    }

}
