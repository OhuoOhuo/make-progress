package arithmetic.zuo.class10;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 在统一的结构上
 * 从node出发，进行宽度优先遍历
 * 类似于二叉树的层序遍历，但是需要额外的set记录是否已经打印过
 */
public class Code02_BFS {

    public static void bfs(Node node) {

        if (node == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (queue != null) {
            Node poll = queue.poll();
            System.out.println(poll.value);
            for (Node next : poll.nexts) {
                if (set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }
}
