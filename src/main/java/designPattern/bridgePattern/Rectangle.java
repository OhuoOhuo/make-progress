package designPattern.bridgePattern;

/**
 * @author ：cwf
 * @description：形状的实现类
 */
public class Rectangle implements IShape {

    IColor iColor;

    void setColor(IColor color){
        iColor =color;
    }

    @Override
    public void draw() {
        System.out.println("绘制 "+iColor.getColor()+" 矩形 ");
    }
}
