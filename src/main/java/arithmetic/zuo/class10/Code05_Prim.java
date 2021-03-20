package arithmetic.zuo.class10;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Code05_Prim {

    public static Set<Edge> primMST(Graph graph) {

        HashSet<Edge> result = new HashSet<>();

        PriorityQueue<Edge> edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });//已经解锁的边

        HashSet<Node> nodes = new HashSet<>();//已经解锁的点

        for (Node node : graph.nodes.values()) {//随便确定一个点

            nodes.add(node);

            for (Edge edge : node.edges) {//改点解锁的边加入小根堆
                edges.add(edge);
            }
            while (!edges.isEmpty()) {
                Edge poll = edges.poll();//获取当前最小的边

                Node toNode = poll.to;//只有to可能为新解锁节点，from 一定在已经解锁节点中
                if (!nodes.contains(toNode)) {//新解锁节点
                    nodes.add(toNode);//新节点加入已经解锁节点
                    result.add(poll);//解锁了新节点，证明该边可以需要，加入result
                    for (Edge e : toNode.edges) {
                        edges.add(e);
                    }
                }
            }
            break;
        }
        return result;
    }

}
