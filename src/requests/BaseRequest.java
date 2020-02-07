package requests;

public class BaseRequest {
    public enum RequestType{
        createAccount,
        login,
        Connection,
        addCard_plant,
        addCard_zombie,
        send_msg,
        reply,
        showOnlineAccounts,
        showOfflineAccounts
    }

    public RequestType getType() {
        return type;
    }

    public String getRequestClass() {
        return requestClass;
    }

    public BaseRequest(RequestType type, String requestClass) {
        this.type = type;
        this.requestClass = requestClass;
    }
    public BaseRequest(){

    }
    protected RequestType type;
    protected String requestClass;
}
