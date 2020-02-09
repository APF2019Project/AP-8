package client;

import Response.BaseResponse;
import Response.NotifResponse;
import com.google.gson.Gson;
import model.entity.CardType;
import model.repository.Shop;
import requests.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final static Gson gson = new Gson();
    private static Connector connector;

    public static void main(String[] args) throws Exception {
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    Scanner scanner = new Scanner(System.in);
//                    File fileReader = new File("config.json");
//                    Scanner scanner1 = new Scanner(fileReader);
//                    String configTxt = scanner1.nextLine();
//                    scanner1.close();
//                    Config config = gson.fromJson(configTxt, Config.class);
//                    Socket socket = null;
//                    socket = new Socket(config.getIp(), config.getPort());
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//            }
//        };
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
        System.out.println("enter your request : login, create account, showOnlineAccounts,add new card, send_msg, send_image, recieve_image ");

        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "recieve_image":
                    BaseRequest baseRequest = new BaseRequest(BaseRequest.RequestType.recive_image, BaseRequest.class.getName());
                    BaseResponse imageResponse = connector.sendRequest(baseRequest);
                case "login":
                    System.out.println("pls enter yur name , id , pass");
                    String[] info = scanner.nextLine().split(" ");
                    AccountRequest accountRequest = new AccountRequest(info[1], info[0], info[2], BaseRequest.RequestType.login);
                    BaseResponse baseResponse0 = connector.sendRequest(accountRequest);
                    System.out.println("logged in");
                    break;

                case "create account":
                    System.out.println("pls enter yur name , id , pass");
                    String[] information = scanner.nextLine().split(" ");
                    AccountRequest accountRequest1 = new AccountRequest(information[1], information[0], information[2], BaseRequest.RequestType.createAccount);
                    BaseResponse baseResponse1 = connector.sendRequest(accountRequest1);
                    System.out.println("account created");
                    break;
                case "showOnlineAccounts":
                    BaseRequest baseRequest2 = new BaseRequest(BaseRequest.RequestType.createAccount, BaseRequest.class.getName());
                    BaseResponse baseResponse2 = connector.sendRequest(baseRequest2);
                    break;
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
                case "send_msg":
                    System.out.println("******wellcome to chatRoom******* ");
                    System.out.println("enter your msg then enter yur freind id");
                    String[] textAndId = scanner.nextLine().split(" ");
                    ChatRequest chatRequest = new ChatRequest(BaseRequest.RequestType.send_msg, textAndId[0], textAndId[1]);
                    BaseResponse baseResponse = connector.sendRequest(chatRequest);
//                BaseRequest baseRequest = new BaseRequest(BaseRequest.RequestType.notif,BaseRequest.class.getName());
//                BaseResponse baseResponse3 = connector.sendRequest(baseRequest);
                    System.out.println("msg sent wait for answer...");
                case "reply":
                    System.out.println("****you have a new msg do yu want to answer" +
                            "yes or no");
                    String yesOrNo = scanner.nextLine();
                    if (yesOrNo.equals("yes")) {
                        System.out.println("enter your msg then enter yur freind id");
                        String[] textAndId1 = scanner.nextLine().split(" ");
                        ChatRequest chatRequest1 = new ChatRequest(BaseRequest.RequestType.send_msg, textAndId1[0], textAndId1[1]);
                        BaseResponse baseResponse5 = connector.sendRequest(chatRequest1);
                        System.out.println("yur anwser sent...");
                    } else {
                        break;
                    }
                case "show cards":
                    ShopRequest shopRequest = new ShopRequest(BaseRequest.RequestType.showCardsCapacity, CardType.PLANT);
                    BaseResponse baseResponse3 = connector.sendRequest(shopRequest);
                case "send_image":
                    System.out.println("to who would yu like to send msg" +
                            "enter his/her name");
                    String path = "image1.JPG";
                    //the file to convert is in the same folder as the source code
                    File file = new File("image1.JPG");
                    try {
                        //Image conversion to byte array
                        FileInputStream imageInFile = new FileInputStream(file);
                        byte imageData[] = new byte[(int) file.length()];
                        imageInFile.read(imageData);

                        String name1 = scanner.nextLine();
                        ImageRequest imageRequest = new ImageRequest(BaseRequest.RequestType.send_image, imageData, name1);
                        BaseResponse baseResponse5 = connector.sendRequest(imageRequest);

//                        //Image conversion byte array in Base64 String
//                        String imageDataString = Base64.getEncoder().encodeToString(imageData);
//                        imageInFile.close();
//                        System.out.println("Image Successfully Manipulated!");
//
//                        //the object that will be send to Server
//                        JSONObject obj = new JSONObject();
//                        //name of the image
//                        obj.put("filename", "newImage.png");
//                        //string obteined by the conversion of the image
//                        obj.put("image", imageDataString);
//
//                        //connection to erver
//                        Socket clientSocket = new Socket("localhost", 7777);
//                        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
//
//                        //send data
//                        outToServer.writeBytes(obj.toJSONString());
                        System.out.println("File Sent!");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

            }

        }
    }
}
