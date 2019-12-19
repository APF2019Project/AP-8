package model.entity;

import model.entity.Cell;

public class Map {
    private Cell[][] matrixOfCell =new Cell[6][19] ;
    // in tabe garare ba tvajoh be tagirati ke yu cell bayad dade beshe har kune ro update kone
    public void  update(){
        System.out.println(matrixOfCell[3][3].getCellType());
        for (Cell[] t: matrixOfCell) {
            for (Cell cell :t) {

            }
        }
    }
}
