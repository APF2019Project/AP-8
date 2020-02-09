package Response;

public class NotifResponse extends BaseResponse {
    private String notif;

    public NotifResponse(String text) {
        super(NotifResponse.class.getName(), ResponseType.notif, true);
        this.notif = text;
    }

    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
    }
}
