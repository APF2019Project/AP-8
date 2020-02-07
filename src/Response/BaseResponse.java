package Response;

public class BaseResponse {
    public enum ResponseType{
        Connection,
        login,
        createAccount,
        addCard_plant,
        addCard_zombie
    }
    protected String responseClass;
    protected ResponseType type;
    protected boolean success;

    public String getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(String responseClass) {
        this.responseClass = responseClass;
    }

    public void setType(ResponseType type) {
        this.type = type;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResponseType getType() {
        return type;
    }

    public boolean isSuccess() {
        return success;
    }

    public BaseResponse() {
    }

    public BaseResponse(String responseClass, ResponseType type, boolean success) {
        this.responseClass = responseClass;
        this.type = type;
        this.success = success;
    }
}
