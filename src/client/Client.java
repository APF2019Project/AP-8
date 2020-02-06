package client;

import Response.BaseResponse;
import com.google.gson.Gson;
import requests.BaseRequest;

import java.io.File;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
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
        Config config = gson.fromJson(configTxt,Config.class);
//        String[] input = scanner.nextLine().split(" ");
//        int autoTuken = 0;
//        ArrayList<Integer> AutoTukensSave = new ArrayList<>();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        socket = new Socket(config.getIp(),config.getPort());
        connector = new Connector(socket);
        //todo connection complete
        System.out.println("successfully connected");
        BaseRequest baseRequest = new BaseRequest(BaseRequest.RequestType.Connection,BaseRequest.class.getName());
        BaseResponse baseResponse = connector.sendRequest(baseRequest);
        System.out.println(baseResponse.isSuccess());
    }

    static void getCommand(Scanner scanner) {

    }
}
