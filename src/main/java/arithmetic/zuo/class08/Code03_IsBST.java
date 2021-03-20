package arithmetic.zuo.class08;

import java.util.ArrayList;

public class Code03_IsBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBST1(Node head) {
        if (head == null) {
            return true;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return false;
            }
        }
        return true;
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
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
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isBST1(head) != isBST2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    private static boolean isBST2(Node head) {
        if (head == null) {
            return true;
        }
        Info info = process(head);
        return info.isBST;
    }

    private static Info process(Node head) {
        if (head == null) {
            return null;//返回参数为null ，则后续必须都判断是否为null的情况，注意是递归
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int min = head.value;
        int max = head.value;
        if (leftInfo != null) {
            min = Math.min(leftInfo.min, min);
            max = Math.max(leftInfo.max, max);
        }
        if (rightInfo != null) {
            min = Math.min(rightInfo.min, min);
            max = Math.max(rightInfo.max, max);
        }
        Boolean isBst = false;
        if ((leftInfo == null ? true : leftInfo.isBST && leftInfo.max < head.value)
                &&
                (rightInfo == null ? true : rightInfo.isBST && rightInfo.min > head.value)
        ) {
            isBst = true;
        }

        return new Info(min, max, isBst);
    }

    public static class Info {
        public Integer min;
        public Integer max;
        public Boolean isBST;

        public Info(int min, int max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

}
