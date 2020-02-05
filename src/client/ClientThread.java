package client;

import model.entity.Account;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    private Account account;
    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private InputStreamReader inputStreamReader;
    private OutputStreamWriter outputStreamWriter;
    private boolean isPlaying = false;
    public ClientThread(Socket socket) {
        try {
            this.socket = socket;
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    @Override
    public void run(){

    }
}

