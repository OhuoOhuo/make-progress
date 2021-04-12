package network.IO.testreactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：hyf
 * @date ：Created in 2021/4/12 10:30
 * @description：selector分组类
 * @modified By：
 * @version: $
 */
public class SelectorThreadGroup {

    SelectorThread[] sts;
    ServerSocketChannel server =null;
    AtomicInteger xid = new AtomicInteger(0);

    /**
     * 构造时候决定该组中有多少选择器
     * @param num
     */
    public SelectorThreadGroup(int num){
        sts = new SelectorThread[num];
        for (int i = 0; i < num ; i++) {
            sts[i] = new SelectorThread(this);
            new Thread(sts[i]).start();
        }
    }

    public void bind(int port){

        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));
            //注册到哪个selector上？
            nextSelector(server);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nextSelector(Channel server) {
       SelectorThread st = next();
       st.lbq.add(server);
       st.selector.wakeup();
    }

    private SelectorThread next() {
        int index = xid.incrementAndGet() % sts.length;
        return sts[index];
    }


}
