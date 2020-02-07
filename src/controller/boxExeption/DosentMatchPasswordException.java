package controller.boxExeption;

public class DosentMatchPasswordException extends Exception {
    public DosentMatchPasswordException(String massage){
        super(massage);
    }
}
