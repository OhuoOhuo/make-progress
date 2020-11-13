package arithmetic.zuo.class08;

/**
 * 判断一颗二叉树是否是满二叉树
 * <p>
 * 满二叉树的条件：高度n 节点为 2 的n次方 -1
 */

public class Code02_IsFull {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isFull1(Node head) {
        if (head == null) {
            return true;
        }
        int height = h(head);
        int nodes = n(head);
        return (1 << height) - 1 == nodes;
    }

    public static int h(Node head) {
        if (head == null) {
            return 0;
        }
        return Math.max(h(head.left), h(head.right)) + 1;
    }

    public static int n(Node head) {
        if (head == null) {
            return 0;
        }
        return n(head.left) + n(head.right) + 1;
    }

    public static boolean isFull2(Node head) {
        if (head == null) {
            return true;
        }
        Info info = precess(head);
        return (1 << info.n) - 1 == info.nodesNum;
    }

    private static Info precess(Node head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info leftInfo = precess(head.left);
        Info rightInfo = precess(head.right);
        int n = Math.max(leftInfo.n, rightInfo.n) + 1;
        int nodesNum = leftInfo.nodesNum + rightInfo.nodesNum + 1;
        return new Info(n, nodesNum);
    }


    public static class Info {
        public int n;//高度
        public int nodesNum;//节点数

        public Info(int n, int nodesNum) {
            this.n = n;
            this.nodesNum = nodesNum;
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

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isFull1(head) != isFull2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}
