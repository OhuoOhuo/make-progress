package network.IO.testreactor;

/**
 * @author ：hyf
 * @date ：Created in 2021/4/12 10:25
 * @description：主类
 * @modified By：
 * @version: $
 */
public class MainThread {

    public static void main(String[] args) {
        SelectorThreadGroup selectorThreadGroup = new SelectorThreadGroup(3);

        selectorThreadGroup.bind(9999);
    }
}
