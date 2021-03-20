package arithmetic.zuo.class07;

import java.util.Stack;

/**
 * 二叉树遍历的非递归版
 */
public class Code02_UnRecursiveTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos1(head);
        System.out.println("========");
        pos2(head);
        System.out.println("========");
    }

    private static void pos2(Node head) {
    }

    private static void pos1(Node head) {
        if (head == null) {
            return;
        }
        System.out.println("后序打印：");
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            //System.out.print(head.value + " ");
            stack1.push(head);
            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
        }
        while (!stack1.isEmpty()) {
            System.out.print(stack1.pop().value + " ");
        }

    }

    private static void in(Node head) {
        System.out.println("中序打印");
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }

    }

    private static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println("前序打印：");
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }

    }


}
