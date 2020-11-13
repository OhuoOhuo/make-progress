package arithmetic.zuo.class08;

import java.util.ArrayList;

public class Code05_MaxSubBSTHead {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
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

    public static Node maxSubBSTHead1(Node head) {
        if (head == null) {
            return null;
        }
        if (getBSTSize(head) != 0) {
            return head;
        }
        Node leftAns = maxSubBSTHead1(head.left);
        Node rightAns = maxSubBSTHead1(head.right);
        return getBSTSize(leftAns) >= getBSTSize(rightAns) ? leftAns : rightAns;
    }

    public static Node maxSubBSTHead2(Node head) {
        if (head == null) {
            return null;
        }
        Info info = process(head);
        return info.headNode;
    }

    private static Info process(Node head) {
        if (head == null) {
            return null;
        }
/*        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);
        int min = X.value;
        int max = X.value;
        Node maxSubBSTHead = null;
        int maxSubBSTSize = 0;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            maxSubBSTHead = leftInfo.headNode;
            maxSubBSTSize = leftInfo.size;
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            if (rightInfo.size > maxSubBSTSize) {
                maxSubBSTHead = rightInfo.headNode;
                maxSubBSTSize = rightInfo.size;
            }
        }
        boolean isBst =false;
        if (
                (leftInfo == null ? true : leftInfo.isBst)
                        && (rightInfo == null ? true : rightInfo.isBst)
                        && (leftInfo == null ? true : X.value > leftInfo.max)
                        && (rightInfo == null ? true : X.value < rightInfo.min)
        ) {
            isBst =true;
            maxSubBSTHead = X;
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.size)
                    + (rightInfo == null ? 0 : rightInfo.size) + 1;
        }
        return new Info(max, min, isBst,maxSubBSTSize ,maxSubBSTHead);*/
        if (head == null) {
            return null;
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int max = head.value;
        int min = head.value;
        int size = 0;
        Node headNode = null;

        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
            size = leftInfo.size;
            headNode = leftInfo.headNode;
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
            if (rightInfo.size > size) {
                headNode = rightInfo.headNode;
                size = rightInfo.size;
            }
        }

        boolean isBst = false;

        if (
                (leftInfo == null ? true : leftInfo.isBst)
                        && (rightInfo == null ? true : rightInfo.isBst)
                        && (leftInfo == null ? true : head.value > leftInfo.max)
                        && (rightInfo == null ? true : head.value < rightInfo.min)
        ) {//如果以当前节点为头节点的树是bst
            isBst = true;
            headNode = head;
            size = (leftInfo == null ? 0 : leftInfo.size) + (rightInfo == null ? 0 : rightInfo.size) + 1;
        }
        Info info = new Info(max, min, isBst, size, headNode);
        return info;
    }


    public static class Info {
        public int max;
        public int min;
        public boolean isBst;
        public int size;
        public Node headNode;

        public Info(int max, int min, boolean isBst, int size, Node headNode) {
            this.max = max;
            this.min = min;
            this.isBst = isBst;
            this.size = size;
            this.headNode = headNode;
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
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            Node node1 = maxSubBSTHead1(head);
            Node node2 = maxSubBSTHead2(head);
            if (maxSubBSTHead1(head) != maxSubBSTHead2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}
