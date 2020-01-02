package controller.boxExeption;

public class InvalidPasswordException extends Exception{

    public InvalidPasswordException(String your_password_is_invalid) {
        super(your_password_is_invalid);
    }
}
