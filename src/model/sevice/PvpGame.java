package model.sevice;


import model.repository.PlayerType;

public class PvpGame extends Game {
    public PvpGame(PlayerType player_One_Type, PlayerType player_Two_Type, int wave) {
        super(true, player_One_Type, player_Two_Type, wave);
    }
}
