package arithmetic.zuo.class10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 有向图，图的边的权重为正，求一个点到其它所有点的最短距离，（不能到达为正无穷）
 */
public class Code06_Dijkstra {

    public static HashMap<Node, Integer> dijkstra1(Node from) {
        // 从head出发到所有点的最小距离
        // key : 从head出发到达key
        // value : 从head出发到达key的最小距离
        // 如果在表中，没有T的记录，含义是从head出发到T这个点的距离为正无穷
        HashMap<Node, Integer> result = new HashMap<>();
        // 已经求过距离的节点，存在selectedNodes中，以后再也不碰
        HashSet<Node> readySet = new HashSet<Node>();
        result.put(from, 0);
        Node minNode = getMinNode(result, readySet);
        readySet.add(from);
        while (minNode != null) {
            List<Edge> edges = minNode.edges;
            for (Edge edge : edges) {
                if (readySet.contains(edge.to)) {
                    result.put(edge.to, Math.min(result.get(edge.to), result.get(minNode) + edge.weight));
                } else {
                    result.put(edge.to, result.get(minNode) + edge.weight);
                }
            }
            readySet.add(minNode);
            minNode = getMinNode(result, readySet);
        }
        return result;
    }

    private static Node getMinNode(HashMap<Node, Integer> result, HashSet<Node> readySet) {
        Node minNode = null;
        Integer minInt = Integer.MAX_VALUE;
        for (Node node : result.keySet()) {
            if (!readySet.contains(node) && result.get(node) < minInt) {
                minNode = node;
                minInt = result.get(node);
            }
        }
        return minNode;
    }


}
