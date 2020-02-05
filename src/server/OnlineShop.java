//package server;
//
//import java.net.ServerSocket;
//
//public class OnlineShop implements Runnable {
//    @Override
//    public void run() {
//        try {
//            ServerSocket serverSocket = new ServerSocket(8888);
//            while (true) {
//                System.err.println("Waiting for connect a client ...");
//                OnlineAccount.onlineAccounts.add(new ClientThread(serverSocket.accept()));
//                System.err.println("Client connected");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
