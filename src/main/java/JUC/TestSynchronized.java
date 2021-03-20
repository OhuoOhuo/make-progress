package JUC;




public class TestSynchronized{

    static   long count =10L;

    public /*synchronized*/ void m() {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public  void mm() {
        synchronized(this) { //考虑一下这里写synchronized(this)是否可以？
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public static void main(String[] args){
        TestSynchronized testSynchronized = new TestSynchronized();


        for (int i = 0; i < 10; i++) {
            new Thread(testSynchronized::m).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(testSynchronized::mm).start();
        }

    }



}
