package model;

import java.util.ArrayList;

public class Plant extends Card {
    private int health = 100;
    private PlantType plantType;
    private Turn coolDownIncreasePerTurn;
    private Turn cooLDown;
    private Turn coolDownCeil;
    private Sun plantingPrice;
    private Turn sunOutTurn;
    private Cell position;
    private Shot shot;
    //getters and setters

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public PlantType getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantType plantType) {
        this.plantType = plantType;
    }


    public Turn getCooLDown() {
        return cooLDown;
    }

    public void setCooLDown(Turn cooLDown) {
        this.cooLDown = cooLDown;
    }

    public Turn getCoolDownCeil() {
        return coolDownCeil;
    }

    public void setCoolDownCeil(Turn coolDownCeil) {
        this.coolDownCeil = coolDownCeil;
    }

    public Sun getPlantingPrice() {
        return plantingPrice;
    }

    public void setPlantingPrice(Sun plantingPrice) {
        this.plantingPrice = plantingPrice;
    }


    public Turn getSunOutTurn() {
        return sunOutTurn;
    }

    public void setSunOutTurn(Turn sunOutTurn) {
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

    public Plant(String name, CardType cardType) {
        super(name, cardType);
    }

    public Plant(String name, CardType cardType, Coin shopingPrice, PlantType plantType, Turn coolDownIncreasePerTurn, Turn coolDownCeil, Sun plantingPrice, Coin shopingPrice1, Turn sunOutTurn , ArrayList<String> doOptions , Shot shot) {
        super(name, cardType, shopingPrice , doOptions);
        this.plantType = plantType;
        this.coolDownIncreasePerTurn = coolDownIncreasePerTurn;
        this.coolDownCeil = coolDownCeil;
        this.plantingPrice = plantingPrice;
        this.sunOutTurn = sunOutTurn;
        this.shot= shot;
    }
    // finishing genrate setters and other shit methods

}
