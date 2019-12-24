package controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {

            // Writing to a file
            File file=new File("JsonFile.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            System.out.println("Writing JSON object to file");
            System.out.println("-----------------------");

            fileWriter.write(getJsonZombei());
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getJsonZombei() {
        JSONObject regularZombei = new JSONObject();
        regularZombei.put("lifeNumber", "2");
        regularZombei.put("cost","60");
        regularZombei.put("speed", "2");
        regularZombei.put("bumper", "0");
        regularZombei.put("hasCAP", "false");
        regularZombei.put("isBaloon", "false");
        regularZombei.put("bumperLife", "0");
        regularZombei.put("isWater", "false");

        JSONObject FootballZombie = new JSONObject();
        FootballZombie.put("lifeNumber", "4");
        FootballZombie.put("cost","150");
        FootballZombie.put("speed", "3");
        FootballZombie.put("bumper", "0");
        FootballZombie.put("hasCAP", "false");
        FootballZombie.put("isBaloon", "false");
        FootballZombie.put("bumperLife", "0");
        FootballZombie.put("isWater", "false");

        JSONObject BucketheadZombie = new JSONObject();
        BucketheadZombie.put("lifeNumber", "3");
        BucketheadZombie.put("cost","80");
        BucketheadZombie.put("speed", "2");
        BucketheadZombie.put("bumper", "0");
        BucketheadZombie.put("hasCAP", "true");
        BucketheadZombie.put("isBaloon", "false");
        BucketheadZombie.put("bumperLife", "0");
        BucketheadZombie.put("isWater", "false");

        JSONObject ConeheadZombie = new JSONObject();
        ConeheadZombie.put("lifeNumber", "3");
        ConeheadZombie.put("cost","80");
        ConeheadZombie.put("speed", "2");
        ConeheadZombie.put("bumper", "0");
        ConeheadZombie.put("hasCAP", "true");
        ConeheadZombie.put("isBaloon", "false");
        ConeheadZombie.put("bumperLife", "0");
        ConeheadZombie.put("isWater", "false");

        JSONObject Zomboni = new JSONObject();
        Zomboni.put("lifeNumber", "3");
        Zomboni.put("cost","80");
        Zomboni.put("speed", "2");
        Zomboni.put("bumper", "0");
        Zomboni.put("hasCAP", "false");
        Zomboni.put("isBaloon", "false");
        Zomboni.put("bumperLife", "0");
        Zomboni.put("isWater", "false");

        JSONObject CatapultZombie = new JSONObject();
        CatapultZombie.put("lifeNumber", "3");
        CatapultZombie.put("cost","80");
        CatapultZombie.put("speed", "2");
        CatapultZombie.put("bumper", "0");
        CatapultZombie.put("hasCAP", "false");
        CatapultZombie.put("isBaloon", "false");
        CatapultZombie.put("bumperLife", "0");
        CatapultZombie.put("isWater", "false");

        JSONObject BungeeZombie = new JSONObject();
        BungeeZombie.put("lifeNumber", "3");
        BungeeZombie.put("cost","0");
        BungeeZombie.put("speed", "0");
        BungeeZombie.put("bumper", "0");
        BungeeZombie.put("hasCAP", "false");
        BungeeZombie.put("isBaloon", "false");
        BungeeZombie.put("bumperLife", "0");
        BungeeZombie.put("isWater", "false");

        JSONObject BalloonZombie = new JSONObject();
        BalloonZombie.put("lifeNumber", "3");
        BalloonZombie.put("cost","80");
        BalloonZombie.put("speed", "2");
        BalloonZombie.put("bumper", "0");
        BalloonZombie.put("hasCAP", "false");
        BalloonZombie.put("isBaloon", "true");
        BalloonZombie.put("bumperLife", "0");
        BalloonZombie.put("isWater", "false");

        JSONObject NewspaperZombie = new JSONObject();
        NewspaperZombie.put("lifeNumber", "2");
        NewspaperZombie.put("cost","60");
        NewspaperZombie.put("speed", "2");
        NewspaperZombie.put("bumper", "1");
        NewspaperZombie.put("hasCAP", "false");
        NewspaperZombie.put("isBaloon", "false");
        NewspaperZombie.put("bumperLife", "2");
        NewspaperZombie.put("isWater", "false");

        JSONObject TargetZombie = new JSONObject();
        TargetZombie.put("lifeNumber", "3");
        TargetZombie.put("cost","80");
        TargetZombie.put("speed", "2");
        TargetZombie.put("bumper", "1");
        TargetZombie.put("hasCAP", "false");
        TargetZombie.put("isBaloon", "false");
        TargetZombie.put("bumperLife", "3");
        TargetZombie.put("isWater", "false");

        JSONObject ScreenDoorZombie = new JSONObject();
        ScreenDoorZombie.put("lifeNumber", "2");
        ScreenDoorZombie.put("cost","60");
        ScreenDoorZombie.put("speed", "2");
        ScreenDoorZombie.put("bumper", "1");
        ScreenDoorZombie.put("hasCAP", "false");
        ScreenDoorZombie.put("isBaloon", "false");
        ScreenDoorZombie.put("bumperLife", "4");
        ScreenDoorZombie.put("isWater", "false");

        JSONObject GigaGargantuar = new JSONObject();
        GigaGargantuar.put("lifeNumber", "6");
        ScreenDoorZombie.put("cost","70");
        GigaGargantuar.put("speed", "1");
        GigaGargantuar.put("bumper", "0");
        GigaGargantuar.put("hasCAP", "false");
        GigaGargantuar.put("isBaloon", "false");
        GigaGargantuar.put("bumperLife", "0");
        GigaGargantuar.put("isWater", "false");

        JSONObject pogoZombie = new JSONObject();
        pogoZombie.put("lifeNumber", "2");
        pogoZombie.put("cost","60");
        pogoZombie.put("speed", "2");
        pogoZombie.put("bumper", "0");
        pogoZombie.put("hasCAP", "false");
        pogoZombie.put("isBaloon", "false");
        pogoZombie.put("bumperLife", "0");
        pogoZombie.put("isWater", "false");

        JSONObject SnorkelZombie = new JSONObject();
        SnorkelZombie.put("lifeNumber", "2");
        SnorkelZombie.put("cost","60");
        SnorkelZombie.put("speed", "2");
        SnorkelZombie.put("bumper", "0");
        SnorkelZombie.put("hasCAP", "false");
        SnorkelZombie.put("isBaloon", "false");
        SnorkelZombie.put("bumperLife", "0");
        SnorkelZombie.put("isWater", "true");

        JSONObject DolphinRiderZombie = new JSONObject();
        DolphinRiderZombie.put("lifeNumber", "2");
        DolphinRiderZombie.put("cost","60");
        DolphinRiderZombie.put("speed", "2");
        DolphinRiderZombie.put("bumper", "1");
        DolphinRiderZombie.put("hasCAP", "false");
        DolphinRiderZombie.put("isBaloon", "false");
        DolphinRiderZombie.put("bumperLife", "2");
        DolphinRiderZombie.put("isWater", "true");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(regularZombei);
        jsonArray.add(FootballZombie);
        jsonArray.add(BucketheadZombie);
        jsonArray.add(ConeheadZombie);
        jsonArray.add(Zomboni);
        jsonArray.add(CatapultZombie);
        jsonArray.add(BungeeZombie);
        jsonArray.add(BalloonZombie);
        jsonArray.add(NewspaperZombie);
        jsonArray.add(TargetZombie);
        jsonArray.add(ScreenDoorZombie);
        jsonArray.add(GigaGargantuar);
        jsonArray.add(pogoZombie);
        jsonArray.add(SnorkelZombie);
        jsonArray.add(DolphinRiderZombie);

        return jsonArray.toJSONString();

    }

    public static String getJsonPlants() {
        JSONObject Peashooter = new JSONObject();
        Peashooter.put("health", "2");
        Peashooter.put("sun", "2");
        Peashooter.put("coolDown", "2");

        JSONObject SnowPea = new JSONObject();
        SnowPea.put("health", "3");
        SnowPea.put("sun", "3");
        SnowPea.put("coolDown", "3");

        JSONObject CabbagePult = new JSONObject();
        CabbagePult.put("health", "2");
        CabbagePult.put("sun", "2");
        CabbagePult.put("coolDown", "3");

        JSONObject Repeater = new JSONObject();
        Repeater.put("health", "4");
        Repeater.put("sun", "3");
        Repeater.put("coolDown", "3");

        JSONObject Threepeater = new JSONObject();
        Threepeater.put("health", "5");
        Threepeater.put("sun", "4");
        Threepeater.put("coolDown", "4");

        JSONObject Cactus = new JSONObject();
        Cactus.put("health", "5");
        Cactus.put("sun", "5");
        Cactus.put("coolDown", "4");

        JSONObject GatlingPea = new JSONObject();
        GatlingPea.put("health", "5");
        GatlingPea.put("sun", "5");
        GatlingPea.put("coolDown", "4");

        JSONObject ScaredyShroom = new JSONObject();
        ScaredyShroom.put("health", "3");
        ScaredyShroom.put("sun", "5");
        ScaredyShroom.put("coolDown", "4");

        JSONObject KernelPult = new JSONObject();
        KernelPult.put("health", "1");
        KernelPult.put("sun", "1");
        KernelPult.put("coolDown", "2");

        JSONObject SplitPea = new JSONObject();
        SplitPea.put("health", "2");
        SplitPea.put("sun", "3");
        SplitPea.put("coolDown", "3");

        JSONObject ExplodeOnut = new JSONObject();
        ExplodeOnut.put("health", "3");
        ExplodeOnut.put("sun", "4");
        ExplodeOnut.put("coolDown", "4");

        JSONObject MelonPult = new JSONObject();
        MelonPult.put("health", "3");
        MelonPult.put("sun", "4");
        MelonPult.put("coolDown", "5");

        JSONObject LilyPad = new JSONObject();
        LilyPad.put("health", "3");
        LilyPad.put("sun", "3");
        LilyPad.put("coolDown", "3");

        JSONObject WinterMelon = new JSONObject();
        WinterMelon.put("health", "1");
        WinterMelon.put("sun", "0");
        WinterMelon.put("coolDown", "1");

        JSONObject WallNut = new JSONObject();
        WallNut.put("health", "3");
        WallNut.put("sun", "4");
        WallNut.put("coolDown", "5");

        JSONObject TangleKelp = new JSONObject();
        TangleKelp.put("health", "4");
        TangleKelp.put("sun", "2");
        TangleKelp.put("coolDown", "4");

        JSONObject TallNut = new JSONObject();
        TallNut.put("health", "0");
        TallNut.put("sun", "3");
        TallNut.put("coolDown", "3");

        JSONObject Cattail = new JSONObject();
        Cattail.put("health", "6");
        Cattail.put("sun", "4");
        Cattail.put("coolDown", "6");

        JSONObject PotatoMine = new JSONObject();
        PotatoMine.put("health", "3");
        PotatoMine.put("sun", "5");
        PotatoMine.put("coolDown", "5");

        JSONObject cherryBomb = new JSONObject();
        cherryBomb.put("health", "0");
        cherryBomb.put("sun", "2");
        cherryBomb.put("coolDown", "4");

        JSONObject MagnetShroom = new JSONObject();
        MagnetShroom.put("health", "2");
        MagnetShroom.put("sun", "4");
        MagnetShroom.put("coolDown", "4");

        JSONObject Sunflower = new JSONObject();
        Sunflower.put("health", "2");
        Sunflower.put("sun", "1");
        Sunflower.put("coolDown", "2");

        JSONObject TwinSunflower = new JSONObject();
        TwinSunflower.put("health", "2");
        TwinSunflower.put("sun", "3");
        TwinSunflower.put("coolDown", "5");

        JSONObject Jalapeno = new JSONObject();
        Jalapeno.put("sun", "4");
        Jalapeno.put("coolDown", "5");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(Peashooter);
        jsonArray.add(SnowPea);
        jsonArray.add(CabbagePult);
        jsonArray.add(Repeater);
        jsonArray.add(Threepeater);
        jsonArray.add(Cactus);
        jsonArray.add(GatlingPea);
        jsonArray.add(ScaredyShroom);
        jsonArray.add(KernelPult);
        jsonArray.add(SplitPea);
        jsonArray.add(ExplodeOnut);
        jsonArray.add(MelonPult);
        jsonArray.add(LilyPad);
        jsonArray.add(WinterMelon);
        jsonArray.add(WallNut);
        jsonArray.add(TangleKelp);
        jsonArray.add(TallNut);
        jsonArray.add(Cattail);
        jsonArray.add(PotatoMine);
        jsonArray.add(cherryBomb);
        jsonArray.add(MagnetShroom);
        jsonArray.add(Sunflower);
        jsonArray.add(TwinSunflower);
        jsonArray.add(Jalapeno);
        return jsonArray.toJSONString();
    }


}