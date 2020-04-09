package arithmetic.principalLine.dataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class treeDemo {
    /**
     * 根节点，子节点，叶子节点，父节点，兄弟节点，树的高度
     * <p>
     * 二叉树：
     * 满二叉树，完成二叉树
     * <p>
     * 二叉树的遍历：
     * 1.深度优先遍历（前序遍历，中序遍历，后序遍历）
     * 2.广度优先遍历 (层序遍历)
     */


    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList(Arrays.asList(
                new Integer[]{3, 2, 6,9, null, null, 10, null,null,4,null,null, 8, 11,null,null,12}));

        TreeNode treeNode = createBinaryTree(inputList);

        System.out.println("前序遍历：");
        preOrder(treeNode);
        System.out.println("中序遍历：");
        midOrder(treeNode);
        System.out.println("后序遍历：");
        postOrder(treeNode);
        System.out.println("广度优先：");
        levelOrder(treeNode);


    }

    private static void levelOrder(TreeNode root) {
        if(root==null){
            System.out.println("树为空");
        }
        Queue<TreeNode> queuetree = new LinkedList<>();
        queuetree.offer(root);
        while (!queuetree.isEmpty()){
            TreeNode node = queuetree.poll();
            System.out.print(node.data+" ");
            if(node.leftChild !=null){
                queuetree.offer(node.leftChild);
            }
            if(node.rightChild !=null){
                queuetree.offer(node.rightChild);
            }
        }

    }


    private static void postOrder(TreeNode treeNode) {
        if(treeNode ==null){
            return;
        }

        postOrder(treeNode.leftChild);
        postOrder(treeNode.rightChild);
        System.out.print(treeNode.data+" ");
    }

    private static void midOrder(TreeNode treeNode) {
        if (treeNode ==null){
            return;
        }
        midOrder(treeNode.leftChild);
        System.out.print(treeNode.data+" ");
        midOrder(treeNode.rightChild);
    }

    private static void preOrder(TreeNode treeNode) {
        if (treeNode ==null){
            return;
        }
        System.out.print(treeNode.data+" ");
        preOrder(treeNode.leftChild);
        preOrder(treeNode.rightChild);
    }


    private static TreeNode createBinaryTree(LinkedList<Integer>
                                                    inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }


    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }


}
