package model.entity;

import java.util.Random;

public class Plant extends Card {
    Map map = new Map("land");
    private int health; // joone giyaha
    private PlantType plantType; // type
    private int coolDownIncreasePerTurn;
    private  int cooLDown;
    private  int coolDownCounter = cooLDown;
    private  int coolDownCeil;
    private int plantingPrice; // sun
    private int sunOutTurn;
    private Cell position;
    private BulletType bulletType;
    private boolean isMagnate;
    private int turnCounter;
    private boolean isPrickly;// inke giah tigh dar bashd
    private int cost;
    private Condition condition = Condition.LIVE;
    //constructor
    public Plant(String name, int health, CardType cardType, PlantType plantType, int coolDownCeil, int plantingPrice, int sunOutTurn, BulletType bulletType, boolean isMagnate, boolean isPrickly) {
        super(name, cardType);
        this.health = health;
        this.plantType = plantType;
        this.coolDownIncreasePerTurn = coolDownIncreasePerTurn;
        this.coolDownCeil = coolDownCeil;
        this.plantingPrice = plantingPrice;
        this.sunOutTurn = sunOutTurn;
        this.bulletType = bulletType;
        this.isMagnate = isMagnate;
        this.isPrickly = isPrickly;
        setCost();
    }

    public Plant(String name, CardType cardType) {
        super(name, cardType);
    }

    //getters and setters
    public void setCost() {
        this.cost = this.sunOutTurn * this.cooLDown * this.health + 1;
    }

    public int getCost() {
        return this.cost;
    }

    public PlantType getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantType plantType) {
        this.plantType = plantType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public int getPlantingPrice() {
        return plantingPrice;
    }

    public void setPlantingPrice(int plantingPrice) {
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

    public void setCondition() {
        if (this.health <= 0)
            this.condition = Condition.DEAD;
    }
    // finishing genrate setters and other shit methods

    // in tabe glule i az noee glule haye khod ra dar cell khod put mikonad
    public void shot() {
        Shot.getShot(this.bulletType, this.position);
    }

    public void magnating() {
        if (this.isMagnate) {
            // inja ahan robyi giah ra piade khaham kard...
        }
    }

    /*  public void pricking(){
          if(this.isPrickly){
          for (Zombie zombie: this.position.getZombies()) {
            if(!zombie.isHasArmor()){
                zombie.setLifeNumber(zombie.getLifeNumber()-1);
            }
          }
          }
      }
  */
    @Override
    public String toString() {
        return "Plant{" +
                "health=" + health +
                ", plantType=" + plantType +
                ", coolDownIncreasePerTurn=" + coolDownIncreasePerTurn +
                ", cooLDown=" + cooLDown +
                ", coolDownCeil=" + coolDownCeil +
                ", plantingPrice=" + plantingPrice +
                ", sunOutTurn=" + sunOutTurn +
                ", position=" + position +
                ", bulletType=" + bulletType +
                ", isMagnate=" + isMagnate +
                ", isPrickly=" + isPrickly +
                ", condition=" + condition +
                '}';
    }

    public void planting() {
        //kashtane giyah.
        map.getCell(randomPutPlant(6), randomPutPlant(19)).putCard(this);
        this.position.setHasPlant(true);

    }

    public void plantingByXandY(int y, int x) {
        if (y > 19 || x > 6) {
            System.out.println("invalid cell x & y");
        } else {
            map.getCell(x, y).putCard(this);
            this.position.setHasPlant(true);
        }
    }

    public void removePlant(int y, int x) {
        if (y > 19 || x > 6) {
            System.out.println("invalid cell x & y");
        } else {
            map.getCell(x, y).removeCard(this);
        }
    }

    public int randomPutPlant(int bound) {
        // create instance of Random class
        Random rand = new Random();
        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(bound);
        return rand_int1;
    }

    public boolean deadPlant() {
        //aya zombie morde ya na
        boolean dead = false;
        if (this.health <= 0) {
            dead = true;
            return dead;
        }
        return dead;
    }
    public  boolean charging(){
        if (coolDownCounter == 0){
            coolDownCounter = cooLDown;
            return true;
        }
        coolDownCounter--;
        return false;
    }
}