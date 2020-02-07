package server;

import Response.BaseResponse;
import client.Connector;
import model.entity.Account;
import model.repository.LogginMenu;
import requests.AccountRequest;
import requests.BaseRequest;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

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

    public BaseResponse resolve(BaseRequest baseRequest)throws Exception {
        BaseResponse baseResponse = new BaseResponse();
        //todo
        switch (baseRequest.getType()) {
            case Connection:
                baseResponse.setType(BaseResponse.ResponseType.Connection);
                baseResponse.setSuccess(true);
            case login:
                baseResponse.setType(BaseResponse.ResponseType.login);
                AccountRequest accountRequest =  (AccountRequest) baseRequest;
                LogginMenu.createAccount(accountRequest.getUserName(),accountRequest.getName(),accountRequest.getPass());
                baseResponse.setSuccess(true);
            case createAccount:
                baseResponse.setType(BaseResponse.ResponseType.createAccount);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
