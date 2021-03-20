package arithmetic.zuo.class04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * java 对数器：比较两个对象大小的依据
 * 基于比较的排序比较对象时一定需要，这也是基于比较的排序更通用的原因
 *
 *
 */
public class Code01_Comparator {

    public static class Student  {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return "name=" + name + ", id=" + id +", age=" + age +"      ";
        }
    }

    public static class reserveCom implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static class AgeCom implements Comparator<Student>{


        @Override
        public int compare(Student o1, Student o2) {
            return o1.age-o2.age;
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 7, 9, 1, 0};

        Arrays.sort(arr, new reserveCom());
        //Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("===========================");

        Student student1 = new Student("A", 2, 20);
        Student student2 = new Student("B", 3, 21);
        Student student3 = new Student("C", 1, 22);

        Student[] students = new Student[]{student1, student2, student3};
        System.out.println("第一条打印");

        Arrays.sort(students,new AgeCom());
        printStudents(students);

        /**
         * 可以给系统默认的结构，传递比较器，从而改变排序
         */
        System.out.println("===============================");
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new AgeCom());//默认小根堆
        priorityQueue.add(student1);
        priorityQueue.add(student2);
        priorityQueue.add(student3);

        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        while (!priorityQueue.isEmpty()){
            studentArrayList.add(priorityQueue.poll());
        }
        System.out.println(studentArrayList);


    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
    }
}
