package model.entity;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Config {
    private String ip;
    private int port;

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
        FileWriter fileWriter = new FileWriter(this.getIp()+ ".json");
        fileWriter.write(json);
        fileWriter.close();
    }
}
