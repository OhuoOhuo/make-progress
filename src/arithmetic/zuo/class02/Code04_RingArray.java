package arithmetic.zuo.class02;

/**
 * 数组实现队列
 */
public class Code04_RingArray {

    public static class MyQueue {
        private int[] arr;
        private int size;
        private int pushi;
        private int polli;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            size = 0;
            pushi = 0;
            polli = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列已满");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("队列无数据");
            }
            size--;
            int value = arr[polli];
            polli = nextIndex(polli);
            return value;
        }

        //获取下一个坐标，可循环使用
        private int nextIndex(int pushi) {
            return pushi < limit - 1 ? pushi + 1 : 0;
        }


    }
}
