package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        InetAddress host = InetAddress.getLocalHost();
        System.out.println("enter name,ip,port");
        String[] input = scanner.nextLine().split(" ");
        int autoTuken = 0;
        ArrayList<Integer> AutoTukensSave = new ArrayList<>();
        Config config = new Config(host, input[0], Integer.parseInt(input[2]));
        config.createJsonFile(config);
        //String host = config.getJsonString(input[0]).getIp();
        int port = config.getJsonString(input[0]).getPort();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        for (int i = 0; i < 5; i++) {
            //establish socket connection to server
            socket = new Socket(host, port);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            if (i == 4) oos.writeObject("exit");
            else oos.writeObject("" + i);
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);
            //close resources
            ois.close();
            oos.close();
            Thread.sleep(100);
        }
    }

    static void getCommand(Scanner scanner) {

    }
}
