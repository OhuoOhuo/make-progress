package designPattern.bridgePattern;

/**
 * @author ：hyf
 * @date ：Created in 2021/4/1 15:45
 * @description：形状的实现类
 * @modified By：
 * @version: $
 */
public class Triangle implements IShape {
    IColor color;

    public void setColor(IColor color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("绘制 " + color.getColor() + " 三角形");
    }
}
