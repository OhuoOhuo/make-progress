package arithmetic.zuo.class08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一棵树上的两个节点，找到两个节点第一交汇节点
 *
 * 1.利用map
 * 2.利用套路：
 * 一点体会，找到成立，不成立的各种情况，总结成立的情况
 */
public class Code07_lowestAncestor {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    // for test
    public static Node pickRandomOne(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> arr = new ArrayList<>();
        fillPrelist(head, arr);
        int randomIndex = (int) (Math.random() * arr.size());
        return arr.get(randomIndex);
    }

    // for test
    public static void fillPrelist(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        arr.add(head);
        fillPrelist(head.left, arr);
        fillPrelist(head.right, arr);
    }

    public static Node lowestAncestor2(Node head, Node o1, Node o2) {

        if (head == null) {
            return null;
        }
        Info info = process(head, o1, o2);
        return info.findNode;
    }

    private static Info process(Node x, Node o1, Node o2) {
        if (x == null) {
            return new Info(null, false, false);
        }
        Info leftInfo = process(x.left, o1, o2);
        Info rightInfo = process(x.right, o1, o2);

        boolean findOne = x == o1 || leftInfo.findOne || rightInfo.findOne;//判断在该子树下，是否找到o1
        boolean findTwo = x == o2 || leftInfo.findTwo || rightInfo.findTwo;//判断在该子树下，是否找到o2

        Node findNode =null;

        if(leftInfo.findNode !=null){
            findNode = leftInfo.findNode;
        }
        if(rightInfo.findNode !=null){
            findNode = rightInfo.findNode;
        }
        if(findNode == null){
            if(findOne && findTwo){
                findNode =x;
            }
        }
        return new Info(findNode,findOne,findTwo);
    }

    public static class Info {
        public Node findNode;
        public boolean findOne;
        public boolean findTwo;

        public Info(Node findNode, boolean findOne, boolean findTwo) {
            this.findNode = findNode;
            this.findOne = findOne;
            this.findTwo = findTwo;
        }
    }


    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            Node o1 = pickRandomOne(head);
            Node o2 = pickRandomOne(head);
            if (lowestAncestor1(head, o1, o2) != lowestAncestor2(head, o1, o2)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    /**
     * 利用map，记录每个节点的父节点，把一个节点的所有父节点放入一个set，去找另一个节点的父节点
     */
    private static Node lowestAncestor1(Node head, Node o1, Node o2) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> parentMap = new HashMap<>();
        parentMap.put(head, null);
        put2Map(head, parentMap);
        Set<Node> nodeHashSet = new HashSet<Node>();
        while (o1 != null) {
            nodeHashSet.add(o1);
            o1 = parentMap.get(o1);
        }
        while (o2 != null) {
            if (nodeHashSet.contains(o2)) {
                return o2;
            }
            o2 = parentMap.get(o2);
        }
        return null;
    }

    private static void put2Map(Node head, HashMap<Node, Node> parentMap) {
        if (head.left != null) {
            parentMap.put(head.left, head);
            put2Map(head.left, parentMap);
        }
        if (head.right != null) {
            parentMap.put(head.right, head);
            put2Map(head.right, parentMap);
        }
    }
}
