package client;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.InetAddress;
import java.util.Scanner;

public class Config {
    private InetAddress ip;
    private String name;
    private int port;

    public Config(InetAddress ip, String name, int port) {
        this.ip = ip;
        this.name = name;
        this.port = port;
    }

    public static Config getJsonString(String name) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(name + ".json"));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        Config c = new Gson().fromJson(stringBuilder.toString(), Config.class);
        return c;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void createJsonFile(Config config) throws Exception {
        String json = new Gson().toJson(config);
        FileWriter fileWriter = new FileWriter(this.getName() + ".json");
        fileWriter.write(json);
        fileWriter.close();
    }
}
