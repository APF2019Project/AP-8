package model;

import java.util.ArrayList;

public class Map {
    private ArrayList<ArrayList<Cell>> rows = new ArrayList<>(6);

    public Map() {
        for (ArrayList<Cell> row : this.rows) {
            row = new ArrayList<Cell>(19);
        }
    }

    // in tabe garare ba tvajoh be tagirati ke yu cell bayad dade beshe har kune ro update kone
    public void update() {

    }
// this return the left cell of each cell
    public Cell getRight(Cell cell) {
        System.out.println("start get right method");
        for (ArrayList<Cell> row : this.rows) {
            if (row.contains(cell)) {
                if (row.indexOf(cell) < 18)
                    return row.get(row.indexOf(cell) + 1);
            }
        }
        return null;
    }
    public Cell getLeft (Cell cell){
        System.out.println("start get left method");
        for (ArrayList<Cell> row: this.rows) {
            if(row.contains(cell)){
                if(row.indexOf(cell)>0){
                    return row.get(row.indexOf(cell)-1);
                }
            }
        }
        return null;
    }
    // in tabe listi az khune hye atraf ye cell ra midahad
    public ArrayList<Cell> getSroundedCells(Cell cell){
        int indexOfCellRow=0;
        int indexOfCell=0;
        for(ArrayList<Cell> row : this.rows){
            if(row.contains(cell)){
                indexOfCell=row.indexOf(cell);
                indexOfCellRow = this.rows.indexOf(row);
                break;
            }
        }
        ArrayList<Cell> cells = new ArrayList<>();
        for (int i = -1 ; i<=1 ; i++){
            cells.add(this.getLeft(this.rows.get(indexOfCellRow+i).get(indexOfCell)));
            cells.add(this.getRight(this.rows.get(indexOfCellRow+i).get(indexOfCell)));
            cells.add(this.rows.get(indexOfCellRow+i).get(indexOfCell));
        }
        return cells;
    }
}
