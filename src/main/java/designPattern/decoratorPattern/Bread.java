package designPattern.decoratorPattern;

/**
 * @author ：cwf
 * @description：面包实体类
 */
public class Bread extends ABattercake {
    @Override
    protected String getDesc() {
        return "这是一个白面包 ";
    }

    @Override
    protected int cost() {
        return 5;
    }
}
