package arithmetic.sword;

public class RecursionDemo1 {

    /**
     * 斐波那契数列：1,1,2,3,5,8........ 总结起来就是：第一项是1，第二项是1，后续第n项为第n-1项和第n-2项之和
     *
     *  一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     *
     * 第一步可以跳一格，后续即为f(n-1)
     * 第一步可以跳两格，后续即为f(n-2)
     * 类似斐波那契的算法
     *
     *
     * 我们可以用2 X 1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2 X 1的小矩形无重叠地覆盖一个2 X n的大矩形，总共有多少种方法？
     * f(1) =1
     * f(2) =2
     * 后续为斐波那契数列：
     *有两种选择：横着放或者竖着放。当竖着放时，右边还剩下2X7的区域。很明显这种情况下覆盖方法为f(7)。当横着放时，1X2的矩形放在左上角，
     * 其下方区域只能也横着放一个矩形，此时右边区域值剩下2X6的区域，这种情况下覆盖方法为f(6)。所以可以得到：f(8)=f(7)+f(6)，不难看出这仍然是斐波那契数列。
     *
     */


    public static void main(String[] args){

        System.out.println(Fibonacci(7));

    }

    public static int Fibonacci(int n){
        if(n <= 0){
            return -1;
        }
        if(n ==1 && n ==2){
            return 1;
        }
        // return  Fibonacci(n-2)+Fibonacci(n-1)
        int res =0; int frist =1;int sec = 1;
        for (int i = 3; i <= n; i++) {
            res =frist+sec;
            frist =sec;
            sec =res;
        }
        return  res;
    }


}
