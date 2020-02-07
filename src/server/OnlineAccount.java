package server;

import Response.BaseResponse;
import client.Connector;
import model.entity.*;
import model.repository.LogginMenu;
import requests.AccountRequest;
import requests.BaseRequest;
import requests.CollectionRequest;
import requests.ChatRequest;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class OnlineAccount implements Runnable {
    private static ArrayList<OnlineAccount> onlineAccounts = new ArrayList<>();
    private Connector connector;
    private static Account account;

    public static Account getAccount() {
        return account;
    }

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

    public static ArrayList<OnlineAccount> getOnlineAccounts() {
        return onlineAccounts;
    }

    public BaseResponse resolve(BaseRequest baseRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse();
        //todo
        switch (baseRequest.getType()) {
            case Connection:
                baseResponse.setType(BaseResponse.ResponseType.Connection);
                baseResponse.setSuccess(true);
            case login:
                baseResponse.setType(BaseResponse.ResponseType.login);
                AccountRequest accountRequest = (AccountRequest) baseRequest;
                LogginMenu.createAccount(accountRequest.getUserName(), accountRequest.getName(), accountRequest.getPass());
                account.getOnlineAccounts().add(account);
                account.setOnline(true);
                baseResponse.setSuccess(true);
                break;
            case createAccount:
                baseResponse.setType(BaseResponse.ResponseType.createAccount);
                baseResponse.setSuccess(true);
                break;
            case addCard_plant:
                baseResponse.setType(BaseResponse.ResponseType.addCard_plant);
                CollectionRequest collectionRequest = (CollectionRequest) baseRequest;
                Plant p = new Plant(collectionRequest.getName(), CardType.PLANT, collectionRequest.getHealth(), collectionRequest.getCoolDown(), collectionRequest.getSun(), collectionRequest.isMagnate(), collectionRequest.isIspricky(), collectionRequest.getCost());
                CovertCardsToJsonString covertCardsToJsonString = new CovertCardsToJsonString();
                covertCardsToJsonString.createPlants(p);
                baseResponse.setSuccess(true);
                break;
            case addCard_zombie:
                baseResponse.setType(BaseResponse.ResponseType.addCard_zombie);
                CollectionRequest collectionRequest1 = (CollectionRequest) baseRequest;
                Zombie zombie = new Zombie(collectionRequest1.getName(), CardType.ZOMBIE, collectionRequest1.getLifenum(), collectionRequest1.isHasCap(), collectionRequest1.getBumperNum(), collectionRequest1.getSpeed(), collectionRequest1.isIswzater(), collectionRequest1.getCost());
                CovertCardsToJsonString covertCardsToJsonString1 = new CovertCardsToJsonString();
                covertCardsToJsonString1.createZombies(zombie);
                baseResponse.setSuccess(true);
                break;
            case send_msg:
                baseResponse.setType(BaseResponse.ResponseType.send_msg);
                ChatRequest chatRequest = (ChatRequest) baseRequest;
                if (account.getId()==Integer.parseInt(chatRequest.getId()));
                account.getMessages().add(chatRequest.getText());
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
