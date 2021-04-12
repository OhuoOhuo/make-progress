package designPattern.decoratorPattern;

/**
 * @author ：cwf
 * @description：抽象饰品类
 */
public abstract class AbstractDecorator extends ABattercake {

    private ABattercake aBattercake;

    public AbstractDecorator (ABattercake aBattercake){
        this.aBattercake = aBattercake;
    }

    protected void doSomeThing(){

    }

    @Override
    protected String getDesc(){
        return this.aBattercake.getDesc();
    }

    @Override
    protected int cost(){
        return this.aBattercake.cost();
    }
}
