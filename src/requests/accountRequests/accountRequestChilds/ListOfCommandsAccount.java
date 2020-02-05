package requests.accountRequests.accountRequestChilds;

import requests.accountRequests.AccountRequest;

public class ListOfCommandsAccount extends AccountRequest {
    private List list;

    public List getAccountOptionList() {
        return list;
    }

    public void setAccountOptionList(List accountOptionList) {
        this.list = accountOptionList;
    }
}
