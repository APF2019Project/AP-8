package model.entity;


import java.util.ArrayList;

public class Map {
    private ArrayList<ArrayList<Cell>> rows = new ArrayList<>(6);
    private String mapType;
    // this constructor make the map ,  this take a sting "land" for khoski and "water" for ab map
    public Map(String mapType) {
        for (int i =0 ; i<6 ; i++){
            this.rows.add(new ArrayList<Cell>(19));
        }
        if(mapType.matches("land")){
            for (ArrayList<Cell> row: this.rows) {
               row = getRow(CellType.LAND , this.rows.indexOf(row));
            }
        }else if(mapType.matches("water")){
            for (int i = 0 ; i<6 ; i++){
                if(i == 2  || i== 3){
                    this.rows.add(i , this.getRow(CellType.WATER ,i)) ;
                }else {
                    this.rows.add(i , this.getRow(CellType.LAND ,i));
                }
            }
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
    // this method get a row of cells , can be water cells or land cells
    private static ArrayList<Cell> getRow(CellType cellType , int rowIndex){
        ArrayList<Cell> row = new ArrayList<>(19);
        for (Cell cell: row) {
            cell = new Cell(row.indexOf(cell) , rowIndex ,cellType );
        }
        return row;
    }

}
