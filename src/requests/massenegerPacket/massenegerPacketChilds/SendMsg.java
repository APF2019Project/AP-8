package requests.massenegerPacket.massenegerPacketChilds;

import requests.massenegerPacket.MassenegeRequest;

public class SendMsg extends MassenegeRequest {
    String text;
    String nofig;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNofig() {
        return nofig;
    }

    public void setNofig(String nofig) {
        this.nofig = nofig;
    }
}
