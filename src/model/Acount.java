package model;

public class Acount {
    private String name;
    private String password;
    private String username;
    private Shop shop;
    private Collection collection;
    private int cionsInGame;
    private int coinsInMatch;
    private int numOfKilledZombeis;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public int getCionsInGame() {
        return cionsInGame;
    }

    public void setCionsInGame(int cionsInGame) {
        this.cionsInGame = cionsInGame;
    }

    public int getCoinsInMatch() {
        return coinsInMatch;
    }

    public void setCoinsInMatch(int coinsInMatch) {
        this.coinsInMatch = coinsInMatch;
    }

    public int getNumOfKilledZombeis() {
        return numOfKilledZombeis;
    }

    public void setNumOfKilledZombeis(int numOfKilledZombeis) {
        this.numOfKilledZombeis = numOfKilledZombeis;
    }
}
