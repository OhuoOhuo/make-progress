package JUC;

import com.sun.codemodel.internal.JForEach;
import com.sun.codemodel.internal.JForLoop;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：cwf
 * @date ：Created in 2020/6/30 16:40
 * @description：
 * @modified By：
 * @version: $
 */
public class TestCyclicBarrier {


    public static void main(String[] args) {

        // CountDownLatch countDownLatch = new CountDownLatch(3);

        //ReentrantLock reentrantLock = new ReentrantLock();

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());

        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            System.out.println("5个线程执行完毕");
            LockSupport.unpark(thread);
        });


        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 5,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 1; i < 17; i++) {
            //校验是否
            tpe.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            if (i % 5 == 0) {
                LockSupport.park();
            }

        }


        System.out.println("执行完成");

    }
}
