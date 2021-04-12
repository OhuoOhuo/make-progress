package designPattern.bridgePattern;

/**
 * @author ：cwf
 * @description：测试主类
 */
public class Test {
    public static void main(String[] args) {
        Round round = new Round();
        round.setiColor(new Red());
        round.draw();

        Rectangle rectangle = new Rectangle();
        rectangle.setColor(new Blue());
        rectangle.draw();


    }
}
