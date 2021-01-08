package arithmetic.practice;

public class MyHeap {

    int[] heap;
    int limitSize;
    int heapSize;//表示heap的现有个数，同时也可以表示下一个个插入的下标

    public MyHeap(int limitSize) {
        heap = new int[limitSize];
        this.limitSize = limitSize;
        heapSize = 0;
    }

    public Boolean isFull() {
        return heapSize == limitSize;
    }

    public Boolean isEmpty() {
        return heapSize == 0;
    }

    public void insert(int val) {
        if (isFull()) {
            throw new RuntimeException("已满");
        }
        heap[heapSize] = val;
        heapInsert(heap, heapSize);
        heapSize++;
    }


    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("已满");
        }
        int res = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return res;
    }

    private void heapify(int[] heap, int index, int heapSize) {
        int left = 2 * index + 1;

        while (left < heapSize) { // 有左节点，不代表有右节点。
            //左右节点中较大的节点
            int temp = 0;
            if (left + 1 < heapSize && heap[left + 1] > heap[left]) {
                temp = left + 1;
            } else {
                temp = left;
            }

            if (heap[temp] <= heap[index]) {
                break;
            }
            swap(heap, temp, index);
            index = temp;
            left = 2 * index + 1;
        }
    }

    private void heapInsert(int[] heap, int index) {
        while (heap[(index - 1) / 2] < heap[index]) {
            swap(heap, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    private void swap(int[] heap, int far, int heapSize) {
        int temp = heap[far];
        heap[far] = heap[heapSize];
        heap[heapSize] = temp;
    }


}
