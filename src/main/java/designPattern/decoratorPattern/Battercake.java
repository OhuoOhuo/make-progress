package designPattern.decoratorPattern;

/**
 * @author ：cwf
 * @description：煎饼实体类
 */
public class Battercake extends ABattercake {
    @Override
    protected String getDesc() {
        return "简单煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
