package JUC;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TestAtomic {
//
//    static   long count =1000L;
//
//    public /*synchronized*/ void m() {
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        count--;
//        System.out.println(Thread.currentThread().getName() + " count = " + count);
//    }

    static AtomicLong count = new AtomicLong(1000);

    public  void m() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.decrementAndGet();
        System.out.println(count);

    }

    public static void main(String[] args){
        TestAtomic t = new TestAtomic();


        for (int i = 0; i < 1000; i++) {
            new Thread(t::m).start();
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);


    }
}
