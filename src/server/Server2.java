package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server2 {
    public static void main(String[] args)throws Exception {
        try (ServerSocket onlineAccount = new ServerSocket(5000)) {
            while (true){
                Socket socket = onlineAccount.accept();
                new OnlineAccount(socket);
            }
        }
    }
}
