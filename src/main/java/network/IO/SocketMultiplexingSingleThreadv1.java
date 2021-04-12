package network.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * @author ：hyf
 * @date ：Created in 2021/4/8 13:47
 * @description：nio最原始版本
 * @modified By：
 * @version: $
 */
public class SocketMultiplexingSingleThreadv1 {

    private ServerSocketChannel server =null;
    private Selector selector =null;
    int port =9090;

    public void initServer() throws IOException {
        server = ServerSocketChannel.open();

        server.configureBlocking(false);
        server.bind(new InetSocketAddress(port));

        selector = Selector.open();
        server.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void start() throws IOException {
        initServer();
        System.out.println("服务器启动了。。。。。。");

        while (true){
            Set<SelectionKey> keys = selector.keys();
            System.out.println(keys.size() + "  size");

            while (selector.select() > 0){

            }


        }
    }
}
