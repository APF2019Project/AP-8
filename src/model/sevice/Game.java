package model.sevice;

import model.entity.*;
import controller.boxExeption.InvalidZombieTypeExeption;
import model.repository.Player;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    CovertCardsToJsonString covertCardsToJsonString = new CovertCardsToJsonString();
    ArrayList<Card> cards = new ArrayList<Card>();
    Map map = new Map("land");
    Scanner scanner = new Scanner(System.in);
    String commands = scanner.nextLine();
    private boolean isGamePVP = false;
    private GameState gameState;
    private GameType gameType;
    private int turn = 0;
    private static Player player;


    public Game(boolean isGamePVP, int wave, String name) {
        this.isGamePVP = isGamePVP;
        setGameType(name);
    }

    public GameType setGameType(String name) {
        switch (name) {
            case "RAIL":
                this.gameType = GameType.RAIL;
            case "WATER":
                this.gameType = GameType.WATER;
            case "DAY":
                return this.gameType = GameType.DAY;
            case "PVP":
                return this.gameType = GameType.PVP;
            case "ZOMBEI":
                return this.gameType = GameType.ZOMBEI;
        }
        return null;
    }

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
    public int getTurn() {
        return turn;
    }
    // constructor

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public CovertCardsToJsonString getCovertCardsToJsonString() {
        return covertCardsToJsonString;
    }

    public void setCovertCardsToJsonString(CovertCardsToJsonString covertCardsToJsonString) {
        this.covertCardsToJsonString = covertCardsToJsonString;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}
