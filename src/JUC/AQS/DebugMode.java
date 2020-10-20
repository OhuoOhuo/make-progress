package JUC.AQS;

import java.util.concurrent.locks.ReentrantLock;

public class DebugMode {


    public static void main(String[] args) {

        System.out.println("开始了");

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println("第二次取获得锁");

        lock.lock();


        lock.unlock();

    }
}
