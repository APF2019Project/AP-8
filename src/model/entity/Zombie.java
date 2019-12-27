package model.entity;

public class Zombie extends Card {
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

    public Zombie(String name, CardType cardType, int lifeNumber, boolean hasCAP, int bumper,Cell position, int speed, int bumperLife, boolean isWater, boolean isBaloon) {
        super(name, cardType);
        this.lifeNumber = lifeNumber;
        this.bumper = bumper;
        this.hasCAP = hasCAP;
        this.position = position;
        this.speed = speed;
        this.bumperLife = bumperLife;
        this.isWater = isWater;
        this.isBaloon = isBaloon;
    }

    //for default zombeis
    public Zombie(String name, CardType cardType, int bumper, ZombeiType zombeiType, Cell position, boolean isBaloon) {
        super(name, cardType);
        this.zombeiType = zombeiType;
        this.getSpeedAndLifeNumber();
        this.hasCapZmobei();
        this.giveBumperAndLIfe();
        this.position = position;
        this.isBaloon = isBaloon;
    }

    public Zombie(String name) {
        super(name ,CardType.ZOMBIE);
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

    public void setCost(int cost) {
        this.cost = cost;
    }
}