package arithmetic.zuo.class10;

import java.util.*;

/**
 * 拓扑排序
 * 需要把所有没有依赖的节点先执行完，同时没有依赖则顺序无所谓
 * <p>
 * 必须是有向无环图
 *
 * 核心思路：先拍入度为0的点，排完后更新入度值，再继续
 */
public class Code03_TopologySort {

    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();//记录每个节点的入度
        Queue<Node> zeroInQueue = new LinkedList<>();//只入度为0的节点才能加入

        for (Node node : graph.nodes.values()) {//遍历所有节点
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        ArrayList<Node> nodes = new ArrayList<>();

        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            nodes.add(cur);
            //把该节点所有的next节点的入度减一，其中如果有入度为0的产生加入队列
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return nodes;
    }
}
