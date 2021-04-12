package designPattern.decoratorPattern;

/**
 * @author ：cwf
 * @description：香肠装饰类
 */
public class SausageDecorator extends AbstractDecorator {
    public SausageDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    public void doSomeThing(){

    }

    @Override
    public String getDesc(){
        return super.getDesc()+"加一个香肠";
    }

    @Override
    public int cost(){
        return super.cost() +5;
    }
}
