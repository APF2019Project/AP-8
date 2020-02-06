package server;

import client.Config;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
    static String name = null;
    static int port = 6000;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("Waiting for the client request");
                Socket socket = serverSocket.accept();
                new OnlineAccount(socket);
            }
        }

    }

}

