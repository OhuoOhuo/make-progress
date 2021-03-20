package arithmetic.zuo.class06;

import java.util.ArrayList;

/**
 * 找到一个链表的中点节点
 * 1.
 */
public class Code01_LinkedListMid {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        Node test = null;
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(3);
        test.next.next.next.next = new Node(4);
        test.next.next.next.next.next = new Node(5);
        test.next.next.next.next.next.next = new Node(6);
        test.next.next.next.next.next.next.next = new Node(7);
        test.next.next.next.next.next.next.next.next = new Node(8);

        Node ans1 = null;
        Node ans2 = null;

        ans1 = midOrUpMidNode(test);
        ans2 = right1(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");

        ans1 = midOrDownMidNode(test);
        ans2 = right2(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");

/*         ans1 = midOrUpMidPreNode(test);
        ans2 = right3(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");

        ans1 = midOrDownMidPreNode(test);
        ans2 = right4(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");*/

    }

    /**
     * 基数节点返回中点，偶数节点返回下中点
     * @param head
     * @return
     */
    private static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next !=null&& fast.next.next!=null){
            slow =slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 基数个节点返回中点，偶数个节点返回上中点
     */
    private static Node midOrUpMidNode(Node head) {
        //0-2个节点，返回头结点
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        //3个节点及以上
        Node slow = head.next;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node right2(Node test) {
        if (test == null) {
            return null;
        }
        ArrayList<Node> nodes = new ArrayList<>();
        Node cur = test;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        return nodes.get(nodes.size() / 2);

    }

    public static Node right1(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> nodes = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        return nodes.get((nodes.size() - 1) / 2);
    }
}
