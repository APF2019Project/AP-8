package requests;

import model.entity.Account;

public class AccountRequest extends BaseRequest {
    private String userName;
    private String pass;

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public AccountRequest(String userName, String pass, RequestType requestType) {
        super(requestType,AccountRequest.class.getName());
        this.userName = userName;
        this.pass = pass;
    }
    public AccountRequest(){
        super();
    }
}

