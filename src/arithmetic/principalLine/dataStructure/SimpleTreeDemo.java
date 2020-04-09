package arithmetic.principalLine.dataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的基本操作
 */
public class SimpleTreeDemo {
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
                new Integer[]{3, 2, 6, 9, null, null, 10, null, null, 4, null, null, 8, 11, null, null, 12}));

        TreeNode treeNode = createBinaryTree(inputList);

        System.out.println("前序遍历："); //3 2 6 9 10 4 8 11 12
        preOrder(treeNode);
/*        System.out.println("中序遍历：");
        midOrder(treeNode);
        System.out.println("后序遍历：");
        postOrder(treeNode);
        System.out.println("广度优先：");
        levelOrder(treeNode);

        System.out.println("找到节点：");
        TreeNode tempNode = null;
        TreeNode treeNode1 = preFind(treeNode, 10, tempNode);
        System.out.println(treeNode1);*/


        simpleDel(treeNode,6);
        System.out.println("删除完成后");
        preOrder(treeNode);

    }

    /**
     * 删除节点简易版：
     * 若删除节点时叶子节点，直接删除
     * 若删除节点不是叶子节点，则删除该子树
     */

    public static void simpleDel(TreeNode treeNode, int i) {
        if (treeNode == null) {
            return;
        }

        if (treeNode.data == i) {
            treeNode = null;
        }

        if (treeNode.leftChild != null) {
            if (treeNode.leftChild.data == i) {
                treeNode.leftChild = null;
            } else {
                simpleDel(treeNode.leftChild, i);
            }
        }

        if (treeNode.rightChild != null) {
            if (treeNode.rightChild.data == i) {
                treeNode.rightChild = null;
            } else {
                simpleDel(treeNode.rightChild, i);
            }
        }
    }

    /**
     * 中序查找
     */
    private static TreeNode midFind(TreeNode treeNode, int i, TreeNode tempNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.leftChild != null) {
            if (treeNode.leftChild.data == i) {
                tempNode = treeNode.leftChild;
            } else {
                tempNode = midFind(treeNode.leftChild, i, tempNode);
            }
        }
        if (treeNode.data == i) {
            tempNode = treeNode;
        }
        if (treeNode.rightChild != null) {
            if (treeNode.rightChild.data == i) {
                tempNode = treeNode.rightChild;
            } else {
                tempNode = midFind(treeNode.rightChild, i, tempNode);
            }
        }
        return tempNode;
    }

    /***
     * 前序查找
     * @param treeNode
     * @param i
     */
    private static TreeNode preFind(TreeNode treeNode, int i, TreeNode tempNode) {

        if (treeNode == null) {
            return null;
        }

        if (treeNode.data == i) {
            return treeNode;
        }

        if (treeNode.leftChild != null) {
            if (treeNode.leftChild.data == i) {
                tempNode = treeNode.leftChild;
            } else {
                tempNode = preFind(treeNode.leftChild, i, tempNode);
            }
        }

        if (tempNode != null) {
            return tempNode;
        }

        if (treeNode.rightChild != null) {
            if (treeNode.rightChild.data == i) {
                tempNode = treeNode.rightChild;
            } else {
                tempNode = preFind(treeNode.rightChild, i, tempNode);
            }
        }
        return tempNode;
    }

    /**
     * 广度优先遍历
     */
    private static void levelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("树为空");
        }
        Queue<TreeNode> queuetree = new LinkedList<>();
        queuetree.offer(root);
        while (!queuetree.isEmpty()) {
            TreeNode node = queuetree.poll();
            System.out.print(node.data + " ");
            if (node.leftChild != null) {
                queuetree.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queuetree.offer(node.rightChild);
            }
        }

    }


    /**
     * 后续遍历
     */
    private static void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        postOrder(treeNode.leftChild);
        postOrder(treeNode.rightChild);
        System.out.print(treeNode.data + " ");
    }

    /**
     * 中序遍历
     */
    private static void midOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        midOrder(treeNode.leftChild);
        System.out.print(treeNode.data + " ");
        midOrder(treeNode.rightChild);
    }

    /**
     * 前序遍历
     */
    private static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.data + " ");
        preOrder(treeNode.leftChild);
        preOrder(treeNode.rightChild);
    }


    private static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
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
