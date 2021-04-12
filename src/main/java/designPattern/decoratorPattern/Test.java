package designPattern.decoratorPattern;

/**
 * @author ：cwf
 * @description：测试主类
 */
public class Test {

    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getDesc()  + " 花费 "+battercake.cost());

        EggDecorator eggDecorator = new EggDecorator(battercake);
        System.out.println(eggDecorator.getDesc() + " 花费 "+eggDecorator.cost());

        SausageDecorator sausageDecorator = new SausageDecorator(eggDecorator);
        System.out.println(sausageDecorator.getDesc() + " 花费 " +sausageDecorator.cost());

        Bread bread = new Bread();
        System.out.println(bread.getDesc() +" 花费 " +bread.cost());
        SausageDecorator sausageDecorator1 = new SausageDecorator(bread);
        System.out.println(sausageDecorator1.getDesc() + " 花费 "+sausageDecorator1.cost());
        SausageDecorator sausageDecorator2 = new SausageDecorator(sausageDecorator1);
        System.out.println(sausageDecorator2.getDesc() + " 花费 "+sausageDecorator2.cost());
    }
}
