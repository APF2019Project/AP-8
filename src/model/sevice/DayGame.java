package model.sevice;

public class DayGame extends Game {
    private boolean endTurn = false;
    public DayGame() {
        super(false, 3,"DAY");
    }

    public static void takeInput() {

    }
    public  boolean selectCardsfromCollection(String name,Boolean isSelected)throws Exception{
        if (super.getPlayer().getNumberOfSun() ==  super.covertCardsToJsonString.getPlantFromJsonString(name).getPlantingPrice()){
            if (isSelected == true){
                return true;
            }
        }
        return false;
    }


}

