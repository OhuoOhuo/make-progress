package arithmetic.practice;


/**
 * 数的遍历
 */
public class traversalBT {

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
        head.left.left.left = new Node(8);
        head.left.left.right = new Node(9);
        head.left.right.left = new Node(10);
        head.left.right.right = new Node(11);
        head.right.left.left = new Node(12);
        head.right.left.right = new Node(13);
        head.right.right.left = new Node(14);
        head.right.right.right = new Node(15);

        pre(head);
        System.out.println("========前序遍历");
        in(head);
        System.out.println("========中序遍历");
        pos(head);
        System.out.println("========后序遍历");
        f(head);

    }

    /**
     * 遍历的实质
     */
    private static void f(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        f(head.left);
        System.out.print(head.value + " ");
        f(head.right);
        System.out.print(head.value + " ");
    }

    private static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.print(head.value + " ");
    }

    private static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.print(head.value + " ");
        in(head.right);
    }

    private static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        pre(head.left);
        pre(head.right);
    }
}
