package arithmetic.zuo.class08;

import java.util.ArrayList;


/**
 * 求一棵树中的
 * 最大搜索树的数量
 */
public class Code04_MaxSubBSTSize {
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

    public static int maxSubBSTSize1(Node head) {
        if (head == null) {
            return 0;
        }
        int h = getBSTSize(head);
        if (h != 0) {
            return h;
        }
        return Math.max(maxSubBSTSize1(head.left), maxSubBSTSize1(head.right));
    }

    public static int getBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxSubBSTSize1(head) != maxSubBSTSize2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    private static int maxSubBSTSize2(Node head) {
        if (head == null) {
            return 0;
        }
        Info info = precess(head);
        return info.maxBSTSize;
    }

    private static Info precess(Node head) {
        if (head == null) {
            return null;
        }
        Info leftInfo = precess(head.left);
        Info rightInfo = precess(head.right);
        int min = head.value;
        int max = head.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }

        int lefMaxSize = leftInfo == null ? 0 : leftInfo.maxBSTSize;
        int rightMaxSize = rightInfo == null ? 0 : rightInfo.maxBSTSize;
        int maxBSTSize = Math.max(lefMaxSize, rightMaxSize);

        Boolean isBST = false;
        if (
                (leftInfo == null ? true : leftInfo.isBST) &&
                        (rightInfo == null ? true : rightInfo.isBST) &&
                        (leftInfo == null ? true : leftInfo.max < head.value) &&
                        (rightInfo == null ? true : rightInfo.min > head.value)
        ) {
            isBST = true;
            maxBSTSize = (leftInfo == null ? 0 : leftInfo.maxBSTSize) + (rightInfo == null ? 0 : rightInfo.maxBSTSize) + 1;
        }
        return new Info(min, max, isBST, maxBSTSize);
    }

    public static class Info {
        public Integer min;
        public Integer max;
        public Boolean isBST;
        public Integer maxBSTSize;

        public Info(int min, int max, Boolean isBST, int maxBSTSize) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
            this.maxBSTSize = maxBSTSize;
        }
    }

}
