package model.sevice;

import model.repository.PlayerType;

public class DayGame extends Game {
    public DayGame() {
        super(false, PlayerType.GIYAHKAR , PlayerType.ZOMBEI ,3);
    }
}
