package arithmetic.zuo.class07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的最宽层 节点数量
 *
 * 主要利用数的按行遍历过程
 * 利用map可以记录需要信息
 * 利用指针可以节约空间
 *
 */
public class Code06_TreeMaxWidth {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int maxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        //K —>节点  V ->层数
        HashMap<Node, Integer> map = new HashMap<>();
        map.put(head, 1);
        int curLevel = 1;//当前层
        int curNums = 0;//当前层节点个数
        int max = 0; //最大值
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            //拿出当节点层数 
            Integer integer = map.get(cur);
            if (cur.left != null) {
                queue.add(cur.left);
                map.put(cur.left, integer + 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                map.put(cur.right, integer + 1);
            }
            if (integer == curLevel) {//如果还是当前层数
                curNums++;
                max = Math.max(max, curNums);
            } else { //不是当前层了
                curLevel++;//进入下一层
                curNums = 1;//个数初始为1
            }
        }
        return max;
    }

    public static int maxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head; //当前层的最后一个节点
        Node nextEnd = null; //下一层的最后一个节点
        int max = 0;
        int curNum = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            curNum++;//当前节点数加一
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }

            if(cur ==curEnd){//一层的最后一个节点
                curEnd = nextEnd; //当前层最后一个节下移至，下一层最后一个节点
                max = Math.max(max,curNum); //计算最大值
                curNum =0; //把当前层节点数置空
            }
        }
        return max;
    }

    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxWidthUseMap(head) != maxWidthNoMap(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");

    }

}
