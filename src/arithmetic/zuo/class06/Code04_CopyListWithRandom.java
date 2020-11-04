package arithmetic.zuo.class06;

import java.util.HashMap;

/**
 * 深度拷贝
 * <p>
 * 节点有多一个随机指针，该指针可以随便指向其它节点和null
 * 现在请拷贝出一个完全一样的链表
 */
public class Code04_CopyListWithRandom {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }


    /**
     * 方法一，利用map
     * 把新旧节点一一对应，在一一连接
     */
    private static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> nodeMap = new HashMap<>();//k->v  老节点->老节点
        Node cur = head;
        while (cur != null) {
            nodeMap.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            //nodeMap.get(cur) 为新节点，新节点的下一个节 = cur.next(老节点的下一个节点)在map中的节点
            nodeMap.get(cur).next = nodeMap.get(cur.next);
            nodeMap.get(cur).rand = nodeMap.get(cur.rand);
            cur = cur.next;
        }
        return nodeMap.get(head);
    }

    /**
     * 方法二，不用map，但是模拟map思路
     */
    private static Node copyListWithRand2(Node head) {
        //todo
        return head;
    }


    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        System.out.println("原始链表：");
        printRandLinkedList(head);
        System.out.println("=========================");
        res1 = copyListWithRand1(head);
        System.out.println("方法一的拷贝链表：");
        printRandLinkedList(res1);
        System.out.println("=========================");
        res2 = copyListWithRand2(head);
        System.out.println("方法二的拷贝链表：");
        printRandLinkedList(res2);
        System.out.println("=========================");
        System.out.println("经历方法二拷贝之后的原始链表：");
        printRandLinkedList(head);
        System.out.println("=========================");

    }




    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }


}
