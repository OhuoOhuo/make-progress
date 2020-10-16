package arithmetic.zuo.class02;

/**
 * 删除链表中所有固定的元素
 */
public class Code02_DeleteGivenValue {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static void main(String[] args) {
        Node node = generateRandomLinkedList(5, 3);
        removeValue(node, 4);
    }

    private static Node removeValue(Node head, int i) {
        while (head != null) {
            if (head.value != i) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;

        while (cur !=null){
            if(cur.value ==i){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur =cur.next;
        }
        return head;
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
