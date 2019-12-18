package model;

public class Zombie extends Card {
    private int lifeNumber = 0;
    private boolean hasCAP; // kolah dare ya na.
    private int bumper; // har zombei momkene chnata separ dashte bashe.
    private LandZombeiType landZombeiType;
    private Cell position;
    private int speed;

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

    public LandZombeiType getLandZombeiType() {
        return landZombeiType;
    }

    public void setLandZombeiType(LandZombeiType landZombeiType) {
        this.landZombeiType = landZombeiType;
    }

    public void giveBumperAndLIfe() {
        System.out.println("set some types of zombeis lifes & bumpers start");
        if (landZombeiType == LandZombeiType.Newspaper) {
            this.bumper = 1;
            this.lifeNumber = 2;
        }
        if (landZombeiType == LandZombeiType.Target) {
            this.bumper = 1;
            this.lifeNumber = 3;
        }
        if (landZombeiType == LandZombeiType.ScreenDoor) {
            this.bumper = 1;
            this.lifeNumber = 4;
        }
    }

    public void hurtPlants(Plant plant) {
        if (landZombeiType == LandZombeiType.GigaGargantuar && plant.getPosition() == this.position) {
            plant.setHealth(0);
        }
        if (landZombeiType == LandZombeiType.Zomboni && plant.getPosition() == this.position) {
            plant.setHealth(0);
            this.landZombeiType = LandZombeiType.RegularZombei;
        }
    }

    public void divVelocity(Plant plant) {
        if (plant.getPlantType() == PlantType.SNOW_PEA || plant.getPlantType() == PlantType.WINTERMELON) {
            this.speed = speed % 2;
        }
    }

    public void hurtZombeiBYPlants(Plant plant) {
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

    public void lehKrdan(Plant plant) {
        if (this.getLandZombeiType() == LandZombeiType.Catapult) {
            for (Card c : this.position.cards) {

            }
        }
    }
}
