package model.entity;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Config {
    private String ip = "127.0.0.1";
    private int port = 5000;

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

    public void createJsonFile(Config config) throws Exception {
        String json = new Gson().toJson(config);
        FileWriter fileWriter = new FileWriter(this.ip + ".json");
        fileWriter.write(json);
        fileWriter.close();
    }
}
