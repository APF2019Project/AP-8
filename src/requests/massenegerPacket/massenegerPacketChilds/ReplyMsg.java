package requests.massenegerPacket.massenegerPacketChilds;

import requests.massenegerPacket.MassenegeRequest;

public class ReplyMsg extends MassenegeRequest {
    String text;
    String notif;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
    }
}
