package model;

import java.math.BigInteger;
import java.util.ArrayList;

public class Shot extends Card {
    // this shit is nokhods and shits to fucking zombies
    private int damage;
    private int speed;
    private int lifeTime; // bishtar glule ha bad az barkhurd be zambie az bein mirn ama bazi glule ha mesle gerdu felfeli mimunn ta vaqti giah zende has be zombi asib miznn
    private Cell position; // inja khuneii ke alan glule tushe ro darim;
    private BulletType bulletType;
    public void setPosition(Cell position) {
        this.position = position;
    }

    public Shot(String name, CardType cardType, Coin shopingPrice,  int damage, int speed, int lifeTime, Cell position, BulletType bulletType) {
        super(name, cardType, shopingPrice);
        this.damage = damage;
        this.speed = speed;
        this.lifeTime = lifeTime;
        this.position = position;
        this.bulletType = bulletType;
    }

    public static Shot getShot(BulletType bulletType , Cell cell){
        if(bulletType==BulletType.PEA){
            Shot newShot= new Shot("pea", CardType.SHOT , 0, 1 , 3 , 1 , cell, bulletType);
        }
    }

}
