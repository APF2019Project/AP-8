package client;

import Response.BaseResponse;
import com.google.gson.Gson;
import requests.AccountRequest;
import requests.BaseRequest;

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
        System.out.println("successfully connected");
        System.out.println("enter your request : login, create account, showOnlineAccounts, ");
        String command = scanner.nextLine();
        BaseRequest baseRequest = new BaseRequest(BaseRequest.RequestType.Connection, BaseRequest.class.getName());
        BaseResponse baseResponse = connector.sendRequest(baseRequest);
        System.out.println(baseResponse.isSuccess());
        switch (command) {
            case "login":
                System.out.println("pls enter yur name , id , pass");
                String[] info = scanner.nextLine().split(" ");
                AccountRequest accountRequest = new AccountRequest(info[1], info[0], info[2], BaseRequest.RequestType.login);
                BaseResponse baseResponse0 = connector.sendRequest(accountRequest);
                //     BaseRequest baseRequest0 = new BaseRequest(BaseRequest.RequestType.login, BaseRequest.class.getName());
                //     BaseResponse baseResponse0 = connector.sendRequest(baseRequest0);
            case "create account":
                BaseRequest baseRequest1 = new BaseRequest(BaseRequest.RequestType.createAccount, BaseRequest.class.getName());
                BaseResponse baseResponse1 = connector.sendRequest(baseRequest1);
            case "showOnlineAccounts":
                BaseRequest baseRequest2 = new BaseRequest(BaseRequest.RequestType.createAccount, BaseRequest.class.getName());
                BaseResponse baseResponse2 = connector.sendRequest(baseRequest2);
        }
    }

    static void getCommand(Scanner scanner) {

    }
}
