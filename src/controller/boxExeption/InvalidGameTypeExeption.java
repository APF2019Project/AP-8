package controller.boxExeption;

public class InvalidGameTypeExeption extends Exception {
    public InvalidGameTypeExeption(String INVALID) {
        super(INVALID);
    }

}
