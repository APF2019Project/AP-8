package requests;

public class ImageRequest extends BaseRequest {
    byte[] image;
    private String id;

    public ImageRequest(RequestType type, byte[] image, String id) {
        super(type, ImageRequest.class.getName());
        this.image = image;
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public String getId() {
        return id;
    }
}
