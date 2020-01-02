package controller.boxExeption;

public class InvalidZombieTypeExeption extends Throwable {
    public InvalidZombieTypeExeption(String massage) {
        super(massage);
    }
}
