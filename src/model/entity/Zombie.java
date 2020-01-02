package model.entity;

import java.util.Random;

public class Zombie extends Card {
    Map map = new Map("land");
    private int lifeNumber = 0;
    private boolean hasCAP; // kolah dare ya na.
    private int bumper; // har zombei momkene chnata separ dashte bashe.
    private ZombeiType zombeiType;
    private Cell position;
    private int speed;
    private boolean isBaloon = false;
    private int bumperLife;
    private boolean isWater;
    private int cost;
    private boolean Bungee;
    private Cell temp;

    public Zombie(String name, CardType cardType, ZombeiType zombeiType, int lifeNumber, boolean hasCAP, int bumper, int speed, int bumperLife, boolean isWater, boolean isBaloon) {
        super(name, cardType);
        this.zombeiType = zombeiType;
        this.lifeNumber = lifeNumber;
        this.bumper = bumper;
        this.hasCAP = hasCAP;
        this.speed = speed;
        this.bumperLife = bumperLife;
        this.isWater = isWater;
        this.isBaloon = isBaloon;
        setCost();
    }

    public Zombie(String name) {
        super(name, CardType.ZOMBIE);
    }

    public void getSpeedAndLifeNumber() {
        if (this.zombeiType == ZombeiType.RegularZombei || this.zombeiType == ZombeiType.Newspaper || this.zombeiType == ZombeiType.ScreenDoor || this.zombeiType == ZombeiType.Pogo || this.zombeiType == ZombeiType.SNORKEL || this.zombeiType == ZombeiType.DOLPHINRIDER) {
            this.lifeNumber = 2;
            this.speed = 2;
        } else if (this.zombeiType == ZombeiType.Footballer) {
            this.lifeNumber = 4;
            this.speed = 3;
        } else if (this.zombeiType == ZombeiType.Buckethead) {
            this.lifeNumber = 3;
            this.speed = 2;
        } else if (this.zombeiType == ZombeiType.Conehead || this.zombeiType == ZombeiType.Target) {
            this.lifeNumber = 3;
            this.speed = 2;
        } else if (this.zombeiType == ZombeiType.Buckethead || this.zombeiType == ZombeiType.Zomboni || this.zombeiType == ZombeiType.Catapult || this.zombeiType == ZombeiType.Balloon) {
            this.lifeNumber = 3;
            this.speed = 2;
        } else if (this.zombeiType == ZombeiType.GigaGargantuar) {
            this.lifeNumber = 6;
            this.speed = 1;
        } else if (this.zombeiType == ZombeiType.Bungee) {
            this.lifeNumber = 3;
            this.speed = 0;
        }
    }

    public boolean hasCapZmobei() {
        this.hasCAP = false;
        if (this.zombeiType == ZombeiType.Buckethead || this.zombeiType == ZombeiType.Conehead) {
            this.hasCAP = true;
            return this.hasCAP;
        }
        return this.hasCAP;
    }


//
//    public ZombeiType getZombeiType() {
//        return zombeiType;
//    }
//
//    public void setZombeiType(ZombeiType zombeiType) {
//        this.zombeiType = zombeiType;
//    }
//    public boolean isHasArmor() {
//        return hasArmor;
//    }
//
//    public void setHasArmor(boolean hasArmor) {
//        this.hasArmor = hasArmor;
    //  }

    public void giveBumperAndLIfe() {
        if (zombeiType == ZombeiType.Newspaper) {
            this.bumper = 1;
            this.bumperLife = 2;
        }
        if (zombeiType == ZombeiType.Target) {
            this.bumper = 1;
            this.bumperLife = 3;
        }
        if (zombeiType == ZombeiType.ScreenDoor) {
            this.bumper = 1;
            this.bumperLife = 4;
        }

    }

    public void hurtPlants(Plant plant) {
        if (zombeiType == ZombeiType.GigaGargantuar && plant.getPosition() == this.position) {
            plant.setHealth(0);
        }
        if (zombeiType == ZombeiType.Zomboni && plant.getPosition() == this.position) {
            plant.setHealth(0);
            this.zombeiType = ZombeiType.RegularZombei;
        }
    }

    public void divVelocity(Plant plant) {
        //soraat zombei ro kam mikone
        if (plant.getPlantType() == PlantType.SNOW_PEA || plant.getPlantType() == PlantType.WINTERMELON) {
            this.speed = speed % 2;
        }
    }

