package arithmetic.leetcode;

import java.util.Stack;

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * <p>
 * 方法1：利用stack 就按照题意写代码就ok，但是会产生问题，超出int最大值(第一想法，测试后不正确)
 * 方法2：链表相加 ,其实比较简单，主要是链表问题需要注意如果需要返回头结点，需要额外变量
 */
public class Code03 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(6);
        listNode.next.next = new ListNode(4);


/*        ListNode listNode1 = new ListNode(9);
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(9);
        listNode.next.next = new ListNode(9);
        listNode.next.next.next = new ListNode(9);
        listNode.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next.next.next.next = new ListNode(9);*/
        ListNode listNode2 = addTwoNumbers1(listNode1, listNode);

        System.out.println(2 % 10);

    }

    /**
     * * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * * 输出：7 -> 0 -> 8
     * * 原因：342 + 465 = 807
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode haed = null;
        ListNode l3 = null;
        int addNum = 0;
        while (cur1 != null || cur2 != null) {
            int val1 = cur1 == null ? 0 : cur1.val;
            int val2 = cur2 == null ? 0 : cur2.val;
            ListNode listNode = new ListNode((val1 + val2 + addNum) % 10);
            addNum = (val1 + val2+addNum) / 10;
            if (haed == null) {
                haed = listNode;
                l3 = haed;
            } else {
                l3.next = listNode;
                l3 = l3.next;
            }
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
        }

        return haed;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> integerStack = new Stack<Integer>();
        ListNode cur = l1;
        while (cur != null) {
            integerStack.push(cur.val);
            cur = cur.next;
        }
        int one = 0;
        while (!integerStack.isEmpty()) {
            int size = integerStack.size();
            Integer pop = integerStack.pop();
            one = one + (int) (pop * Math.pow(10, size - 1));
        }

        cur = l2;
        while (cur != null) {
            integerStack.push(cur.val);
            cur = cur.next;
        }
        int two = 0;
        while (!integerStack.isEmpty()) {
            int size = integerStack.size();
            Integer pop = integerStack.pop();
            two = two + (int) (pop * Math.pow(10, size - 1));
        }
        int newNum = one + two;


        char[] chars = String.valueOf(newNum).toCharArray();

        for (int i = 0; i < chars.length; i++) {
            integerStack.push(Integer.valueOf(String.valueOf(chars[i])));
        }

        Integer pop = integerStack.pop();
        ListNode head = new ListNode(pop);
        cur = head;
        while (!integerStack.isEmpty()) {
            ListNode listNode = new ListNode(integerStack.pop());
            cur.next = listNode;
            cur = cur.next;
        }

        return head;
    }


}
