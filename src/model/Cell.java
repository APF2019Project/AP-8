package model;

import java.util.ArrayList;

public class Cell {
    ArrayList<Card> cards = new ArrayList<>(); // har khune tedadi glule o plant o zombie dare ke inja mizarim , va khob put card haye motfavet ro tu in class miznm ke put haye mokhtalef niaz nabashe
    // ArrayList<Integer> Xs = new ArrayList<Integer>(16);
    //ArrayList<Integer> Ys = new ArrayList<Integer>(9);
    private int x;
    private int y;
    private CellType cellType;
    private boolean hasPlant = false;

    public Cell() {
    }

    public Cell(int x, int y, CellType cellType) {
        this.x = x;
        this.y = y;
        this.cellType = cellType;
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

}