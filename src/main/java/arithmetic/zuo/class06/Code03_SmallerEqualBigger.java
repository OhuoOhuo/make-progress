package arithmetic.zuo.class06;

import java.util.ArrayList;

import static java.util.Collections.swap;

/**
 * 把链表节点划分成小于等于大于
 * 类似于数组上的荷兰国旗问题，解法一就位  链表转换为数组->玩partition->链表
 */
public class Code03_SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    private static Node listPartition1(Node head, int i) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<Node> nodes = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        partition(nodes, i);
        head = nodes.get(0);
        cur = head;
        for (int j = 1; j < nodes.size(); j++) {
            cur.next = nodes.get(j);
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    //荷兰国旗
    private static void partition(ArrayList<Node> nodes, int value) {
        int small = -1;
        int big = nodes.size();
        int i = 0;
        while (i < big) {
            if (nodes.get(i).value < value) {
                swap(nodes, i++, ++small);
            } else if (nodes.get(i).value == value) {
                i++;
            } else {
                swap(nodes, i, --big);
            }
        }
    }


    private static Node listPartition2(Node head, int pivot) {
        //将链表遍历，把它划分为3个链表，分别是< = > ,并记录它们的头节
        Node sT = null;
        Node sE = null;
        Node eT = null;
        Node eE = null;
        Node bT = null;
        Node bE = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sT == null) {
                    sT = head;
                    sE = head;
                } else {
                    sE.next = head;
                    sE = sE.next;
                }
            } else if (head.value == pivot) {
                if (eT == null) {
                    eT = head;
                    eE = head;
                } else {
                    eE.next =head;
                    eE=eE.next;
                }
            } else {
                if(bT == null){
                    bT=head;
                    bE =head;
                }else {
                    bE.next =head;
                    bE = bE.next;
                }
            }
            head = next;
        }
        //现在来连接三个链表，3个链表都可能为空
        if(sE !=null){//小于区域存在
            sE.next = eT;
            eE = eE==null ?sE:eE;
        }
        if(eE !=null){//小于区域，等于区域不是都没有
            eE.next = bT;
        }
        return sT !=null?sT:(eT !=null?sT:bT);
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
       // head1 = listPartition1(head1, 4);
       // head1 = listPartition2(head1, 5);
        printLinkedList(head1);
    }


    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }


}
