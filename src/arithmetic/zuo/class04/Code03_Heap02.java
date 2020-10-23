package arithmetic.zuo.class04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 支持修改对象变量的堆
 * 系统提供的堆，排序完成后，修改排序属性，排序不会改变
 * 如需改变需要自己实现
 */
public class Code03_Heap02 {


    public static class MyHeap<T> {
        public ArrayList<T> heap;  //用动态数组表示堆
        public int heapSize;        //堆的大小，同时也是下一个加入的value的下标
        public HashMap<T, Integer> indexMap;  //记录每个对象，对应的下标
        public Comparator<T> comparator;     //比较器


        public MyHeap(Comparator<T> comparator) {
            this.comparator = comparator;
            this.heap = new ArrayList<>();
            this.heapSize = 0;
            this.indexMap = new HashMap<>();
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public int size() {
            return heapSize;
        }

        public void push(T value) {
            heap.add(value);
            indexMap.put(value, heapSize);
            heapInsert(heapSize++);
        }

        public void resign(T value) {
            int valueIndex = indexMap.get(value);
            heapInsert(valueIndex);
            heapify(valueIndex);
        }

        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("堆为空");
            }
            T popValue = heap.get(0);
            swap(0, --heapSize);
            heap.remove(heapSize);
            indexMap.remove(popValue);
            heapify(0);
            return popValue;
        }

        private void heapify(int index) {
            int left = 2 * index + 1;
            while (left < heapSize) {

                int lastIndex = 0;
                if (left + 1 < heapSize && comparator.compare(heap.get(left + 1), heap.get(left)) < 0) {//存在又节点，而且右节大于左节点
                    lastIndex = left + 1;
                } else {
                    lastIndex = left;
                }

                if (comparator.compare(heap.get(index), heap.get(lastIndex)) < 0) {
                    break;
                }
                swap(index, lastIndex);
                index = lastIndex;
                left = 2 * index + 1;
            }
        }

        private void heapInsert(int index) {
            while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }


        //在数组中和map中都交换位置
        private void swap(int i, int j) {
            T ti = heap.get(i);
            T tj = heap.get(j);
            heap.set(i, tj);
            heap.set(j, ti);
            indexMap.put(ti, j);
            indexMap.put(tj, i);
        }

    }


    public static class Student {
        public int classNo;
        public int age;
        public int id;

        public Student(int c, int a, int i) {
            classNo = c;
            age = a;
            id = i;
        }

    }

    public static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }

    }

    public static void main(String[] args) {
        Student s1 = null;
        Student s2 = null;
        Student s3 = null;
        Student s4 = null;
        Student s5 = null;
        Student s6 = null;

        s1 = new Student(2, 50, 11111);
        s2 = new Student(1, 60, 22222);
        s3 = new Student(6, 10, 33333);
        s4 = new Student(3, 20, 44444);
        s5 = new Student(7, 72, 55555);
        s6 = new Student(1, 14, 66666);

        PriorityQueue<Student> heap = new PriorityQueue<>(new StudentComparator());
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        heap.add(s6);
        while (!heap.isEmpty()) {
            Student cur = heap.poll();
            System.out.println(cur.classNo + "," + cur.age + "," + cur.id);
        }

        System.out.println("===============");

        MyHeap<Student> myHeap = new MyHeap<>(new StudentComparator());
        myHeap.push(s1);
        myHeap.push(s2);
        myHeap.push(s3);
        myHeap.push(s4);
        myHeap.push(s5);
        myHeap.push(s6);
        while (!myHeap.isEmpty()) {
            Student cur = myHeap.pop();
            System.out.println(cur.classNo + "," + cur.age + "," + cur.id);
        }

        System.out.println("===============");

        s1 = new Student(2, 50, 11111);
        s2 = new Student(1, 60, 22222);
        s3 = new Student(6, 10, 33333);
        s4 = new Student(3, 20, 44444);
        s5 = new Student(7, 72, 55555);
        s6 = new Student(1, 14, 66666);

        heap = new PriorityQueue<>(new StudentComparator());

        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        heap.add(s6);

        s2.age = 6;
        s4.age = 12;
        s5.age = 10;
        s6.age = 84;

        while (!heap.isEmpty()) {
            Student cur = heap.poll();
            System.out.println(cur.classNo + "," + cur.age + "," + cur.id);
        }

        System.out.println("===============");

        s1 = new Student(2, 50, 11111);
        s2 = new Student(1, 60, 22222);
        s3 = new Student(6, 10, 33333);
        s4 = new Student(3, 20, 44444);
        s5 = new Student(7, 72, 55555);
        s6 = new Student(1, 14, 66666);

        myHeap = new MyHeap<>(new StudentComparator());

        myHeap.push(s1);
        myHeap.push(s2);
        myHeap.push(s3);
        myHeap.push(s4);
        myHeap.push(s5);
        myHeap.push(s6);

        s2.age = 6;
        myHeap.resign(s2);
        s4.age = 12;
        myHeap.resign(s4);
        s5.age = 10;
        myHeap.resign(s5);
        s6.age = 84;
        myHeap.resign(s6);

        while (!myHeap.isEmpty()) {
            Student cur = myHeap.pop();
            System.out.println(cur.classNo + "," + cur.age + "," + cur.id);
        }


        // 对数器
        System.out.println("test begin");
        int maxValue = 100000;
        int pushTime = 1000000;
        int resignTime = 100;
        MyHeap<Student> test = new MyHeap<>(new StudentComparator());
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < pushTime; i++) {
            Student cur = new Student(1, (int) (Math.random() * maxValue), 1000);
            list.add(cur);
            test.push(cur);
        }
        for (int i = 0; i < resignTime; i++) {
            int index = (int) (Math.random() * pushTime);
            list.get(index).age = (int) (Math.random() * maxValue);
            test.resign(list.get(index));
        }
        int preAge = Integer.MIN_VALUE;
        while (test.isEmpty()) {
            Student cur = test.pop();
            if (cur.age < preAge) {
                System.out.println("Oops!");
            }
            preAge = cur.age;
        }
        System.out.println("test finish");


    }


}
