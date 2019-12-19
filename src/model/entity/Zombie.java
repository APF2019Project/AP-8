package model.entity;

public class Zombie extends Card {
    private int lifeNumber = 0;
    private boolean hasCAP; // kolah dare ya na.
    private int bumper; // har zombei momkene chnata separ dashte bashe.
    private ZombeiType zombeiType;
    private Cell position;
    private int speed;
    private boolean isBaloon = false;

    public Zombie(String name, CardType cardType, int lifeNumber, boolean hasCAP, int bumper, ZombeiType zombeiType, Cell position, int speed) {
        super(name, cardType);
        this.lifeNumber = lifeNumber;
        this.bumper = bumper;
        this.hasCAP = hasCAP;
        this.zombeiType = zombeiType;
        this.position = position;
        this.speed = speed;
    }

    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

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

    public void giveBumperAndLIfe() {
        if (zombeiType == ZombeiType.Newspaper) {
            this.bumper = 1;
            this.lifeNumber = 2;
        }
        if (zombeiType == ZombeiType.Target) {
            this.bumper = 1;
            this.lifeNumber = 3;
        }
        if (zombeiType == ZombeiType.ScreenDoor) {
            this.bumper = 1;
            this.lifeNumber = 4;
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

    public void lehKardan() {
        // leh kardan giyah tavasote mashine ghavi
        System.out.println("leh kardan giyah tavasote mashine ghavi start");
        if (this.getZombeiType() == ZombeiType.Zomboni) {
            for (int i = 0; i < this.position.cards.size(); i++) {
                if (CardType.PLANT == this.position.cards.get(i).getCardType()) {
                    this.position.cards.remove(this.position.cards.get(i));
                    setZombeiType(ZombeiType.RegularZombei);
                }
            }
        }
        System.out.println("leh kardan giyah tavasote mashine ghavi finished");
    }

    public void lehKardanByCatapult() {
        // leh kardan giyah tavasote mashine zaeef
        System.out.println("leh kardan giyah tavasote mashine zaeef start");
        if (this.getZombeiType() == ZombeiType.Zomboni) {
            for (int i = 0; i < this.position.cards.size(); i++) {
                if (CardType.PLANT == this.position.cards.get(i).getCardType()) {
                    this.position.cards.remove(this.position.cards.get(i));
                }
            }
        }
        System.out.println("leh kardan giyah tavasote mashine zaeef finished");
    }

    public Boolean isWaterZombei() {
        if (this.getZombeiType() == ZombeiType.SNORKEL || this.getZombeiType() == ZombeiType.DOLPHINRIDER)
            return true;
        return false;
    }

}