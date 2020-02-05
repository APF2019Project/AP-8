package requests;

public class AccountRequest {
    private String userName;
    private String pass;
    private String newPass;
    private enum Type{
        createAccount,
        login
    }
}
