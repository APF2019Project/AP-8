package model;

public class Plant extends Card {
    private int health = 100;
    private PlantType plantType;
    private Turn coolDownIncreasePerTurn;
    private Turn cooLDown;
    private Turn coolDownCeil;
    private Sun plantingPrice;
    private Coin shopingPrice;
    private Turn sunOutTurn;
    private Home position;

    private Condition condition = Condition.LIVE;

    public void setCondition() {
        if(this.health<=0)
            this.condition=Condition.DEAD;
    }

}
