package model.entity;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class ZombeiCard {
//    public String getJson() {
//        JSONObject regularZombei = new JSONObject();
//        regularZombei.put("lifeNumber", "2");
//        regularZombei.put("speed", "2");
//        regularZombei.put("bumper", "0");
//        regularZombei.put("hasCAP", "false");
//        regularZombei.put("isBaloon", "false");
//        regularZombei.put("bumperLife", "0");
//        regularZombei.put("isWater", "false");
//
//        JSONObject FootballZombie = new JSONObject();
//        FootballZombie.put("lifeNumber", "4");
//        FootballZombie.put("speed", "3");
//        FootballZombie.put("bumper", "0");
//        FootballZombie.put("hasCAP", "false");
//        FootballZombie.put("isBaloon", "false");
//        FootballZombie.put("bumperLife", "0");
//        FootballZombie.put("isWater", "false");
//
//        JSONObject BucketheadZombie = new JSONObject();
//        BucketheadZombie.put("lifeNumber", "3");
//        BucketheadZombie.put("speed", "2");
//        BucketheadZombie.put("bumper", "0");
//        BucketheadZombie.put("hasCAP", "true");
//        BucketheadZombie.put("isBaloon", "false");
//        BucketheadZombie.put("bumperLife", "0");
//        BucketheadZombie.put("isWater", "false");
//
//        JSONObject ConeheadZombie = new JSONObject();
//        ConeheadZombie.put("lifeNumber", "3");
//        ConeheadZombie.put("speed", "2");
//        ConeheadZombie.put("bumper", "0");
//        ConeheadZombie.put("hasCAP", "true");
//        ConeheadZombie.put("isBaloon", "false");
//        ConeheadZombie.put("bumperLife", "0");
//        ConeheadZombie.put("isWater", "false");
//
//        JSONObject Zomboni = new JSONObject();
//        Zomboni.put("lifeNumber", "3");
//        Zomboni.put("speed", "2");
//        Zomboni.put("bumper", "0");
//        Zomboni.put("hasCAP", "false");
//        Zomboni.put("isBaloon", "false");
//        Zomboni.put("bumperLife", "0");
//        Zomboni.put("isWater", "false");
//
//        JSONObject CatapultZombie = new JSONObject();
//        CatapultZombie.put("lifeNumber", "3");
//        CatapultZombie.put("speed", "2");
//        CatapultZombie.put("bumper", "0");
//        CatapultZombie.put("hasCAP", "false");
//        CatapultZombie.put("isBaloon", "false");
//        CatapultZombie.put("bumperLife", "0");
//        CatapultZombie.put("isWater", "false");
//
//        JSONObject BungeeZombie = new JSONObject();
//        BungeeZombie.put("lifeNumber", "3");
//        BungeeZombie.put("speed", "0");
//        BungeeZombie.put("bumper", "0");
//        BungeeZombie.put("hasCAP", "false");
//        BungeeZombie.put("isBaloon", "false");
//        BungeeZombie.put("bumperLife", "0");
//        BungeeZombie.put("isWater", "false");
//
//        JSONObject BalloonZombie = new JSONObject();
//        BalloonZombie.put("lifeNumber", "3");
//        BalloonZombie.put("speed", "2");
//        BalloonZombie.put("bumper", "0");
//        BalloonZombie.put("hasCAP", "false");
//        BalloonZombie.put("isBaloon", "true");
//        BalloonZombie.put("bumperLife", "0");
//        BalloonZombie.put("isWater", "false");
//
//        JSONObject NewspaperZombie = new JSONObject();
//        NewspaperZombie.put("lifeNumber", "2");
//        NewspaperZombie.put("speed", "2");
//        NewspaperZombie.put("bumper", "1");
//        NewspaperZombie.put("hasCAP", "false");
//        NewspaperZombie.put("isBaloon", "false");
//        NewspaperZombie.put("bumperLife", "2");
//        NewspaperZombie.put("isWater", "false");
//
//        JSONObject TargetZombie = new JSONObject();
//        TargetZombie.put("lifeNumber", "3");
//        TargetZombie.put("speed", "2");
//        TargetZombie.put("bumper", "1");
//        TargetZombie.put("hasCAP", "false");
//        TargetZombie.put("isBaloon", "false");
//        TargetZombie.put("bumperLife", "3");
//        TargetZombie.put("isWater", "false");
//
//        JSONObject ScreenDoorZombie = new JSONObject();
//        ScreenDoorZombie.put("lifeNumber", "2");
//        ScreenDoorZombie.put("speed", "2");
//        ScreenDoorZombie.put("bumper", "1");
//        ScreenDoorZombie.put("hasCAP", "false");
//        ScreenDoorZombie.put("isBaloon", "false");
//        ScreenDoorZombie.put("bumperLife", "4");
//        ScreenDoorZombie.put("isWater", "false");
//
//        JSONObject GigaGargantuar = new JSONObject();
//        GigaGargantuar.put("lifeNumber", "6");
//        GigaGargantuar.put("speed", "1");
//        GigaGargantuar.put("bumper", "0");
//        GigaGargantuar.put("hasCAP", "false");
//        GigaGargantuar.put("isBaloon", "false");
//        GigaGargantuar.put("bumperLife", "0");
//        GigaGargantuar.put("isWater", "false");
//
//        JSONObject pogoZombie = new JSONObject();
//        pogoZombie.put("lifeNumber", "2");
//        pogoZombie.put("speed", "2");
//        pogoZombie.put("bumper", "0");
//        pogoZombie.put("hasCAP", "false");
//        pogoZombie.put("isBaloon", "false");
//        pogoZombie.put("bumperLife", "0");
//        pogoZombie.put("isWater", "false");
//
//        JSONObject SnorkelZombie = new JSONObject();
//        SnorkelZombie.put("lifeNumber", "2");
//        SnorkelZombie.put("speed", "2");
//        SnorkelZombie.put("bumper", "0");
//        SnorkelZombie.put("hasCAP", "false");
//        SnorkelZombie.put("isBaloon", "false");
//        SnorkelZombie.put("bumperLife", "0");
//        SnorkelZombie.put("isWater", "true");
//
//        JSONObject DolphinRiderZombie = new JSONObject();
//        DolphinRiderZombie.put("lifeNumber", "2");
//        DolphinRiderZombie.put("speed", "2");
//        DolphinRiderZombie.put("bumper", "1");
//        DolphinRiderZombie.put("hasCAP", "false");
//        DolphinRiderZombie.put("isBaloon", "false");
//        DolphinRiderZombie.put("bumperLife", "2");
//        DolphinRiderZombie.put("isWater", "true");
//
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.add(regularZombei);
//        jsonArray.add(FootballZombie);
//        jsonArray.add(BucketheadZombie);
//        jsonArray.add(ConeheadZombie);
//        jsonArray.add(Zomboni);
//        jsonArray.add(CatapultZombie);
//        jsonArray.add(BungeeZombie);
//        jsonArray.add(BalloonZombie);
//        jsonArray.add(NewspaperZombie);
//        jsonArray.add(TargetZombie);
//        jsonArray.add(ScreenDoorZombie);
//        jsonArray.add(GigaGargantuar);
//        jsonArray.add(pogoZombie);
//        jsonArray.add(SnorkelZombie);
//        jsonArray.add(DolphinRiderZombie);
//
//        return jsonArray.toJSONString();
//
//    }
//
//    public void piyadeSaziJsonZombei() {
//        try {
//            FileWriter file = new FileWriter("Zombeis.json");
//            file.write(getJson());
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

}
