package model.entity;

import org.json.simple.JSONArray;
        import org.json.simple.JSONObject;
        import org.json.simple.parser.JSONParser;

public class JsonCards {
    public static void jsoncardsMethod(String[] args) throws Exception{

        String json="[{\"name\":\"*****\",\"cardType\":\"****\"},{\"name\":\"*****\",\"cardType\":\"*****\"}]";
        JSONArray jsonArray = (JSONArray) new JSONParser().parse(json);
        for (Object o : jsonArray) {
            JSONObject jsonObject = (JSONObject) o;
            System.out.println(jsonObject.get("name"));
            System.out.println(jsonObject.get("family"));
        }
    }
}
