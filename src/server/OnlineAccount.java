package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineAccount implements Runnable{
    private static ArrayList<OnlineAccount> onlineAccounts = new ArrayList<>();
    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    public OnlineAccount(Socket socket) {
        this.socket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        onlineAccounts.add(this);
        this.run();
    }

    @Override
    public void run() {
        //todo recieve
        Object request;
        //todo resolve
        //todo send
    }
}
