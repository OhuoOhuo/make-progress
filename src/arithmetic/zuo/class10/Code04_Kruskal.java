package arithmetic.zuo.class10;

import java.util.*;

public class Code04_Kruskal {

    //并查集
    public static class UnionSet {

        HashMap<Node, Node> fatherMap;

        HashMap<Node, Integer> sizeMap;

        public UnionSet(Collection<Node> list) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (Node node : list) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Boolean isSameSet(Node node1, Node node2) {
            return findFather(node1) == findFather(node2);
        }

        public Node findFather(Node node) {
            Queue<Node> nodes = new LinkedList<>();
            while (node != fatherMap.get(node)) {
                nodes.add(fatherMap.get(node));
                node = fatherMap.get(node);
            }
            while (!nodes.isEmpty()) {
                Node poll = nodes.poll();
                fatherMap.put(poll, node);
            }
            return node;
        }

        public void union(Node node1, Node node2) {
            Node father1 = findFather(node1);
            Node father2 = findFather(node2);
            if (father1 != father2) {
                Integer integer1 = sizeMap.get(father1);
                Integer integer2 = sizeMap.get(father2);
                if (integer1 > integer2) {
                    fatherMap.put(father2, father1);
                    sizeMap.put(father1, integer1 + integer2);
                    sizeMap.remove(father2);
                } else {
                    fatherMap.put(father1, father2);
                    sizeMap.put(father2, integer1 + integer2);
                    sizeMap.remove(father1);
                }
            }
        }

    }

    public static Set<Edge> kruskalMST(Graph graph) {
        Collection<Node> values = graph.nodes.values();
        if (values == null) {
            return null;
        }
        UnionSet unionSet = new UnionSet(values);

        //小根堆
        Queue<Edge> edges = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        for (Edge edge : graph.edges) {
            edges.add(edge);
        }
        HashSet<Edge> result = new HashSet<>();
        while (!edges.isEmpty()) {
            Edge poll = edges.poll();
            if (!unionSet.isSameSet(poll.from, poll.to)) {
                result.add(poll);
                unionSet.union(poll.from, poll.to);
            }
        }
        return result;
    }


}
