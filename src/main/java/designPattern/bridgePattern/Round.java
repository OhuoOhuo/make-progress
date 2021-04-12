package designPattern.bridgePattern;

/**
 * @author ：cwf
 * @description：形状的实现类
 */
public class Round implements IShape {

    IColor iColor;

    public void setiColor(IColor color){
        iColor = color;
    }

    @Override
    public void draw() {
        System.out.println("绘制 " + iColor.getColor() +" 圆形");
    }
}
