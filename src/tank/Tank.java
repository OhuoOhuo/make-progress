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
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
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
        tf.bullets.add(new Bullet(this.x, this.y, this.dir));
    }
}
