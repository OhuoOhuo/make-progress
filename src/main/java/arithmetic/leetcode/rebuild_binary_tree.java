package arithmetic.leetcode;


/**
 *  输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回根结点。
 */
public class rebuild_binary_tree {

    public static void main(String[] args) {

        int[] pre = {1,2,4,7,3,5,6,8};
        int[] mid = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, mid);

        System.out.println(treeNode);

        TreeNode treeNode1 = rebuildBinaryTree(pre, 0, pre.length - 1, mid, 0, mid.length - 1);

        System.out.println(treeNode1);

    }

    public static TreeNode rebuildBinaryTree(int[] pre, int preStart, int preEnd, int[] mid, int midStart, int midEnd) {
/*        if (pre == null || mid == null || pre.length < 1 || mid.length < 1 || pre.length != mid.length) {
            return null;
        }*/

        if(preStart >preEnd || midStart > midEnd){
            return null;
        }
        int headVal = pre[preStart];
        TreeNode head = new TreeNode(headVal);
        if (preStart == preEnd || midStart == midEnd) {
            return head;
        }
        //找到中间节点
        int rootIndex = 0;
        for (int i = midStart; i <= midEnd; i++) {
            if (headVal == mid[i]) {
                rootIndex = i;
            }
        }
        int size = rootIndex - midStart ;
        head.left = rebuildBinaryTree(pre, preStart + 1, preStart+size, mid, midStart, rootIndex - 1);
        head.right = rebuildBinaryTree(pre, preStart+1 + size, preEnd, mid, rootIndex + 1, midEnd);

        return head;

    }


    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        /*根据前序遍历和中序遍历确定一棵二叉树*/
        //递归实现
        if (pre == null || in == null || pre.length == 0)
            return null;
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in, int pre_begin,
                                                 int pre_end, int in_begin, int in_end) {
        ////前序序列：从pre_begin到pre_end,  中序序列：从in_begin到in_end
        //递归结束条件
        if (pre_begin > pre_end || in_begin > in_end)
            return null;

        int rootValue = pre[pre_begin];
        TreeNode root = new TreeNode(rootValue);  //第一个节点就是根节点
        if (pre_begin == pre_end || in_begin == in_end)
            return root;
        //在中序序列中，找到root，前面的就是左子树，右边的就是右子树
        int rootIn = in_begin; //root在中序序列中的位置
        while (rootIn <= in_end && in[rootIn] != rootValue)
            rootIn++;

        int left_count = rootIn - in_begin; //左子树节点个数
        root.left = reConstructBinaryTree(pre, in, pre_begin + 1, pre_begin + left_count,
                in_begin, rootIn - 1);
        root.right = reConstructBinaryTree(pre, in, pre_begin + left_count + 1,
                pre_end, rootIn + 1, in_end);
        return root;
    }


    /*private static TreeNode f2(TreeNode head, int[] left, int[] right) {


        head.left = f2();
        head.right = f2();

        return head;
    }

    public static Bean f() {

        TreeNode now = new TreeNode(0);
        Bean leftTree = f();
        Bean rightTree = f();
        now.left = leftTree.treeNode;
        now.right = rightTree.treeNode;

        return new Bean(now, -1, -1, -1);
    }

    public static class Bean {
        TreeNode treeNode;
        int headIndex;
        int midStart;
        int midEnd;

        public Bean(TreeNode treeNode, int headIndex, int midStart, int midEnd) {
            this.treeNode = treeNode;
            this.headIndex = headIndex;
            this.midEnd = midEnd;
            this.midStart = midStart;
        }
    }
*/
}
