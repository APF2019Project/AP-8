package client;

import com.google.gson.Gson;

import java.io.PrintWriter;
import java.util.Scanner;

public class Connector {
    Gson gson = new Gson();
    Scanner in;
    PrintWriter out;
    public void send(){
        String gsonText;
        gsonText = in.nextLine();
        //todo class
        Object request = gson.fromJson(gsonText,String.class);
        //todo resolve
        Object Response = null;
        gsonText = gson.toJson(Response);
        out.println(gsonText);
    }

}
