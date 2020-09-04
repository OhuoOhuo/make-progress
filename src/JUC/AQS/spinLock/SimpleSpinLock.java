package JUC.AQS.spinLock;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleSpinLock {

    /**
     * 维护当前拥有锁的线程对象
     */
    private AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock(){
        Thread currentThread = Thread.currentThread();
        // 只有owner没有被加锁的时候，才能够加锁成功，否则自旋等待
        boolean b = owner.compareAndSet(null, currentThread);

        while (!b){

        }
    }

    public void unlock(){
        Thread currentThread = Thread.currentThread();
        // 只有锁的owner才能够释放锁，其它的线程因为无法满足Compare，因此不会Set成功
        owner.compareAndSet(currentThread,null);
    }



    public static void main(String[] args) {

        // SimpleSpinLock simpleSpinLock = new SimpleSpinLock();

        ReentrantLock simpleSpinLock = new ReentrantLock();

        new Thread(() ->{
            simpleSpinLock.lock();
            System.out.println(Thread.currentThread().getName()+"获得锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //simpleSpinLock.unlock();
            System.out.println(Thread.currentThread().getName()+"放开锁");
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() ->{
            simpleSpinLock.lock();
            System.out.println(Thread.currentThread().getName()+"获得锁");
        }).start();
    }

}
