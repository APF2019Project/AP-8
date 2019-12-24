package model.entity;


import java.util.ArrayList;

public class Cell {
    ArrayList<Card> cards = new ArrayList<>(); // har khune tedadi glule o plant o zombie dare ke inja mizarim , va khob put card haye motfavet ro tu in class miznm ke put haye mokhtalef niaz nabashe
    // ArrayList<Integer> Xs = new ArrayList<Integer>(16);
    //ArrayList<Integer> Ys = new ArrayList<Integer>(9);
    private int x;
    private int y;
    private CellType cellType;
    private boolean hasPlant = false;
    private Map map;

    public Cell() {
    }

    public Cell(int x, int y, CellType cellType , Map map) {
        this.x = x;
        this.y = y;
        this.cellType = cellType;
        this.map = map ;
        // Xs.add(x);
        // Ys.add(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public boolean putCard(Card card) {
        if (card instanceof Plant) {
            if ((this.x % 2 == 0) && (!this.hasPlant) && (this.cellType != CellType.WATER)) {
                ((Plant) card).setPosition(this);
                this.cards.add(card);
                this.hasPlant = true;
                return true;
            }
        } else if (card instanceof Shot) {
            ((Shot) card).setPosition(this);
            this.cards.add(card);
            return true;
        } else if (card instanceof Zombie) {
            ((Zombie) card).setPosition(this);
            this.cards.add(card);
            return true;
        }
        return false;
    }

    public boolean killCell(Card card) {
        if (card instanceof Zombie) {
            this.cards.remove(card);
            return true;
        } else if (card instanceof Plant) {
            this.cards.remove(card);
            return true;
        }
        return false;
    }
    // this method return zombies of each cell
    public ArrayList<Zombie> getZombies(){
        ArrayList<Zombie> result = new ArrayList<>();
        for (Card card: this.cards) {
            if(card instanceof Zombie){
                result.add((Zombie)card);
            }
        }
        return result;
    }
    public void removeCard(Card card){
        this.cards.remove(card);
    }
    public ArrayList<Plant> getPlants(){
        ArrayList<Plant> result = new ArrayList<>();
        for (Card card: this.cards) {
            if(card instanceof Plant){
                result.add((Plant) card);
            }
        }
        return result;
    }
}