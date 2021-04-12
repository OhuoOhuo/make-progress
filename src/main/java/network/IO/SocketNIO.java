package network.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * @author ：cwf
 * @description：最基本案例
 */
public class SocketNIO {

    public static void main(String[] args) throws IOException, InterruptedException {
        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(9090));
        serverSocket.configureBlocking(false); //accept 非阻塞

        while (true){

            Thread.sleep(1000);
            SocketChannel client = serverSocket.accept();

            if(client ==null){

            }else {
                client.configureBlocking(false);//读取非阻塞
                clients.add(client);
            }

            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4096);
            for (SocketChannel chanel: clients) {
                int readNum = chanel.read(byteBuffer);
                if(readNum>0){
                    byteBuffer.flip();
                    byte[] aaa= new byte[byteBuffer.limit()];
                    byteBuffer.get(aaa);

                    String s = new String(aaa);
                    System.out.println(chanel.socket().getPort() + " : "+s);
                    byteBuffer.clear();
                }

            }



        }
    }
}
