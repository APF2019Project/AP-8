package requests.accountRequests.accountRequestChilds;

import requests.accountRequests.AccountRequest;

public class ListOfCommandsAccount extends AccountRequest {
    private ListAccount list;

    public ListAccount getAccountOptionList() {
        return list;
    }

    public void setAccountOptionList(ListAccount accountOptionList) {
        this.list = accountOptionList;
    }
}
