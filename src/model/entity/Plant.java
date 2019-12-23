package model.entity;

public class Plant extends Card {
    private int health ; // joone giyaha
    private PlantType plantType; // type
    private int coolDownIncreasePerTurn;
    private int cooLDown;
    private int coolDownCeil;
    private int plantingPrice; // sun
    private int sunOutTurn;
    private Cell position;
    private BulletType bulletType;
    private boolean isMagnate ;
    private boolean isPrickly ;// inke giah tigh dar bashd
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

    private Condition condition = Condition.LIVE;

    public void setCondition() {
        if (this.health <= 0)
            this.condition = Condition.DEAD;
    }
    //constructor
    public Plant( String name, int health , CardType cardType, Coin shopingPrice, PlantType plantType, int coolDownIncreasePerTurn, int coolDownCeil, int plantingPrice,  int sunOutTurn , BulletType bulletType , boolean isMagnate , boolean isPrickly) {
        super(name, cardType );
        this.health = health;
        this.plantType = plantType;
        this.coolDownIncreasePerTurn = coolDownIncreasePerTurn;
        this.coolDownCeil = coolDownCeil;
        this.plantingPrice = plantingPrice;
        this.sunOutTurn = sunOutTurn;
        this.bulletType= bulletType;
        this.isMagnate = isMagnate;
        this.isPrickly = isPrickly;
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
}
