package requests;

public class NotifRequest extends BaseRequest {
    public NotifRequest() {
        super(RequestType.getNotif, NotifRequest.class.getName());
    }
}
