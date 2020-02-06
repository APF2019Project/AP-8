package server;

import Response.BaseResponse;
import client.Connector;
import model.entity.Account;
import requests.BaseRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineAccount implements Runnable {
    private static ArrayList<OnlineAccount> onlineAccounts = new ArrayList<>();
    private Connector connector;
    private Account account;
    public BaseResponse resolve(BaseRequest baseRequest){
        BaseResponse baseResponse = new BaseResponse();
        //todo
        switch (baseRequest.getType()){
            case Connection:
                baseResponse.setType(BaseResponse.ResponseType.Connection);
                baseResponse.setSuccess(true);
        }
        return baseResponse;
    }
    public OnlineAccount(Socket socket) {
        System.out.println("new client connected");
        try {
            connector = new Connector(socket,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        onlineAccounts.add(this);
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                connector.resolve();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
