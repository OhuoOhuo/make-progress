package JUC.AQS;

public class ChefCook extends Cook {
    @Override
    public void oil() {
        System.out.println("大厨，放适量油");
    }

    @Override
    public void egg() {
        System.out.println("大厨，放适量鸡蛋");
    }

    @Override
    public void tomato() {
        System.out.println("大厨，放适量西红柿");
    }




    public static void main(String[] args) {
        MyCook myCook = new MyCook();
        myCook.cook();

        ChefCook chefCook = new ChefCook();
        chefCook.cook();
    }
}
