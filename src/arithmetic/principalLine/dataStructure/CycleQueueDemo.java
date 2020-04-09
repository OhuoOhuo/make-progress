package arithmetic.principalLine.dataStructure;
/**
 * Created by cheng on 2020/3/23.
 */
public class CycleQueueDemo {


    public static void main(String[] args){

        CycleQueue cycleQueue = new CycleQueue(5);
        cycleQueue.put(1);
        cycleQueue.put(2);
        cycleQueue.put(3);
        cycleQueue.put(4);
        cycleQueue.show();

        cycleQueue.get();
        cycleQueue.put(5);
        cycleQueue.get();
        cycleQueue.show();
        cycleQueue.headQueue();
        cycleQueue.tearQueue();

        cycleQueue.put(8);

        cycleQueue.show();
        cycleQueue.headQueue();
        cycleQueue.tearQueue();





    }

    static class CycleQueue{
        private int maxSize;
        private int front;
        private int tear;
        private int[] arr;

        public CycleQueue(int maxSize){
            this.maxSize =maxSize;
            this.front = 0;
            this.tear = 0;
            arr = new int[maxSize];
        }

        public Boolean isEmpty(){
            return tear==front;
        }

        public Boolean isFull(){
            return (tear+1)%maxSize ==front;
        }

        public void put(int n){
            if(isFull()){
                System.out.println("????");
                return;
            }
            arr[tear] =n;
            tear =(tear+1) % maxSize;
        }

        public int get(){
            if(isEmpty()){
                new RuntimeException();
            }
            int temp = front;
            front = (front+1)%maxSize;
            return arr[temp];
        }

        public int size(){
            if(isEmpty()){
                return 0;
            }
            return (tear + maxSize -front)% maxSize;
        }

        public void show(){
            if(isEmpty()){
                System.out.println("????");
                return;
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (int i = front; i < front+size() ; i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }

        // ??????§Ö??????? ????????????
        public int headQueue() {
            // ?§Ø?
            if (isEmpty()) {
                throw new RuntimeException("???§á??????????~~");
            }
            System.out.println("??????"+ front +"~~~~~~~~~~~~~~~~~~~"+arr[front]);

            return arr[front];
        }

        // ??????§Ö??????? ????????????
        public int tearQueue() {
            // ?§Ø?
            if (isEmpty()) {
                throw new RuntimeException("???§á??????????~~");
            }
            System.out.println("¦Â?????"+ tear +"~~~~~~~~~~~~~~~~~~~"+arr[tear]);
            return arr[tear];
        }



    }


}
