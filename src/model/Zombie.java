package model;

public class Zombie extends Card {
    Plant plant = new Plant("plant ", CardType.PLANT);
    private int lifeNumber;
    private boolean hasCAP; // kolah dare ya na.
    private int bumper; // har zombei momkene chnata separ dashte bashe.
    private LandZombeiType landZombeiType;
    private Cell position;

    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
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

    public void hurtPlants() {
        if (landZombeiType == LandZombeiType.GigaGargantuar) {
            plant.setHealth(0);
        }
    }


}
