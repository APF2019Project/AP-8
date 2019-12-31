package model.sevice;

import model.repository.PlayerType;

public class ZombeiGame extends Game {
    public static void takeInput(){

    }
    public ZombeiGame(boolean isGamePVP, PlayerType player_One_Type, PlayerType player_Two_Type, int wave) {
        super(isGamePVP, player_One_Type, player_Two_Type, wave);
    }
}
