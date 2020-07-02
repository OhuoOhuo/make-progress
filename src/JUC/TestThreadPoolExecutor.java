package JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：hyf
 * @date ：Created in 2020/6/30 19:03
 * @description：
 * @modified By：
 * @version: $
 */
public class TestThreadPoolExecutor {

    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 5,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        tpe.submit(()-> System.out.println("哈哈哈哈"));
    }
}
