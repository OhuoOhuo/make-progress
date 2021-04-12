package network.IO;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：cwf
 * @description：BIO最简单例子
 */
public class SocketIO {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9090, 20);

        System.out.println("ServerSocket 建立 9090");

        while (true) {
            System.in.read();//可以测试先建立连接，再绑定对应进程
            //线程阻塞，直到有连接，继续往下走，BIO
            //服务端的套接字，通过accept 可以获得一个
            Socket client = socket.accept();
            System.out.println("step2:client\t" + client.getPort());

            //新拉起一个线程来处理后续的工作，这与IO没关系了
            //该线程只处理一个socket的读写内容
            new Thread(() -> {

                try {
                    InputStream inputStream = client.getInputStream();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        String s = bufferedReader.readLine();//阻塞
                        if (null == s) {
                            client.close();
                            break;
                        } else {
                            System.out.println(s);
                        }
                    }
                    System.out.println("客户端断开");
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }).start();

        }
    }
}
