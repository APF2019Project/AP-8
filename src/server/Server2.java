package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
    static String name = null;
    static int port = 6000;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true){
                    if(scanner.hasNextLine()){
                        String clear = scanner.nextLine();
                        for (OnlineAccount onlineAccount:OnlineAccount.getOnlineAccounts()) {
                            System.out.println(onlineAccount.toString());
                        }
                    }
                }
            }
        };
        thread.start();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("Waiting for the client request");
                Socket socket = serverSocket.accept();
                new OnlineAccount(socket);
            }
        }
    }

}

