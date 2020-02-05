package client;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main  extends Application {
    private Scanner in;
    private PrintWriter out;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Socket socket = new Socket(Config.getJsonString("127.0.0.1").getIp(),Config.getJsonString("127.0.0.1").getPort());
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException exception) {
            System.err.println("Server not available");
            return;
        }
    }
}
