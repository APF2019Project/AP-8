package model.repository;

import model.entity.PlantType;

public class Player {
    private PlantType plantType;
    private int numberOfSun; // tedade sun haei k giyah kar bahash bazi ro shoro mikone .

    public PlantType getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantType plantType) {
        this.plantType = plantType;
    }

    public int getNumberOfSun() {
        return numberOfSun;
    }

    public void setNumberOfSun(int numberOfSun) {
        this.numberOfSun = numberOfSun;
    }
}
