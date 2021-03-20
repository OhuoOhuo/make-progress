package arithmetic.zuo.class02;

import java.util.Stack;

/**
 * 获取栈中的最小值
 *
 * 两个栈实现
 */
public class Code05_GetMinStack {

    public static class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(Integer data) {
            if (stackMin.isEmpty()) {
                stackMin.push(data);
            } else if (data <= getMin()) {
                stackMin.push(data);
            }
            stackData.push(data);
        }

        public Integer pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }

            Integer pop = stackData.pop();
            if (pop == getMin()) {
                stackMin.pop();
            }
            return pop;
        }

        public Integer getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return stackMin.peek();
        }

    }
}
