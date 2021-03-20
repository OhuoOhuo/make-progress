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

    /**
     * 自定义堆结构
     */
    public static class NodeHeap {
        //堆本身
        private Node[] nodes;
        //堆当前大小
        private int size;
        //节点在堆上的位置
        private HashMap<Node, Integer> heapIndexMap;
        //节点到初始节点的距离，也是比较的条件
        private HashMap<Node, Integer> distanceMap;

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        //进入过堆
        public boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        //还在堆里面,(进入过堆，但是没弹出过)
        public boolean inHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        //如果在堆内则比较大小
        //已经来过，但是已经弹出过
        //从没来过
        public void addOrUpdateOrIgnore(Node node, Integer distance) {
            //在堆内
            if (inHeap(node)) {
                distanceMap.put(node, Math.max(distance, distanceMap.get(node)));
                insert(node, heapIndexMap.get(node));//上升
                heapify(heapIndexMap.get(node), size);//下降
            }
            //从没来过
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insert(node, size++);
            }
            //已经来过，但是已经弹出过，不做任何处理
        }

        private void insert(Node node, int size) {
            while (distanceMap.get(nodes[size]) < distanceMap.get(nodes[(size - 1) / 2])) {
                swap(size, (size - 1) / 2);
                size = (size - 1) / 2;
            }
        }

        public RecordNode pop() {
            if (isEmpty()) {
                return null;
            }
            RecordNode recordNode = new RecordNode(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size - 1]);//可以不删除
            heapify(0, --size);
            return recordNode;
        }

        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < size) {//nodes[size] 就已经出界，所以< size 表示没出界，size表示heap中的节点数，size -1 表示最大下标值
                //找到节点左右节点的最小值
                int smallSize = 0;//找到左右中比较小的那个下标，需要注意右节点的下标是否越界
                if (left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])) {//小根堆
                    smallSize = left + 1;
                } else {
                    smallSize = left;
                }
                if (distanceMap.get(nodes[index]) < distanceMap.get(nodes[smallSize])) {
                    break;
                }
                swap(index, smallSize);
                index = left;
                left = 2 * index + 1;
            }
        }

        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node tempNode = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tempNode;
        }
    }

    public static class RecordNode {
        private Node node;
        private Integer distance;

        public RecordNode(Node node, Integer distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static HashMap<Node, Integer> dijkstra2(Node from, Integer size) {

        NodeHeap nodeHeap = new NodeHeap(size);

        nodeHeap.addOrUpdateOrIgnore(from, 0);

        HashMap<Node, Integer> resultMap = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            RecordNode pop = nodeHeap.pop();
            Node cur = pop.node;
            int distance = pop.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, distance + edge.weight);
            }
            resultMap.put(cur, distance);
        }
        return resultMap;
    }


}
