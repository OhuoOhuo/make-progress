package arithmetic.zuo.class04;


import static arithmetic.zuo.class01.EvenTimesOddTimes.swap;

/**
 * 堆结构
 * <p>
 * 用数组结构实现的完全二叉树
 * 大根堆：每个节点都是以该节点位顶点的子树的最大值（言下之意：不要求有序，同样的几个节点有多种组成大根堆的方法）
 * 小根堆
 */
public class Code02_Heap01 {

    public static class MyMinHeap {
        private int[] heap;
        private final int limit;
        private int heapSize;//数组中堆的节点数，heapSize-1为堆最后一个节点的下标

        public MyMinHeap(int limit) {
            this.limit = limit;
            heap = new int[limit];
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value) {
            if (isFull()) {
                throw new RuntimeException("数组大小已满");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize);
            heapSize++;
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("堆为空");
            }
            int popNum = heap[0];
            swap(heap, 0, --heapSize);
            headify(heap, 0, heapSize);
            return popNum;
        }

        private void headify(int[] arr, int index, int heapSize) {
            int left = 2 * index + 1;
            while (left < heapSize) {
                //找出左右节点最最小值
                int lastNum = 0;
                if (left + 1 < heapSize && arr[left + 1] < arr[left]) {
                    lastNum = left + 1;
                } else {
                    lastNum = left;
                }
                if (arr[lastNum] >= arr[index]) {
                    break;
                }
                swap(arr, lastNum, index);
                index = lastNum;
                left = 2 * index + 1;
            }
        }

        private void heapInsert(int[] arr, int index) {
            while (arr[index] < arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }
    }


    public static class MyMaxHeap {
        private int[] heap;
        private final int limit;
        private int heapSize;//heapSize-1 为堆的最后一个节点的下标

        public MyMaxHeap(int limit) {
            this.limit = limit;
            heap = new int[limit];
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize >= limit;
        }

        public void push(int value) {
            if (isFull()) {
                throw new RuntimeException("数组大小不够了");
            }
            //这里省略了一个变量，heapSize表示堆内节点个数，同时表示堆一下一个节点在数组中的下标数
            heap[heapSize] = value;
            heapInsert(heap, heapSize);
            heapSize++;
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("堆内没有数据了");
            }
            int popNum = heap[0];
            swap(heap, 0, heapSize - 1);
            heapSize--;

            heapify(heap, 0, heapSize);
            return popNum;
        }

        private void heapify(int[] arr, int index, int heapSize) {

            int left = 2 * index + 1;//左节点的下标
            while (left < heapSize) {//有左节点，这不能有等于，如没有左节点，则证明无下沉，无需操作
                //找到左右节点中比较大的值，右节点有可能越界；
                int laseIndex = 0;
                if (arr[left + 1] > arr[left] && left + 1 < heapSize) {//只有右节点不越界，而且右节点大于左节点时，选用右节点
                    laseIndex = left + 1;
                } else {
                    laseIndex = left;
                }
                //判断当前节点数与左右节点数中大较大值的大小,如大于无需下沉,
                if (arr[index] >= arr[laseIndex]) {
                    break;
                }
                //否则交换
                swap(arr, index, laseIndex);
                index = laseIndex;
                left = 2 * index + 1;
            }

        }


        private void heapInsert(int[] arr, int index) {
            //当没有index没有父节点是，index==0。(0-1)/2 =0.也满足，无需额外处理
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

/*        private void swap(int[] heap, int index, int i) {
            int temp = heap[index];
            heap[index] = heap[i];
            heap[i] = temp;
        }*/


    }


    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            MyMinHeap my = new MyMinHeap(curLimit);
            RightMinHeap test = new RightMinHeap(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curLimit; j++) {
/*                int curValue = (int) (Math.random() * value);
                my.push(curValue);*/
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops1!");
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("Oops2!");
                }
                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                } else if (my.isFull()) {
                    if (my.pop() != test.pop()) {
                        System.out.println("Oops3!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else {
                        if (my.pop() != test.pop()) {
                            System.out.println("Oops4!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }

    public static class RightMinHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMinHeap(int limit) {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] < arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }

    }

    public static class RightMaxHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeap(int limit) {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }

    }
}
