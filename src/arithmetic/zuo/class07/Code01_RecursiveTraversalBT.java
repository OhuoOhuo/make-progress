package arithmetic.zuo.class07;

/**
 * 二叉树的遍历
 * 前序，中序，后序
 * 其本质为遍历会到每个节点3次 参考方法f
 * 前序遍历 为第一次到达打印
 * 中序遍历 为第二次到达打印
 * 后序遍历 为第三次到达打印
 *
 * 遍历都是左到右
 */
public class Code01_RecursiveTraversalBT {

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
        System.out.println("========前序遍历");
        in(head);
        System.out.println("========中序遍历");
        pos(head);
        System.out.println("========后序遍历");
        f(head);

    }

    private static void f(Node head){
        if(head ==null){
            return;
        }
        System.out.print(head.value+ "  ");
        f(head.left);
        System.out.print(head.value+ "  ");
        f(head.right);
        System.out.print(head.value+ "  ");
    }


    private static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.print(head.value + "  ");

    }

    private static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.print(head.value + "  ");
        in(head.right);
    }

    //前序遍历
    private static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + "  ");
        pre(head.left);
        pre(head.right);
    }
}
