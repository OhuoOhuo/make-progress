package JavaWeb.myTomcat;

import java.util.HashMap;

/**
 * @author ：cwf
 * @description：路径映射到实现类，真正的是读xml配置
 */
public class MyMapping {

    public static HashMap<String,String> mapping = new HashMap<String,String>();

    static {
        mapping.put("/mytomcat","JavaWeb.myTomcat.MyServlet");
    }

    public HashMap<String,String> getMapping(){
        return mapping;
    }
}
