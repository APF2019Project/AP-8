package model.entity;

import controller.Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PlantCard {
    private static Plant returnPlant(String name) throws Exception {
        JSONArray jsonArray = (JSONArray) new JSONParser().parse(getJsonPlants());
        for (Object o : jsonArray) {
            JSONObject jsonObject = (JSONObject) o;
            if (((JSONObject) o).get("name") == name) {
                return (Plant) o;
            }
        }
        return null;
    }
}
