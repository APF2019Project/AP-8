package model;

import java.util.ArrayList;

public class Plant extends Card {
    private int health = 100;
    private PlantType plantType;
    private int coolDownIncreasePerTurn;
    private int cooLDown;
    private int coolDownCeil;
    private Sun plantingPrice;
    private int sunOutTurn;
    private Cell position;
    private Shot shot;
    //getters and setters
    public PlantType getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantType plantType) {
        this.plantType = plantType;
    }


    public int getCooLDown() {
        return cooLDown;
    }

    public void setCooLDown(int cooLDown) {
        this.cooLDown = cooLDown;
    }

    public int getCoolDownCeil() {
        return coolDownCeil;
    }

    public void setCoolDownCeil(int coolDownCeil) {
        this.coolDownCeil = coolDownCeil;
    }

    public Sun getPlantingPrice() {
        return plantingPrice;
    }

    public void setPlantingPrice(Sun plantingPrice) {
        this.plantingPrice = plantingPrice;
    }


    public int getSunOutTurn() {
        return sunOutTurn;
    }

    public void setSunOutTurn(int sunOutTurn) {
        this.sunOutTurn = sunOutTurn;
    }

    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    private Condition condition = Condition.LIVE;

    public void setCondition() {
        if (this.health <= 0)
            this.condition = Condition.DEAD;
    }
    //constructor
    public Plant(String name, CardType cardType, Coin shopingPrice, PlantType plantType, int coolDownIncreasePerTurn, int coolDownCeil, Sun plantingPrice, Coin shopingPrice1, int sunOutTurn , Shot shot) {
        super(name, cardType );
        this.plantType = plantType;
        this.coolDownIncreasePerTurn = coolDownIncreasePerTurn;
        this.coolDownCeil = coolDownCeil;
        this.plantingPrice = plantingPrice;
        this.sunOutTurn = sunOutTurn;
        this.shot= shot;
    }
    // finishing genrate setters and other shit methods

}
