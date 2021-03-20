/*
package arithmetic.leetcode;

import java.util.*;

*/
/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *//*


public class Solution {


    public static void main(String[] args) {

    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        LinkedHashMap<TreeNode, Integer> map = new LinkedHashMap<>();
        map.put(tree, 1);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
                map.put(poll.left, map.get(poll) + 1);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                map.put(poll.right, map.get(poll) + 1);
            }
        }
        LinkedHashMap<Integer, List<ListNode>> helpMap = new LinkedHashMap<>();
        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
            if (helpMap.containsKey(entry.getValue())) {
                helpMap.get(entry.getValue()).add(new ListNode(entry.getKey().val));
            } else {
                ArrayList<ListNode> listNodes = new ArrayList<>();
                listNodes.add(new ListNode(entry.getKey().val));
                helpMap.put(entry.getValue(), listNodes);
            }
        }
        ArrayList<ListNode> listNodes = new ArrayList<>();
        for (Map.Entry<Integer, List<ListNode>> entry : helpMap.entrySet()) {
            List<ListNode> value = entry.getValue();
            ListNode node1 = value.get(0);
            ListNode cur = node1;
            for (int i = 1; i < value.size(); i++) {
                cur.next = value.get(i);
                cur = cur.next;
            }
            listNodes.add(node1);
        }
        ListNode[] finalList = new ListNode[listNodes.size()];
        for (int i = 0; i < listNodes.size(); i++) {
            finalList[i] = listNodes.get(i);
        }
        return finalList;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
*/
