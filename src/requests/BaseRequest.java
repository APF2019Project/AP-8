package requests;

public class BaseRequest {
    public enum RequestType{
        createAccount,
        login,
        Connection
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
