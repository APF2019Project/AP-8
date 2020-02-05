package requests.accountRequests.accountRequestChilds;

import requests.accountRequests.AccountRequest;

public class CreateAccount extends AccountRequest {
    private String line;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
