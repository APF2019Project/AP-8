package model.repository;

import java.util.ArrayList;

public class Turn {
    ArrayList<Turn> turns = new ArrayList<Turn>();
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addTurn() {
        for (Turn t:turns) {
            turns.add(t);
        }
    }
    public void GameState(){

    }

}
