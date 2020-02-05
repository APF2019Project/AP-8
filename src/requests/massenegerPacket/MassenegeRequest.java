package requests.massenegerPacket;

import requests.Request;
import requests.massenegerPacket.massenegerPacketChilds.ReplyMsg;
import requests.massenegerPacket.massenegerPacketChilds.SendMsg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MassenegeRequest extends Request {
    private static MassenegeRequest massenegeRequest;

    private static MassenegeRequest getInstance() {
        if (massenegeRequest == null)
            massenegeRequest = new MassenegeRequest();
        return massenegeRequest;
    }

    public MassenegeRequest getMassenegeRequest() {
        String command = scanner.nextLine().trim().toLowerCase();
        Pattern pattern = Pattern.compile("send msg (\\w+)");
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            SendMsg send = new SendMsg();
            send.setText(command.split("\\s")[2]);
            return send;
        }
        pattern = Pattern.compile("reply msg (\\w+)");
        matcher = pattern.matcher(command);
        if (matcher.find()) {
            ReplyMsg replyMsg = new ReplyMsg();
            replyMsg.setText(command.split("\\s")[2]);
            return replyMsg;
        }
        return null;
    }
}
