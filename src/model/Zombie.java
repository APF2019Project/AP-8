package model;

public class Zombie {
    private Plant plant;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int coolDown;
    private int lifeNumber;
    Cell cell;

    public void putZombei() {
        System.out.println("putZombeiStart");
       cell = new Cell(0, 0);
        this.x = cell.getX();
        this.y = cell.getY();
        System.out.println("putZombeiFinished");
    }

    public void move(int dx, int dy) {
        System.out.println("moveStart");
        this.x = dx + x;
        this.y = dy + y;
        cell = new Cell(x , y);
        System.out.println("moveFinished");
    }

}
