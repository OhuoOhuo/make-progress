package arithmetic.zuo.class02;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表，双向链表的反转
 */

public class Code01_ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int date) {
            value = date;
        }
    }

    public static void main(String[] args) {
        int len = 5;
        int value = 4;
        int testTime = 10000;
        System.out.println("test begin!");

        for (int i = 0; i < testTime; i++) {
            Node node1 = generateRandomLinkedList(len, value);
            List<Integer> list1 = getLinkedListOriginOrder(node1);
            node1 = reverseLinkedList(node1);
            if (!checkLinkedListReverse(list1, node1)) {
                System.out.println("Oops1!");
            }

            Node node2 = generateRandomLinkedList(len, value);
            List<Integer> list2 = getLinkedListOriginOrder(node2);
            node2 = testReverseLinkedList(node2);
            if (!checkLinkedListReverse(list2, node2)) {
                System.out.println("Oops2!");
            }

            DoubleNode node3 = generateRandomDoubleList(len, value);
            List<Integer> list3 = getDoubleListOriginOrder(node3);
            node3 = reverseDoubleList(node3);
            if (!checkDoubleListReverse(list3, node3)) {
                System.out.println("Oops3!");
            }

            DoubleNode node4 = generateRandomDoubleList(len, value);
            List<Integer> list4 = getDoubleListOriginOrder(node4);

            node4 = testReverseDoubleList(node4);
            if (!checkDoubleListReverse(list4, node4)) {
                System.out.println("Oops4!");
            }


        }
        System.out.println("test pass");

        Node node = generateRandomLinkedList(len, value);
        removeValue(node, 4);


    }

    public static Node removeValue(Node head, int num) {
        // head来到第一个不需要删的位置
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }


    private static DoubleNode testReverseDoubleList(DoubleNode node4) {
        if (node4 == null) {
            return null;
        }
        List<DoubleNode> list = new ArrayList<>();
        while (node4 != null) {
            list.add(node4);
            node4 = node4.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                list.get(i).next = null;
            } else {
                list.get(i).next = list.get(i - 1);
            }
            if (i + 1 == N) {
                list.get(i).last = null;
            } else {
                list.get(i).last = list.get(i + 1);
            }
        }
        return list.get(N - 1);
    }

    // for test
    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.next;
        }
        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.value)) {
                return false;
            }
            end = end.last;
        }
        return true;
    }

    private static DoubleNode reverseDoubleList(DoubleNode haed) {
        if (haed == null) {
            return null;
        }
        DoubleNode pre = null;
        DoubleNode next = null;
        while (haed != null) {
            next = haed.next;
            haed.next = pre;
            haed.last = next;
            pre = haed;
            haed = next;
        }
        return pre;
    }


    // for test
    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    private static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (1 + value));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (1 + value)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode newNode = new DoubleNode((int) (Math.random() * (1 + value)));
            pre.next = newNode;
            newNode.last = pre;
            pre = pre.next;
            size--;
        }
        return head;
    }

    private static Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        list.get(0).next = null;
        int N = list.size();
        for (int i = 0; i < N - 1; i++) {
            list.get(i + 1).next = list.get(i);
        }
        return list.get(N - 1);
    }


    // for test
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private static Node reverseLinkedList(Node head) {
/*        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;*/
        if (head == null) {
            return null;
        }
        Node n2 = head.next;
        head.next = null;
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = head;
            head = n2;
            n2 = n3;
        }
        return head;

    }

    private static List<Integer> getLinkedListOriginOrder(Node node1) {
        List<Integer> integerArrayList = new ArrayList<>();
        while (node1 != null) {
            integerArrayList.add(node1.value);
            node1 = node1.next;
        }
        return integerArrayList;
    }

    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        size--;
        while (size != 0) {
            Node newNode = new Node((int) (Math.random() * (value + 1)));
            pre.next = newNode;
            pre = newNode;
            size--;
        }
        return head;
    }


}
