package requests;

public class ChatRequest extends BaseRequest {
    String text;
    String id;
    String path;

    public ChatRequest(RequestType type, String text, String id) {
        super(type, ChatRequest.class.getName());
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }
}
