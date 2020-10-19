package arithmetic.zuo.class02;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class Code06_TwoStacksImplementQueue {

    public static class MyQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public MyQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        private void pushToPop() {
            while (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void push(Integer i) {
            stackPush.push(i);
            pushToPop();
        }

        public Integer poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }

        public Integer peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.peek();
        }


    }
}
