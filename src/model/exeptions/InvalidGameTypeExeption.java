package model.exeptions;

public class InvalidGameTypeExeption extends Exception {
    public InvalidGameTypeExeption(String INVALID) {
        super(INVALID);
    }

}
