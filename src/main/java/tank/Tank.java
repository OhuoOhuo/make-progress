package tank;

import java.awt.*;

/**
 * @author ：hyf
 * @date ：Created in 2020/7/23 20:42
 * @description：
 * @modified By：
 * @version: $
 */
public class Tank {
    private int x, y;
    private Dir dir;
    private static final int speed = 10;
    private boolean moving = false;

    public static final int WIDTH = ResourceMgr.goodTankD.getWidth(),
            HEIGHT = ResourceMgr.goodTankD.getHeight();

    private TankFrame tf;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.goodTankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.goodTankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.goodTankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.goodTankD,x,y,null);
                break;
        }
        move();
    }

    private void move() {
        if (!moving) return;
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
    }

    public void fire() {
        int bx=this.x + Tank.WIDTH/2 -Bullet.WIDTH/2;
        int by =this.y+Tank.HEIGHT/2 -Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bx, by, this.dir));
    }
}
