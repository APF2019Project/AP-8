package server;

import Response.BaseResponse;
import client.Connector;
import model.entity.Account;
import model.repository.LogginMenu;
import requests.BaseRequest;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineAccount implements Runnable {
    private static ArrayList<OnlineAccount> onlineAccounts = new ArrayList<>();
    private Connector connector;
    private Account account;

    public OnlineAccount(Socket socket) {
        System.out.println("new client connected");
        try {
            connector = new Connector(socket, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        onlineAccounts.add(this);
        new Thread(this).start();
    }

    public BaseResponse resolve(BaseRequest baseRequest) {
        BaseResponse baseResponse = new BaseResponse();
        //todo
        switch (baseRequest.getType()) {
            case Connection:
                baseResponse.setType(BaseResponse.ResponseType.Connection);
                baseResponse.setSuccess(true);
            case login:
                baseResponse.setType(BaseResponse.ResponseType.login);
                Scanner scanner = new Scanner(System.in);
                LogginMenu.setInput(scanner);
                LogginMenu.getInputForLogginMenu();
                baseResponse.setSuccess(true);
            case createAccount:
                baseResponse.setType(BaseResponse.ResponseType.createAccount);
                Scanner scanner1 = new Scanner(System.in);
                LogginMenu.setInput(scanner1);
                LogginMenu.getInputForLogginMenu();
                baseResponse.setSuccess(true);
        }
        return baseResponse;
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