    public void hurtZombeiBYPlants(Plant plant) {
        //nokhode tigh dar tigh hash b zombei ha sadame mizane,.
        if (plant.getPlantType() == PlantType.CACTUS && this.getPosition() == plant.getPosition()) {
            this.lifeNumber -= 1;
        }
    }

    public boolean deadZombei() {
        if (this.lifeNumber == 0) {
            return true;
        }
        return false;
    }

//    public void lehKardan() {
//        // leh kardan giyah tavasote mashine ghavi
//        System.out.println("leh kardan giyah tavasote mashine ghavi start");
//        if (this.getZombeiType() == ZombeiType.Zomboni) {
//            for (int i = 0; i < this.position.cards.size(); i++) {
//                if (CardType.PLANT == this.position.cards.get(i).getCardType()) {
//                    this.position.cards.remove(this.position.cards.get(i));
//                    setZombeiType(ZombeiType.RegularZombei);
//                }
//            }
//        }
//        System.out.println("leh kardan giyah tavasote mashine ghavi finished");
//    }

//    public void lehKardanByCatapult() {
//        // leh kardan giyah tavasote mashine zaeef
//        System.out.println("leh kardan giyah tavasote mashine zaeef start");
//        if (this.getZombeiType() == ZombeiType.Zomboni) {
//            for (int i = 0; i < this.position.cards.size(); i++) {
//                if (CardType.PLANT == this.position.cards.get(i).getCardType()) {
//                    this.position.cards.remove(this.position.cards.get(i));
//                }
//            }
//        }
//        System.out.println("leh kardan giyah tavasote mashine zaeef finished");
//    }


    // getter and setters
    public int getLifeNumber() {
        return lifeNumber;
    }

    public void setLifeNumber(int lifeNumber) {
        this.lifeNumber = lifeNumber;
    }

    public boolean isHasCAP() {
        return hasCAP;
    }

    public void setHasCAP(boolean hasCAP) {
        this.hasCAP = hasCAP;
    }

    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBumperLife() {
        return bumperLife;
    }

    public void setBumperLife(int bumperLife) {
        this.bumperLife = bumperLife;
    }

    public boolean isWater() {
        return isWater;
    }

    public void setWater(boolean water) {
        isWater = water;
    }

    public boolean isBaloon() {
        return isBaloon;
    }

    public void setBaloon(boolean baloon) {
        isBaloon = baloon;
    }

    public int getBumper() {
        return bumper;
    }

    public void setBumper(int bumper) {
        this.bumper = bumper;
    }

    public ZombeiType getZombeiType() {
        return zombeiType;
    }

    public void setZombeiType(ZombeiType zombeiType) {
        this.zombeiType = zombeiType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost() {
        this.cost = (1 + this.speed) * this.lifeNumber * 10;
    }

    public void put_Zombie() {
        map.getCell(randomPutZombie(6), 0).putCard(this);
    }

    public int randomPutZombie(int bound) {
        // create instance of Random class
        Random rand = new Random();
        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(bound);
        return rand_int1;
    }

    public void moveZombieOneStep() {
        temp = this.position;
        map.getLeft(temp).putCard(this);
        temp.removeCard(this);
        if (temp.isHasPlant() == true){
            killOnePlantByZombie(temp);
        }
    }

    public void moveZombieFinal() {
        if (!this.position.isHasPlant()) {
            for (int i = 0; i < this.speed; i++) {
                moveZombieOneStep();
            }
        } else {
            damge(this.position);
        }
    }

    public void killOnePlantByZombie(Cell cell) {
        for (int i = 0; i < cell.getCards().size(); i++) {
            if (cell.
                    getCards().get(i).getCardType() == CardType.PLANT) {
                cell.removeCard(cell.getCards().get(i));
            }
        }
    }

    public boolean deadZombie() {
        //aya zombie morde ya na
        boolean dead = false;
        if (this.lifeNumber <= 0) {
            dead = true;
            return dead;
        }
        return dead;
    }
    public void stillPlant(){
        for (int i =0 ; i < this.position.getCards().size() ; i++){
            if (this.position.getCards().get(i) instanceof Plant){
                this.position.removeCard(this.position.getCards().get(i));
            }
        }
    }

}