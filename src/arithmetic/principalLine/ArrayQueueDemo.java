package arithmetic.principalLine;

/**
 * Created by cheng on 2020/3/23.
 *
 * 队列只能用一次！！！！！
 */
public class ArrayQueueDemo {
    public static void main(String[] args){
        ArrayQueue arrayQueue = new ArrayQueue(3);
        //arrayQueue.show();
        arrayQueue.put(1);
        arrayQueue.put(2);
        arrayQueue.show();
        arrayQueue.put(3);
        arrayQueue.put(4);
        int i = arrayQueue.get();
        System.out.println(i);
        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.get());
        try {
            System.out.println(arrayQueue.get());
        }catch (Exception e){
            System.out.println("报错");
        }

        arrayQueue.put(4);



    }

    static class ArrayQueue{
        private int maxSize;
        private int head;
        private int tail;
        private int[] arr;

        public ArrayQueue(int maxSize){
            this.maxSize =maxSize;
            head =-1;
            tail =-1;
            arr = new int[maxSize];
        }

        public Boolean isEmpty(){
            return head==tail;
        }

        public Boolean isFull(){
            return tail >= maxSize-1;
        }

        public void put(int n){
            if(isFull()){
                System.out.println("队列已满");
                return;
            }
            arr[tail+1] =n;
            tail++;
        }

        public int get(){
            if(isEmpty()){
                new RuntimeException();
            }
            int lin=head+1;
            head++;
            return arr[lin];
        }

        public void show(){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (int i = 0; i < maxSize ; i++) {
                System.out.println(arr[i]);
            }
        }

    }
}
