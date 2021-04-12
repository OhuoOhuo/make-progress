package network.IO.testreactor;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ：hyf
 * @date ：Created in 2021/4/12 10:26
 * @description：选择器类
 * @modified By：
 * @version: $
 */
public class SelectorThread extends ThreadLocal<LinkedBlockingDeque<Channel>> implements Runnable {

    Selector selector = null;

    //LinkedBlockingDeque<Channel> lbq = get();
    LinkedBlockingDeque<Channel> lbq = new LinkedBlockingDeque<>();

    SelectorThreadGroup stg;

    public SelectorThread(SelectorThreadGroup stg) {

        try {
            this.stg = stg;
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {

        //loop
        while (true){

            try {
                int nums = selector.select();


                if(nums >0){
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();

                    //线程处理
                    while (iterator.hasNext()){

                        SelectionKey key = iterator.next();
                        iterator.remove();

                        if(key.isAcceptable()){
                            acceptHandler(key);
                        }else if(key.isReadable()){
                            readHander(key);
                        }else if(key.isWritable()){

                        }
                    }//5
                }



                if(!lbq.isEmpty()){
                    Channel c = lbq.take();
                    if(c instanceof ServerSocketChannel){
                        ServerSocketChannel server = (ServerSocketChannel) c;
                        server.register(selector,SelectionKey.OP_ACCEPT);
                        System.out.println(Thread.currentThread().getName() + " register listen");
                    }else if(c instanceof  SocketChannel){
                        SocketChannel client = (SocketChannel) c;
                        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4096);
                        client.register(selector,SelectionKey.OP_READ,byteBuffer);
                        System.out.println(Thread.currentThread().getName() + " register client" +client.getRemoteAddress());
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

    private void acceptHandler(SelectionKey key) {
        System.out.println(Thread.currentThread().getName() + " acceptHandler.....");

        ServerSocketChannel server = (ServerSocketChannel) key.channel();

        try {
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            //choose a selector and register!!
            stg.nextSelector(server);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readHander(SelectionKey key) {
        System.out.println(Thread.currentThread().getName() + " read......");
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        SocketChannel client = (SocketChannel) key.channel();
        buffer.clear();

        while (true){

            try {
                int num = client.read(buffer);

                if(num > 0){
                    buffer.flip();
                    while (buffer.hasRemaining()){
                        client.write(buffer);
                    }
                    buffer.clear();
                }else if(num ==0){
                    break;
                }else if(num <0){
                    System.out.println("client:" + client.getRemoteAddress() + "closed....");
                    key.cancel();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
