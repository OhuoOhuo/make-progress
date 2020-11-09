package arithmetic.zuo.class08;

/**
 * 体会套路！！！
 *
 */
public class Code01_IsBalanced {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info {
        public Integer high;
        public Boolean isBalance;

        public Info(Integer high, Boolean isBalance) {
            this.high = high;
            this.isBalance = isBalance;
        }
    }

    private static boolean isBalanced2(Node head) {
        Info info = process(head);
        return info.isBalance;
    }

    private static Info process(Node head) {
        if (head == null) {
            return new Info(0, true);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int high =Math.max(leftInfo.high,rightInfo.high)+1;
        Boolean isBalance = false;
        if(leftInfo.isBalance && rightInfo.isBalance && (Math.abs(leftInfo.high.intValue() -rightInfo.high.intValue()) <= 1)){
            isBalance =true;
        }
        return new Info(high,isBalance);
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isBalanced1(head) != isBalanced2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
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

    public static boolean isBalanced1(Node head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head, ans);
        return ans[0];
    }

    public static int process1(Node head, boolean[] ans) {
        if (!ans[0] || head == null) {
            return -1;
        }
        int leftHeight = process1(head.left, ans);
        int rightHeight = process1(head.right, ans);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


}
