package model.sevice;

import model.repository.Player;
import model.repository.PlayerType;

public class Game {
    private boolean isGamePVP = false;
    private GameState gameState;
    private PlayerType player_main_Type;
    private PlayerType player_secound_Type;
    private Player winner;
    private Player loser;
    private int endTurnTime;
    private int turn;
    private int wave = 3; // chanta moj dare

    // getter & setter
    public boolean isGamePVP() {
        return isGamePVP;
    }

    public void setGamePVP(boolean gamePVP) {
        isGamePVP = gamePVP;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public PlayerType getPlayer_main_Type() {
        return player_main_Type;
    }

    public void setPlayer_main_Type(PlayerType player_main_Type) {
        this.player_main_Type = player_main_Type;
    }

    public PlayerType getPlayer_secound_Type() {
        return player_secound_Type;
    }

    public void setPlayer_secound_Type(PlayerType player_secound_Type) {
        this.player_secound_Type = player_secound_Type;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getLoser() {
        return loser;
    }

    public void setLoser(Player loser) {
        this.loser = loser;
    }

    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }

    public int getEndTurnTime() {
        return endTurnTime;
    }

    public void setEndTurnTime(int endTurnTime) {
        this.endTurnTime = endTurnTime;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
    // constructor

    public Game(boolean isGamePVP, PlayerType player_One_Type, PlayerType player_Two_Type, int wave) {
        this.isGamePVP = isGamePVP;
        this.gameState = gameState;
        this.player_main_Type = player_One_Type;
        this.player_secound_Type = player_Two_Type;
        this.wave = wave;
    }
}
