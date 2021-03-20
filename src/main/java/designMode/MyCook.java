package designMode;

public class MyCook extends Cook {
    @Override
    public void oil() {
        System.out.println("自己，方十斤油");
    }

    @Override
    public void egg() {
        System.out.println("自己，放十斤鸡蛋");

    }

    @Override
    public boolean isOil(){
        return false;
    }

    @Override
    public void tomato() {
        System.out.println("自己，放十斤西红柿");
    }
}
