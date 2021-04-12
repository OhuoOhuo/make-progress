package network.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ：cwf
 * @description：socketClient
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        //使用端的套接字
        Socket client = new Socket("192.168.1,113", 9090);

        OutputStream outputStream = client.getOutputStream();


        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        while (true){
            String line = reader.readLine();

            while (line !=null){
                byte[] bytes = line.getBytes();
                for (byte b: bytes) {
                    outputStream.write(b);
                }
            }
        }
    }
}
