package controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    //    makeZombiesFile();
    //    makePlantsFile();
    }

    private static void makeZombiesFile()
    {
        try {

            // Writing to a file
            File file = new File("ZombieJsonFile.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(getJsonZombei());
            fileWriter.flush();
            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void makePlantsFile()
    {
        try {

            // Writing to a file
            File file = new File("PlantsJsonFile.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(getJsonPlants());
            fileWriter.flush();
            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getJsonZombei() {
        JSONObject regularZombei = new JSONObject();
        regularZombei.put("lifeNumber", "2");
        regularZombei.put("cost", "60");
        regularZombei.put("speed", "2");
        regularZombei.put("bumper", "0");
        regularZombei.put("hasCAP", "false");
        regularZombei.put("isBaloon", "false");
        regularZombei.put("bumperLife", "0");
        regularZombei.put("isWater", "false");

        JSONObject FootballZombie = new JSONObject();
        FootballZombie.put("lifeNumber", "4");
        FootballZombie.put("cost", "150");
        FootballZombie.put("speed", "3");
        FootballZombie.put("bumper", "0");
        FootballZombie.put("hasCAP", "false");
        FootballZombie.put("isBaloon", "false");
        FootballZombie.put("bumperLife", "0");
        FootballZombie.put("isWater", "false");

        JSONObject BucketheadZombie = new JSONObject();
        BucketheadZombie.put("lifeNumber", "3");
        BucketheadZombie.put("cost", "80");
        BucketheadZombie.put("speed", "2");
        BucketheadZombie.put("bumper", "0");
        BucketheadZombie.put("hasCAP", "true");
        BucketheadZombie.put("isBaloon", "false");
        BucketheadZombie.put("bumperLife", "0");
        BucketheadZombie.put("isWater", "false");

        JSONObject ConeheadZombie = new JSONObject();
        ConeheadZombie.put("lifeNumber", "3");
        ConeheadZombie.put("cost", "80");
        ConeheadZombie.put("speed", "2");
        ConeheadZombie.put("bumper", "0");
        ConeheadZombie.put("hasCAP", "true");
        ConeheadZombie.put("isBaloon", "false");
        ConeheadZombie.put("bumperLife", "0");
        ConeheadZombie.put("isWater", "false");

        JSONObject Zomboni = new JSONObject();
        Zomboni.put("lifeNumber", "3");
        Zomboni.put("cost", "80");
        Zomboni.put("speed", "2");
        Zomboni.put("bumper", "0");
        Zomboni.put("hasCAP", "false");
        Zomboni.put("isBaloon", "false");
        Zomboni.put("bumperLife", "0");
        Zomboni.put("isWater", "false");

        JSONObject CatapultZombie = new JSONObject();
        CatapultZombie.put("lifeNumber", "3");
        CatapultZombie.put("cost", "80");
        CatapultZombie.put("speed", "2");
        CatapultZombie.put("bumper", "0");
        CatapultZombie.put("hasCAP", "false");
        CatapultZombie.put("isBaloon", "false");
        CatapultZombie.put("bumperLife", "0");
        CatapultZombie.put("isWater", "false");

        JSONObject BungeeZombie = new JSONObject();
        BungeeZombie.put("lifeNumber", "3");
        BungeeZombie.put("cost", "0");
        BungeeZombie.put("speed", "0");
        BungeeZombie.put("bumper", "0");
        BungeeZombie.put("hasCAP", "false");
        BungeeZombie.put("isBaloon", "false");
        BungeeZombie.put("bumperLife", "0");
        BungeeZombie.put("isWater", "false");

        JSONObject BalloonZombie = new JSONObject();
        BalloonZombie.put("lifeNumber", "3");
        BalloonZombie.put("cost", "80");
        BalloonZombie.put("speed", "2");
        BalloonZombie.put("bumper", "0");
        BalloonZombie.put("hasCAP", "false");
        BalloonZombie.put("isBaloon", "true");
        BalloonZombie.put("bumperLife", "0");
        BalloonZombie.put("isWater", "false");

        JSONObject NewspaperZombie = new JSONObject();
        NewspaperZombie.put("lifeNumber", "2");
        NewspaperZombie.put("cost", "60");
        NewspaperZombie.put("speed", "2");
        NewspaperZombie.put("bumper", "1");
        NewspaperZombie.put("hasCAP", "false");
        NewspaperZombie.put("isBaloon", "false");
        NewspaperZombie.put("bumperLife", "2");
        NewspaperZombie.put("isWater", "false");

        JSONObject TargetZombie = new JSONObject();
        TargetZombie.put("lifeNumber", "3");
        TargetZombie.put("cost", "80");
        TargetZombie.put("speed", "2");
        TargetZombie.put("bumper", "1");
        TargetZombie.put("hasCAP", "false");
        TargetZombie.put("isBaloon", "false");
        TargetZombie.put("bumperLife", "3");
        TargetZombie.put("isWater", "false");

        JSONObject ScreenDoorZombie = new JSONObject();
        ScreenDoorZombie.put("lifeNumber", "2");
        ScreenDoorZombie.put("cost", "60");
        ScreenDoorZombie.put("speed", "2");
        ScreenDoorZombie.put("bumper", "1");
        ScreenDoorZombie.put("hasCAP", "false");
        ScreenDoorZombie.put("isBaloon", "false");
        ScreenDoorZombie.put("bumperLife", "4");
        ScreenDoorZombie.put("isWater", "false");

        JSONObject GigaGargantuar = new JSONObject();
        GigaGargantuar.put("lifeNumber", "6");
        ScreenDoorZombie.put("cost", "70");
        GigaGargantuar.put("speed", "1");
        GigaGargantuar.put("bumper", "0");
        GigaGargantuar.put("hasCAP", "false");
        GigaGargantuar.put("isBaloon", "false");
        GigaGargantuar.put("bumperLife", "0");
        GigaGargantuar.put("isWater", "false");

        JSONObject pogoZombie = new JSONObject();
        pogoZombie.put("lifeNumber", "2");
        pogoZombie.put("cost", "60");
        pogoZombie.put("speed", "2");
        pogoZombie.put("bumper", "0");
        pogoZombie.put("hasCAP", "false");
        pogoZombie.put("isBaloon", "false");
        pogoZombie.put("bumperLife", "0");
        pogoZombie.put("isWater", "false");

        JSONObject SnorkelZombie = new JSONObject();
        SnorkelZombie.put("lifeNumber", "2");
        SnorkelZombie.put("cost", "60");
        SnorkelZombie.put("speed", "2");
        SnorkelZombie.put("bumper", "0");
        SnorkelZombie.put("hasCAP", "false");
        SnorkelZombie.put("isBaloon", "false");
        SnorkelZombie.put("bumperLife", "0");
        SnorkelZombie.put("isWater", "true");

        JSONObject DolphinRiderZombie = new JSONObject();
        DolphinRiderZombie.put("lifeNumber", "2");
        DolphinRiderZombie.put("cost", "60");
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
        Peashooter.put("plantingPrice", "9");
        Peashooter.put("sunOutTurn", "");
        Peashooter.put("bulletType", "");
        Peashooter.put("isMagnet", "false");
        Peashooter.put("isPricky", "false");
        Peashooter.put("coolDown", "2");

        JSONObject SnowPea = new JSONObject();
        SnowPea.put("health", "3");
        SnowPea.put("sun", "3");
        SnowPea.put("plantingPrice", "28");
        SnowPea.put("sunOutTurn", "");
        SnowPea.put("bulletType", "");
        SnowPea.put("isMagnet", "false");
        SnowPea.put("isPricky", "false");
        SnowPea.put("coolDown", "3");

        JSONObject CabbagePult = new JSONObject();
        CabbagePult.put("health", "2");
        CabbagePult.put("sun", "2");
        CabbagePult.put("plantingPrice", "13");
        CabbagePult.put("sunOutTurn", "");
        CabbagePult.put("bulletType", "");
        CabbagePult.put("isMagnet", "false");
        CabbagePult.put("isPricky", "false");
        CabbagePult.put("coolDown", "3");

        JSONObject Repeater = new JSONObject();
        Repeater.put("health", "4");
        Repeater.put("sun", "3");
        Repeater.put("plantingPrice", "49");
        Repeater.put("sunOutTurn", "");
        Repeater.put("bulletType", "");
        Repeater.put("isMagnet", "false");
        Repeater.put("isPricky", "false");
        Repeater.put("coolDown", "3");

        JSONObject Threepeater = new JSONObject();
        Threepeater.put("health", "5");
        Threepeater.put("sun", "4");
        Threepeater.put("plantingPrice", "81");
        Threepeater.put("sunOutTurn", "");
        Threepeater.put("bulletType", "");
        Threepeater.put("isMagnet", "false");
        Threepeater.put("isPricky", "false");
        Threepeater.put("coolDown", "4");

        JSONObject Cactus = new JSONObject();
        Cactus.put("health", "5");
        Cactus.put("sun", "5");
        Cactus.put("plantingPrice", "101");
        Cactus.put("sunOutTurn", "");
        Cactus.put("bulletType", "");
        Cactus.put("isMagnet", "false");
        Cactus.put("isPricky", "true");
        Cactus.put("coolDown", "4");

        JSONObject GatlingPea = new JSONObject();
        GatlingPea.put("health", "3");
        GatlingPea.put("sun", "5");
        GatlingPea.put("plantingPrice", "61");
        GatlingPea.put("sunOutTurn", "");
        GatlingPea.put("bulletType", "");
        GatlingPea.put("isMagnet", "false");
        GatlingPea.put("isPricky", "false");
        GatlingPea.put("coolDown", "4");

        JSONObject ScaredyShroom = new JSONObject();
        ScaredyShroom.put("health", "1");
        ScaredyShroom.put("sun", "1");
        ScaredyShroom.put("plantingPrice", "3");
        ScaredyShroom.put("sunOutTurn", "");
        ScaredyShroom.put("bulletType", "");
        ScaredyShroom.put("isMagnet", "false");
        ScaredyShroom.put("isPricky", "false");
        ScaredyShroom.put("coolDown", "2");

        JSONObject KernelPult = new JSONObject();
        KernelPult.put("health", "2");
        KernelPult.put("sun", "3");
        KernelPult.put("plantingPrice", "19");
        KernelPult.put("sunOutTurn", "");
        KernelPult.put("bulletType", "");
        KernelPult.put("isMagnet", "false");
        KernelPult.put("isPricky", "false");
        KernelPult.put("coolDown", "3");

        JSONObject SplitPea = new JSONObject();
        SplitPea.put("health", "3");
        SplitPea.put("sun", "4");
        SplitPea.put("plantingPrice", "49");
        SplitPea.put("sunOutTurn", "");
        SplitPea.put("bulletType", "");
        SplitPea.put("isMagnet", "false");
        SplitPea.put("isPricky", "false");
        SplitPea.put("coolDown", "4");

        JSONObject ExplodeOnut = new JSONObject();
        ExplodeOnut.put("health", "3");
        ExplodeOnut.put("sun", "4");
        ExplodeOnut.put("plantingPrice", "");
        ExplodeOnut.put("sunOutTurn", "");
        ExplodeOnut.put("bulletType", "");
        ExplodeOnut.put("isMagnet", "false");
        ExplodeOnut.put("isPricky", "false");
        ExplodeOnut.put("coolDown", "5");

        JSONObject MelonPult = new JSONObject();
        MelonPult.put("health", "3");
        MelonPult.put("sun", "3");
        MelonPult.put("plantingPrice", "28");
        MelonPult.put("sunOutTurn", "");
        MelonPult.put("bulletType", "");
        MelonPult.put("isMagnet", "false");
        MelonPult.put("isPricky", "false");
        MelonPult.put("coolDown", "3");

        JSONObject LilyPad = new JSONObject();
        LilyPad.put("health", "1");
        LilyPad.put("sun", "0");
        LilyPad.put("plantingPrice", "1");
        LilyPad.put("sunOutTurn", "");
        LilyPad.put("bulletType", "");
        LilyPad.put("isMagnet", "false");
        LilyPad.put("isPricky", "false");
        LilyPad.put("coolDown", "1");

        JSONObject WinterMelon = new JSONObject();
        WinterMelon.put("health", "3");
        WinterMelon.put("sun", "4");
        WinterMelon.put("plantingPrice", "61");
        WinterMelon.put("sunOutTurn", "");
        WinterMelon.put("bulletType", "");
        WinterMelon.put("isMagnet", "false");
        WinterMelon.put("isPricky", "false");
        WinterMelon.put("coolDown", "5");

        JSONObject WallNut = new JSONObject();
        WallNut.put("health", "4");
        WallNut.put("sun", "2");
        WallNut.put("plantingPrice", "33");
        WallNut.put("sunOutTurn", "");
        WallNut.put("bulletType", "");
        WallNut.put("isMagnet", "false");
        WallNut.put("isPricky", "false");
        WallNut.put("coolDown", "4");

        JSONObject TangleKelp = new JSONObject();
        TangleKelp.put("health", "0");
        TangleKelp.put("sun", "3");
        TangleKelp.put("plantingPrice", "1");
        TangleKelp.put("sunOutTurn", "");
        TangleKelp.put("bulletType", "");
        TangleKelp.put("isMagnet", "false");
        TangleKelp.put("isPricky", "false");
        TangleKelp.put("coolDown", "3");

        JSONObject TallNut = new JSONObject();
        TallNut.put("health", "6");
        TallNut.put("sun", "4");
        TallNut.put("plantingPrice", "145");
        TallNut.put("sunOutTurn", "");
        TallNut.put("bulletType", "");
        TallNut.put("isMagnet", "false");
        TallNut.put("isPricky", "false");
        TallNut.put("coolDown", "6");

        JSONObject Cattail = new JSONObject();
        Cattail.put("health", "3");
        Cattail.put("sun", "5");
        Cattail.put("plantingPrice", "76");
        Cattail.put("sunOutTurn", "");
        Cattail.put("bulletType", "");
        Cattail.put("isMagnet", "false");
        Cattail.put("isPricky", "false");
        Cattail.put("coolDown", "5");

        JSONObject PotatoMine = new JSONObject();
        PotatoMine.put("health", "1");
        PotatoMine.put("sun", "3");
        PotatoMine.put("plantingPrice", "7");
        PotatoMine.put("sunOutTurn", "");
        PotatoMine.put("bulletType", "");
        PotatoMine.put("isMagnet", "false");
        PotatoMine.put("isPricky", "false");
        PotatoMine.put("coolDown", "2");

        JSONObject cherryBomb = new JSONObject();
        cherryBomb.put("health", "0");
        cherryBomb.put("sun", "2");
        cherryBomb.put("plantingPrice", "1");
        cherryBomb.put("sunOutTurn", "");
        cherryBomb.put("bulletType", "");
        cherryBomb.put("isMagnet", "false");
        cherryBomb.put("isPricky", "false");
        cherryBomb.put("coolDown", "4");

        JSONObject MagnetShroom = new JSONObject();
        MagnetShroom.put("health", "2");
        MagnetShroom.put("sun", "4");
        MagnetShroom.put("plantingPrice", "33");
        MagnetShroom.put("sunOutTurn", "");
        MagnetShroom.put("bulletType", "");
        MagnetShroom.put("isMagnet", "true");
        MagnetShroom.put("isPricky", "false");
        MagnetShroom.put("coolDown", "4");

        JSONObject Sunflower = new JSONObject();
        Sunflower.put("health", "2");
        Sunflower.put("sun", "1");
        Sunflower.put("plantingPrice", "5");
        Sunflower.put("sunOutTurn", "");
        Sunflower.put("bulletType", "");
        Sunflower.put("isMagnet", "false");
        Sunflower.put("isPricky", "false");
        Sunflower.put("coolDown", "2");

        JSONObject TwinSunflower = new JSONObject();
        TwinSunflower.put("health", "2");
        TwinSunflower.put("sun", "3");
        TwinSunflower.put("plantingPrice", "31");
        TwinSunflower.put("sunOutTurn", "");
        TwinSunflower.put("bulletType", "");
        TwinSunflower.put("isMagnet", "false");
        TwinSunflower.put("isPricky", "false");
        TwinSunflower.put("coolDown", "5");

        JSONObject Jalapeno = new JSONObject();
        Jalapeno.put("health", "-");
        Jalapeno.put("sun", "4");
        Jalapeno.put("plantingPrice", "1");
        Jalapeno.put("sunOutTurn", "");
        Jalapeno.put("bulletType", "");
        Jalapeno.put("isMagnet", "false");
        Jalapeno.put("isPricky", "false");
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