package model.sevice;


import model.repository.PlayerType;

public class PvpGame extends Game {
    public static void takeInput(){

    }
    public PvpGame(PlayerType player_One_Type, PlayerType player_Two_Type, int wave) {
        super(true, wave,"PVP");
    }
}
