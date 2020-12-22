package arithmetic.practice;

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
        public arithmetic.zuo.class02.Code01_ReverseList.DoubleNode last;
        public arithmetic.zuo.class02.Code01_ReverseList.DoubleNode next;

        public DoubleNode(int date) {
            value = date;
        }
    }

    public static Node removeValue(Node head, int num) {
        while (head.value == num) {
            head = head.next;
        }
        Node cur =head;
        Node pre = head;
        while (cur!=null){
            if(cur.value ==num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur=cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        System.out.println("ddd");
    }
}
