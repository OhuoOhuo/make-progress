package tank;

import java.awt.*;

public class Bullet {
    private static final int speed = 5;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth(),
            HEIGHT = ResourceMgr.bulletD.getHeight();
    private int x, y;
    private Dir dir;

    private boolean live = true;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
        }

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) live = false;
    }

}
