package arithmetic.zuo.class07;

/**
 * 折纸问题：
 * 可以构建一颗有规律的二叉树
 * 该二叉树的中序遍历即为所要的结果
 *
 * 不需要构建出二叉树
 * 可以利用中序遍历的特点直接得出结论
 */
public class Code08_PaperFolding {


    public static void main(String[] args) {
        int N = 4;
        printPro(N);
    }

    private static void printPro(int N) {
        process(1,N,true);
    }


    private static void process(int i,int N,boolean down){
        if(i > N){
            return;
        }
        process(i+1,N,true);
        System.out.print(down?"凹 ":"凸 ");
        process(i+1,N,false);
    }
}
