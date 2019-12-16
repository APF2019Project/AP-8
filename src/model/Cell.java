package model;

import java.util.ArrayList;

public class Cell {
    ArrayList<Integer> Xs = new ArrayList<Integer>(16);
    ArrayList<Integer> Ys = new ArrayList<Integer>(9);
    private int x;
    private int y;
    private CellType cellType;

    public Cell() {
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        Xs.add(x);
        Ys.add(y);
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
}
