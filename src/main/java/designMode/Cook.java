package designMode;

public abstract class Cook {
    //抽象方法  放油
    public abstract void oil();
    //抽象方法  放鸡蛋
    public abstract void egg();
    //抽象方法  放西红柿
    public abstract void tomato();
    //具体方法   子类不实现
    private void fire(){
        System.out.println("开火开火！！！！");
    }
    //钩子方法
    public boolean isOil(){
        return true;
    }

    //模板方法
    public final void cook(){
        fire();
        if(isOil()){
            oil();
        }
        egg();
        tomato();
    }

}
