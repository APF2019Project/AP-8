package client;

import Response.BaseResponse;
import com.google.gson.Gson;
import requests.BaseRequest;
import server.OnlineAccount;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.Scanner;

public class Connector {
    Gson gson = new Gson();
    Scanner in;
    PrintWriter out;
    OnlineAccount onlineAccount;

    public Connector(Socket socket) throws IOException {
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream());
    }

    public Connector(Socket socket, OnlineAccount onlineAccount) throws IOException {
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream());
        this.onlineAccount = onlineAccount;
    }

    public BaseResponse sendRequest(BaseRequest baseRequest) throws ClassNotFoundException {
        String gsonText;
        gsonText = gson.toJson(baseRequest);
        out.println(gsonText );
        out.flush();
        while (true) {
            if (in.hasNextLine()) {
                gsonText = in.nextLine();
                break;
            }
        }
        BaseResponse response = gson.fromJson(gsonText, BaseResponse.class);
        Class responseClass = BaseResponse.class;
        try {
            responseClass = Class.forName(response.getResponseClass());
        } catch (Exception e) {
        }
        response = gson.fromJson(gsonText, (Type) responseClass);
        return response;
    }

    public void resolve() throws ClassNotFoundException {
        String gsonTxt;
        while (true) {
            if (in.hasNextLine()) {
                gsonTxt = in.nextLine();
                break;
            }
        }
        BaseRequest request = gson.fromJson(gsonTxt, BaseRequest.class);
        Class requestClass = BaseRequest.class;
        try {
            requestClass = Class.forName(request.getRequestClass());
        } catch (Exception e) {
        }
        request = gson.fromJson(gsonTxt, (Type) requestClass);
        BaseResponse baseResponse = onlineAccount.resolve(request);
        gsonTxt = gson.toJson(baseResponse);
        out.println(gsonTxt);
        out.flush();
    }

}
