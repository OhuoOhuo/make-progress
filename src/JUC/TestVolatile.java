package JUC;

public class TestVolatile {
    static /*volatile*/ boolean flag = true;


    void m(){
        System.out.println("m start");

        while (flag){

        }

        System.out.println("m end");
    }

    public static void main(String[] agrs){
        TestVolatile testVolatile = new TestVolatile();

        new Thread(testVolatile::m).start();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = false;

    }

}
