package designPattern.decoratorPattern;

/**
 * @author ：cwf
 * @description：鸡蛋装饰器
 */
public class EggDecorator extends AbstractDecorator {

    public EggDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }


    @Override
    protected void doSomeThing(){

    }

    @Override
    public String getDesc(){
        return super.getDesc()+"加一个蛋";
    }

    @Override
    public int cost(){
        return super.cost()+2;
    }
}
