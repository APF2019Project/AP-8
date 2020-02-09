package Response;

public class BaseResponse {
    protected String responseClass;
    protected ResponseType type;
    protected boolean success;
    protected String notif;
    public BaseResponse() {
    }

    public BaseResponse(String responseClass, ResponseType type, boolean success) {
        this.responseClass = responseClass;
        this.type = type;
        this.success = success;
    }

    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
    }

    public String getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(String responseClass) {
        this.responseClass = responseClass;
    }

    public ResponseType getType() {
        return type;
    }

    public void setType(ResponseType type) {
        this.type = type;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public enum ResponseType {
        Connection,
        login,
        createAccount,
        addCard_plant,
        addCard_zombie,
        send_msg,
        reply,
        notif,
        buy,
        sell,
        showCardsCapacity,
        send_image,
        getNotif,
        recive_image
    }
}
