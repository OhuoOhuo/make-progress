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
    private int x,y;
    private Dir dir;
    private static final int speed =10;

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
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
}
