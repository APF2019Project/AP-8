package Response;

import requests.BaseRequest;

public class ImageResponse extends BaseRequest {
    byte[] image;

    public ImageResponse(byte[] image) {
        this.image = image;
    }
}
