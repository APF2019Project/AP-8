package model;

import java.util.ArrayList;

public class Plant extends Card {
    private int health = 100; // joone giyaha
    private PlantType plantType; // type
    private int coolDownIncreasePerTurn;
    private int cooLDown;
    private int coolDownCeil;
    private Sun plantingPrice;
    private int sunOutTurn;
    private Cell position;
    private BulletType bulletType;
    private boolean isMagnate ;
    private boolean isPrickly ; // inke giah tigh dar bashd
    //getters and setters
    public PlantType getPlantType() {
        return plantType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
    public Plant(String name, CardType cardType, Coin shopingPrice, PlantType plantType, int coolDownIncreasePerTurn, int coolDownCeil, Sun plantingPrice, Coin shopingPrice1, int sunOutTurn , BulletType bulletType , boolean isMagnate) {
        super(name, cardType );
        this.plantType = plantType;
        this.coolDownIncreasePerTurn = coolDownIncreasePerTurn;
        this.coolDownCeil = coolDownCeil;
        this.plantingPrice = plantingPrice;
        this.sunOutTurn = sunOutTurn;
        this.bulletType= bulletType;
        this.isMagnate = isMagnate;
    }
    // finishing genrate setters and other shit methods

    // in tabe glule i az noee glule haye khod ra dar cell khod put mikonad
    public void shot(){
        Shot.getShot(this.bulletType  , this.position);
    }
    public void magnating(){
        if(this.isMagnate){
            // inja ahan robyi giah ra piade khaham kard...
        }
    }
    public void pricking(){
        if(this.isPrickly){
        for (Zombie zombie: this.position.getZombies()) {
          if(!zombie.isHasArmor()){
              zombie.setLifeNumber(zombie.getLifeNumber()-1);
          }
        }
        }
    }

}
