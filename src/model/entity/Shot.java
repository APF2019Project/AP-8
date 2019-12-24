package model.entity;


public class Shot extends Card {
    // this shit is nokhods and shits to fucking zombies
    private int damage;
    private int speed;
    private int lifeTime; // bishtar glule ha bad az barkhurd be zambie az bein mirn ama bazi glule ha mesle gerdu felfeli mimunn ta vaqti giah zende has be zombi asib miznn
    private Cell position; // inja khuneii ke alan glule tushe ro darim;
    private boolean isProjectile ; // age projectile bashe mitune be zobie haye separ dar ham sadame bezane
    private int decreaseZombieSpeed ;
    private int turnsDecreaseZombieSpeed;
    private BulletType bulletType;
    private boolean direction = true;
    private Map map;
    public void setPosition(Cell position) {
        this.position=position;
        position.putCard(this);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public Cell getPosition() {
        return position;
    }

    public boolean isProjectile() {
        return isProjectile;
    }

    public void setProjectile(boolean projectile) {
        isProjectile = projectile;
    }

    public int getDecreaseZombieSpeed() {
        return decreaseZombieSpeed;
    }

    public void setDecreaseZombieSpeed(int decreaseZombieSpeed) {
        this.decreaseZombieSpeed = decreaseZombieSpeed;
    }

    public int getTurnsDecreaseZombieSpeed() {
        return turnsDecreaseZombieSpeed;
    }

    public void setTurnsDecreaseZombieSpeed(int turnsDecreaseZombieSpeed) {
        this.turnsDecreaseZombieSpeed = turnsDecreaseZombieSpeed;
    }

    public BulletType getBulletType() {
        return bulletType;
    }

    public void setBulletType(BulletType bulletType) {
        this.bulletType = bulletType;
    }

    public Shot(String name, int damage, int speed, int lifeTime, Cell position, boolean isProjectile, BulletType bulletType, int decreaseZombieSpeed , int turnsDecreaseZombieSpeed) {
        super(name, CardType.SHOT);
        this.damage = damage;
        this.speed = speed;
        this.lifeTime = lifeTime;
        this.setPosition(position);
        this.bulletType = bulletType;
        this.decreaseZombieSpeed = decreaseZombieSpeed;
        this.turnsDecreaseZombieSpeed= turnsDecreaseZombieSpeed;
    }
// this shit is for shot a bullet from plantse  , every shot will know how  to treat with every zombie;
    public static Shot getShot(BulletType bulletType , Cell cell){
        System.out.println("start get shot method");
        if(bulletType==BulletType.PEA){
            return new Shot("pea", 1, 3 ,1, cell , false, bulletType , -1 , -1);
        }else if(bulletType == BulletType.MAIZE){
            return new Shot("maize" ,  0 , 3  , 1, cell , true, bulletType ,  0 , 2 );
        }else if(bulletType == BulletType.EXPLODE_O_NOT){
            return new Shot("explode-o-not" , 1 , 0 , Integer.MAX_VALUE,  cell , true,bulletType , -1 , -1);
        }else if(bulletType == BulletType.LETTUCE){
            return new Shot( "lettuce", 2 ,3 , 1 , cell , true , bulletType , -1 , -1 );
        }else if(bulletType == BulletType.SNOW_PEA){
            return new Shot("snow_pea" , 1 , 3 , 1 , cell , false , bulletType , 2 , 1); // 1 nobat sorat zobie ra sefr mikonad
        }else if(bulletType == BulletType.WATERMELON){
            return new Shot("watermellon" ,3 , 3 , 1 , cell , true , bulletType , -1 , -1); //tasiri ru sorat zombie nadarad
        }else if(bulletType == BulletType.WINTER_MELLON){
            return new Shot("winter_watermellon" , 3 , 3 , 1, cell ,  true , bulletType , 2 , -2 );//hamvare sorat zombie ra sefr mikonad
        }
        return null;
    }
    public void moveOneCell(){
        if(direction){
            this.setPosition(map.getRight(this.position));
        }else {
            this.setPosition(map.getLeft(this.position));
        }
        this.fuckZombie();
    }
    public void move(){
        for (int i = 0 ; i<speed ; i++){
            this.moveOneCell();
        }
    }
    public void fuckZombie(){
        //this method will fuck zombies:))
        System.out.println("start fuckzomie method");
        for (Card card: this.position.cards) {
            if(card instanceof Zombie){
               while (true){
 //                  damageZombie((Zombie)card);
                   this.lifeTime-=1;
                   if(lifeTime<=0){
                       break;
                   }
               }
            }
        }
        System.out.println("finish fuckzombie method");
    }
    // in gesmat bayad fekr shavad baad handle shavad
 //   private void damageZombie(Zombie zombie){
 //
 //       if (zombie.getBumper()==0){
 //           zombie.setLifeNumber(this);
 //       }
 //   }
}
