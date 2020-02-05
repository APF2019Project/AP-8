//package view;
//
//import client.ClientThread;
//import server.Msg;
//
//import java.util.ArrayList;
//
//public class ChatRoom {
//    private static ChatRoom chatRoom;
//    ArrayList<ClientThread> clientThreads = new ArrayList<>();
//    private ArrayList<Msg> massages = new ArrayList<>();
//
//    public static ChatRoom getInstance() {
//
//        if (chatRoom == null) chatRoom = new ChatRoom();
//        return chatRoom;
//    }
//    public void addToChatRoom(ClientThread clientThread) {
//        clientThreads.add(clientThread);
//        clientThread.sendPacketToClient(new ServerChatRoomPacket(massages));
//    }
//
//}
