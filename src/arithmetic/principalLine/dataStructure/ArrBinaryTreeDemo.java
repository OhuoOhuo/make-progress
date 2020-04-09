package arithmetic.principalLine.dataStructure;

/**
 * 顺序二叉树特点：
 * 通常用数组来存储
 * 一般只考虑完全二叉树
 * 第n个元素的左子节点为：2n+1
 * 第n个元素的右子节点为：2n+2
 * 第n个元素的父节点为：（n-1）/2
 * 从0开始，n表示二叉树中的第几个元素
 */

public class ArrBinaryTreeDemo {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr){
        this.arr =arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    public void preOrder(int i){
        if(arr ==null ||arr.length ==0){
            new RuntimeException("不能为空");
        }

        System.out.print(arr[i] +" ");

        if(i*2 +1<arr.length){
            preOrder(i*2+1);
        }

        if(i*2+2<arr.length){
            preOrder(i*2+2);
        }

    }
}
