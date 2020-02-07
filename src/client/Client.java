package client;

import Response.BaseResponse;
import com.google.gson.Gson;
import model.entity.Account;
import model.repository.Shop;
import requests.AccountRequest;
import requests.BaseRequest;
import requests.ChatRequest;
import requests.CollectionRequest;

import java.io.File;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final static Gson gson = new Gson();
    private static Connector connector;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        File fileReader = new File("config.json");
        Scanner scanner1 = new Scanner(fileReader);
        String configTxt = scanner1.nextLine();
        scanner1.close();
        Config config = gson.fromJson(configTxt, Config.class);
        Socket socket = null;
        socket = new Socket(config.getIp(), config.getPort());
        connector = new Connector(socket);
        //todo connection complete
        Shop.showShop();
        System.out.println("successfully connected");
        System.out.println("enter your request : login, create account, showOnlineAccounts,add new card, send_msg");
        String command = scanner.nextLine();

        switch (command) {
            case "login":
                System.out.println("pls enter yur name , id , pass");
                String[] info = scanner.nextLine().split(" ");
                AccountRequest accountRequest = new AccountRequest(info[1], info[0], info[2], BaseRequest.RequestType.login);
                BaseResponse baseResponse0 = connector.sendRequest(accountRequest);
                System.out.println("logged in");

            case "create account":
                BaseRequest baseRequest1 = new BaseRequest(BaseRequest.RequestType.createAccount, BaseRequest.class.getName());
                BaseResponse baseResponse1 = connector.sendRequest(baseRequest1);
            case "showOnlineAccounts":
                BaseRequest baseRequest2 = new BaseRequest(BaseRequest.RequestType.createAccount, BaseRequest.class.getName());
                BaseResponse baseResponse2 = connector.sendRequest(baseRequest2);
            case "add new card":
                System.out.println("enter yur cardType: plant or zombie");
                String type = scanner.nextLine();
                if (type.equals("plant")) {
                    System.out.println("pls enter yur plant String name, int cost, int health, int sun, boolean isMagnate, boolean ispricky, int coolDown");
                    String[] infoPlant = scanner.nextLine().split(" ");
                    CollectionRequest collectionRequest = new CollectionRequest(infoPlant[0], Integer.parseInt(infoPlant[1]), Integer.parseInt(infoPlant[2]), Integer.parseInt(infoPlant[3]), Boolean.parseBoolean(infoPlant[4]), Boolean.parseBoolean(infoPlant[5]), Integer.parseInt(infoPlant[6]), BaseRequest.RequestType.addCard_plant);
                    BaseResponse baseResponse = connector.sendRequest(collectionRequest);
                } else if (type.equals("zombie")) {
                    System.out.println("pls enter yur zombie String name, int cost, int lifenum, int speed, boolean bumper, boolean iswzater, boolean hasCap, int bumperNum");
                    String[] infoPlant = scanner.nextLine().split(" ");
                    CollectionRequest collectionRequest = new CollectionRequest(infoPlant[0], Integer.parseInt(infoPlant[1]), Integer.parseInt(infoPlant[2]), Integer.parseInt(infoPlant[3]), Boolean.parseBoolean(infoPlant[4]), Boolean.parseBoolean(infoPlant[5]), Boolean.parseBoolean(infoPlant[6]), Integer.parseInt(infoPlant[7]), BaseRequest.RequestType.addCard_zombie);
                    BaseResponse baseResponse = connector.sendRequest(collectionRequest);
                } else {
                    System.out.println("invalid card type");
                }
            case "showOnlinesAcc":
                Account account = new Account();
                for (Account a : account.getOnlineAccounts()) {
                    System.out.println(a.getId());
                }

            case "send_msg":
                System.out.println("enter your msg then enter our freind id");
                String[] textAndId = scanner.nextLine().split(" ");
                ChatRequest chatRequest = new ChatRequest(BaseRequest.RequestType.send_msg, textAndId[0], textAndId[1]);
                BaseResponse baseResponse = connector.sendRequest(chatRequest);

        }
    }

    static void getCommand(Scanner scanner) {

    }
}
