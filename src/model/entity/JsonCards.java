package model.entity;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonCards {
    public static void jsoncardsMethod() throws Exception {
        JSONArray jsonArray = new JSONArray();


        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name","***");
        jsonObject1.put("cardType","***");


        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name","**");
        jsonObject2.put("cardType","***");


        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        System.out.println(jsonArray.toJSONString());
        }
    }
}
