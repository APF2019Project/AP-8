package client;

import Response.BaseResponse;
import com.google.gson.Gson;
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
        System.out.println("enter your request : login, create account, ");
        String command = scanner.nextLine();
        switch (command) {
            case "login":
                BaseRequest baseRequest0 = new BaseRequest(BaseRequest.RequestType.login, BaseRequest.class.getName());
                BaseResponse baseResponse0 = connector.sendRequest(baseRequest0);
            case "create account":
                BaseRequest baseRequest1 = new BaseRequest(BaseRequest.RequestType.createAccount, BaseRequest.class.getName());
                BaseResponse baseResponse1 = connector.sendRequest(baseRequest1);
        }
        BaseRequest baseRequest = new BaseRequest(BaseRequest.RequestType.Connection, BaseRequest.class.getName());
        BaseResponse baseResponse = connector.sendRequest(baseRequest);
        System.out.println(baseResponse.isSuccess());
    }

    static void getCommand(Scanner scanner) {

    }
}
