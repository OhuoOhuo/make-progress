package tank;

import java.awt.*;

public class Bullet {
    private static final int speed = 5;
    private static final int WIDTH = 30, HEIGHT = 30;
    private int x, y;
    private Dir dir;

    private boolean live = true;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
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
