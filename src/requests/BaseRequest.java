package requests;

public class BaseRequest {
    protected RequestType type;
    protected String requestClass;
    protected String text;

    public BaseRequest(RequestType type, String requestClass) {
        this.type = type;
        this.requestClass = requestClass;
    }

    public BaseRequest() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RequestType getType() {
        return type;
    }

    public String getRequestClass() {
        return requestClass;
    }

    public enum RequestType {
        createAccount,
        login,
        Connection,
        addCard_plant,
        addCard_zombie,
        send_msg,
        reply,
        showOnlineAccounts,
        showOfflineAccounts,
        notif,
        buy,
        sell,
        showCardsCapacity,
        send_image,
        getNotif,
        recive_image
    }
}
