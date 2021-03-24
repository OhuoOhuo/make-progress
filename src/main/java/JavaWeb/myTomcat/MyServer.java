package JavaWeb.myTomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：hyf
 * @date ：Created in 2021/3/24 13:59
 * @description：主类启动
 * @modified By：
 * @version: $
 */
public class MyServer {


    public static void main(String[] args){
        try {
            startServer(10086);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startServer(int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);

        Socket socket =null;

        while (true){
            socket =serverSocket.accept();

            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            MyRequest myRequest = new MyRequest(inputStream);
            MyResponse myResponse = new MyResponse(outputStream);

            String calzz = new MyMapping().getMapping().get(myRequest.getRequestUrl());

            if(calzz !=null){
                Class<MyServlet> myServletClass= (Class<MyServlet>)Class.forName(calzz);
                MyServlet myServlet = myServletClass.newInstance();
                myServlet.service(myRequest,myResponse);
            }
        }
    }

}
