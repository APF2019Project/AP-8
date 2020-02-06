package client;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Config {
    public static Scanner input;
    public static String[] string;
    private String ip;
    private String name;
    private int port;

    public Config(String ip, String name, int port) {
        this.ip = ip;
        this.name = name;
        this.port = port;
    }

    public Config() {
    }

    public static void setInput(Scanner scanner) {
        input = scanner;
        string = input.nextLine().split(" ");
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

    public void setConfigFields(Scanner scanner) throws Exception {
        System.out.println("please enter ip then port then a name");
        String IP = string[0];
        int port = Integer.parseInt(string[1]);
        String name = string[2];
        Config c = new Config(IP, name, port);
        createJsonFile(c);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
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
