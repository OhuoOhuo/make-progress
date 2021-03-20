package arithmetic.zuo.class10;

/**
 * N*3 的矩阵来表示图
 * matrix 所有的边
 * N*3 的矩阵
 * [weight, from节点上面的值，to节点上面的值]
 * 每个节点的值规定不同
 */
public class GraphGenerator {

    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            int weight = matrix[i][0];
            int from = matrix[i][1];
            int to = matrix[i][2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);
            graph.edges.add(edge);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(edge);
        }

        return graph;
    }
}
