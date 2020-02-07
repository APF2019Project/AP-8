package requests;

public class CollectionRequest extends BaseRequest {
    String plantOrZombie;
    String name;
    int cost;
    int lifenum;
    int speed;
    boolean bumper;
    boolean iswzater;
    boolean hasCap;
    int bumperNum;
    int health;
    int sun;
    boolean isMagnate;
    boolean ispricky;
    int coolDown;

    public CollectionRequest(String name, int cost, int lifenum, int speed, boolean bumper, boolean iswzater, boolean hasCap, int bumperNum, RequestType requestType) {
        super(requestType, AccountRequest.class.getName());
        this.name = name;
        this.cost = cost;
        this.lifenum = lifenum;
        this.speed = speed;
        this.bumper = bumper;
        this.iswzater = iswzater;
        this.hasCap = hasCap;
        this.bumperNum = bumperNum;
    }

    public CollectionRequest(String name, int cost, int health, int sun, boolean isMagnate, boolean ispricky, int coolDown, RequestType requestType) {
        super(requestType, AccountRequest.class.getName());
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.sun = sun;
        this.isMagnate = isMagnate;
        this.ispricky = ispricky;
        this.coolDown = coolDown;
    }

    public String getPlantOrZombie() {
        return plantOrZombie;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getLifenum() {
        return lifenum;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isBumper() {
        return bumper;
    }

    public boolean isIswzater() {
        return iswzater;
    }

    public boolean isHasCap() {
        return hasCap;
    }

    public int getBumperNum() {
        return bumperNum;
    }

    public int getHealth() {
        return health;
    }

    public int getSun() {
        return sun;
    }

    public boolean isMagnate() {
        return isMagnate;
    }

    public boolean isIspricky() {
        return ispricky;
    }

    public int getCoolDown() {
        return coolDown;
    }

}
