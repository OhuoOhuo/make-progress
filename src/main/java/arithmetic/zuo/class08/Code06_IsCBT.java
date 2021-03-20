package arithmetic.zuo.class08;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一颗树是否是完全二叉树
 * <p>
 * 1.利用层序遍历，一个节点有右节点没有左节点 返回false 当到碰到一个不完整的节点，或者是叶子，则其后所有的节点都为叶子节点
 */
public class Code06_IsCBT {
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

    public static boolean isCBT2(Node head) {
        if (head == null) {
            return true;
        }
        return process(head).isCBT;
    }

    // 对每一棵子树，是否是满二叉树、是否是完全二叉树、高度
    public static class Info {
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean full, boolean cbt, int h) {
            isFull = full;
            isCBT = cbt;
            height = h;
        }
    }

    public static Info process(Node X) {
        if (X == null) {
            return new Info(true, true, 0);
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);


        int height = Math.max(leftInfo.height, rightInfo.height) + 1;


        boolean isFull = leftInfo.isFull
                &&
                rightInfo.isFull
                && leftInfo.height == rightInfo.height;


        boolean isCBT = false;
        if (isFull) {
            isCBT = true;
        } else { // 以x为头整棵树，不满
            if (leftInfo.isCBT && rightInfo.isCBT) {


                if (leftInfo.isCBT
                        && rightInfo.isFull
                        && leftInfo.height == rightInfo.height + 1) {
                    isCBT = true;
                }
                if (leftInfo.isFull
                        &&
                        rightInfo.isFull
                        && leftInfo.height == rightInfo.height + 1) {
                    isCBT = true;
                }
                if (leftInfo.isFull
                        && rightInfo.isCBT && leftInfo.height == rightInfo.height) {
                    isCBT = true;
                }


            }
        }
        return new Info(isFull, isCBT, height);
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isCBT1(head) != isCBT2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    private static boolean isCBT1(Node head) {

        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        boolean last = false;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (curNode.right != null && curNode.left == null) {
                return false;
            }

            if (
                    last
                            &&
                            (curNode.left != null || curNode.right != null)) {
                return false;
            }

            if (curNode.left == null || curNode.right == null) {
                last = true;
            }
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }

        return true;
    }
}
