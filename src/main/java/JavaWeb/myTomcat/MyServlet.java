package JavaWeb.myTomcat;

/**
 * @author ：hyf
 * @description：一个具体实现类 真正tomcat中 有多个servlet 类
 */
public class MyServlet extends MyHttpServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        response.write("get success");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.write("post success");
    }
}
