package server;

import client.Config;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
    static String name = null;
    static int port = 8000;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("pls enter the config file name: ");
        name = scanner.nextLine();
        if (Config.getJsonString(name) != null) {
            Config config = Config.getJsonString(name);
            port = config.getPort();
        }
        try (ServerSocket onlineAccount = new ServerSocket(port)) {
            while (true) {
                System.out.println("Waiting for the client request");
                Socket socket = onlineAccount.accept();
                new OnlineAccount(socket);
                //read from socket to ObjectInputStream object
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //convert ObjectInputStream object to String
                String message = (String) ois.readObject();
                System.out.println("Message Received: " + message);
                //create ObjectOutputStream object
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //write object to Socket
                oos.writeObject("Hi Client " + message);
                //close resources
                ois.close();
                oos.close();
                socket.close();
                //terminate the server if client sends exit request
                if (message.equalsIgnoreCase("exit")) break;
                System.out.println("Shutting down Socket server!!");
                //close the ServerSocket object
                onlineAccount.close();
            }


        }

    }

}

