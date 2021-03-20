package arithmetic.zuo.class10;

import java.util.HashSet;
import java.util.Stack;

/**
 * 深度优先遍历
 * 需要如果是没走过路，需要再次放入，已进行路径记录 （stack 中记录的就是当前路径，set可以判断新的选择时路径是否走过）
 *
 */
public class Code02_DFS {
    public static void dfs(Node node) {
        if(node ==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> readySet = new HashSet<>();
        stack.add(node);
        System.out.println(node.value);
        readySet.add(node);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            for (Node next: pop.nexts) {
                if(readySet.contains(next)){
                   continue;
                }
                stack.add(pop);
                stack.add(next);
                System.out.println(next.value);
                readySet.add(next);
                break;
            }
        }


    }
}
