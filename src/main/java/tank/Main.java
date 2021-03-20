package tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author ：hyf
 * @date ：Created in 2020/7/22 19:29
 * @description：
 * @modified By：
 * @version: $
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
