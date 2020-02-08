package server;

import Response.BaseResponse;
import client.Connector;
import model.entity.*;
import model.repository.LogginMenu;
import requests.*;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class OnlineAccount extends Thread {
    private static ArrayList<OnlineAccount> onlineAccounts = new ArrayList<>();
    private Account account;
    private Connector connector;

    public OnlineAccount(Socket socket) {
        System.out.println("new client connected");
        try {
            connector = new Connector(socket, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        onlineAccounts.add(this);
        this.start();
    }

    public static ArrayList<OnlineAccount> getOnlineAccounts() {
        return onlineAccounts;
    }

    @Override
    public String toString() {
        return "OnlineAccount{" +
                "account=" + account +
                '}';
    }

    public Account getAccount() {
        return account;
    }

    public BaseResponse resolve(BaseRequest baseRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse();
        //todo
        switch (baseRequest.getType()) {
            case Connection:
                baseResponse.setType(BaseResponse.ResponseType.Connection);
                baseResponse.setSuccess(true);
            case createAccount:
                baseResponse.setType(BaseResponse.ResponseType.createAccount);
                AccountRequest accountRequest = (AccountRequest) baseRequest;
                Account account = LogginMenu.createAccount(accountRequest.getUserName(), accountRequest.getName(), accountRequest.getPass());
                if (account != null) {
                    Account.loggIn(accountRequest.getUserName(), accountRequest.getPass());
                    baseResponse.setSuccess(true);
                } else {
                    baseResponse.setSuccess(false);
                }
                break;
            case login:
                baseResponse.setType(BaseResponse.ResponseType.login);
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
                String text = chatRequest.getText();
                for (Account a : LogginMenu.getAccounts()) {
                    if (a.getName().equals(chatRequest.getId())) {
                        a.getMessages().add(chatRequest.getText());
                        baseResponse.setSuccess(true);
                        System.out.println(text);
                    }
                }

            case reply:
                baseResponse.setType(BaseResponse.ResponseType.send_msg);
                ChatRequest chatRequest1 = (ChatRequest) baseRequest;
                for (Account a : LogginMenu.getAccounts()) {
                    if (a.getName().equals(chatRequest1.getId())) {
                        a.getMessages().add(chatRequest1.getText());
                        baseResponse.setSuccess(true);
                    }
                }
                baseResponse.setSuccess(true);
                break;
            case showOnlineAccounts:
                break;
            case showOfflineAccounts:
                break;
            case notif:
                baseResponse.setType(BaseResponse.ResponseType.notif);
                baseResponse.setSuccess(true);
            case buy:
                break;
            case sell:
                break;

            case showCardsCapacity:
                baseResponse.setType(BaseResponse.ResponseType.showCardsCapacity);
                ShopRequest shopRequest = (ShopRequest) baseRequest;
                for (Plant plant : CovertCardsToJsonString.makeArrayOfPlants()) {
                    System.out.println(plant.getName() + plant.getCapacity());
                }
                baseResponse.setSuccess(true);
            case send_image:
//                baseResponse.setType(BaseResponse.ResponseType.send_image);
//                ChatRequest chatRequest2 = (ChatRequest) baseRequest;
//                try {
//                    //convert received data
//                    System.out.println("File Received!");
//                    String message = org.apache.commons.io.IOUtils.toString(inFromClient);
//                    JSONObject obj1 = (JSONObject) JSONValue.parse(message);
//                    String name = obj1.get("filename").toString();
//                    String image = obj1.get("image").toString();
//
//                    //convert from base64 to byte array
//                    byte[] imageByteArray = Base64.getDecoder().decode(image);
//
//                    //convert byte array to a file image
//                    FileOutputStream imageOutFile = new FileOutputStream(name);
//                    imageOutFile.write(imageByteArray);
//                    imageOutFile.close();
//                    System.out.println("Image Successfully Manipulated!");
//
//                } catch (FileNotFoundException e) {
//                } catch (IOException e) {
//
        }
        return baseResponse;
    }


    private void disconnect() throws InterruptedException {
        onlineAccounts.remove(this);
        this.wait();
        account.logout();
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