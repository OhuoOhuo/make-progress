package arithmetic.principalLine.arithmetic;

/**
 * 判断一个链表是否有环：
 * 1.判断链表中的每一个节点是否是其中另一个节点的next节点，双层循环，O(n^2)
 * 2.借助hashSet，时间O(n),空间O(n)
 * 3.两个指针，类似追击问题
 */
public class FindCycleLinkedListDemo {
    public static void main(String[] args) throws Exception {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        System.out.println(isCycle(node1));
    }

    private static boolean isCycle(Node node) {

        Node p1 = node;
        Node p2 = node;

        while (p2 !=null && p2.next !=null){
            p1 = p1.next;
            p2 = p2.next.next;

            if(p1.data == p2.data){
                return true;
            }
        }
        return false;
    }
}
