package requests;

import model.entity.Account;

public class AccountRequest extends BaseRequest {
    private String userName;
    private String name;
    private String pass;

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public AccountRequest(String userName, String name, String pass, RequestType requestType) {
        super(requestType,AccountRequest.class.getName());
        this.userName = userName;
        this.name = name;
        this.pass = pass;
    }
    public AccountRequest(){
        super();
    }
}

