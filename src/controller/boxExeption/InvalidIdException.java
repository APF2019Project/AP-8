package controller.boxExeption;

public class InvalidIdException extends Exception {
    public InvalidIdException(String message) {
        super(message);
    }
}
