package arithmetic.zuo.class11;

import java.util.Stack;



/**
 * 反转栈，不用额外空间
 *
 * 用额外空间，加个队列，在倒回去就ok
 *
 */
public class Code04_ReverseStackUsingRecursive {

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

    }

    private static void reverse(Stack<Integer> test) {
        if(test==null||test.isEmpty()){
            return;
        }
        int lastNum = getLastNum(test);
        reverse(test);
        test.push(lastNum);
    }

    /**
     *在不改变顺序的情况下，弹出栈最底部的数
     */
    private static int getLastNum(Stack<Integer> stack){
        Integer pop = stack.pop();
        if(stack.isEmpty()){
            return pop;
        }else {
            int lastNum = getLastNum(stack);
            stack.push(pop);
            return lastNum;
        }
    }
}
