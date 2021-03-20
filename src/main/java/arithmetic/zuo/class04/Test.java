package arithmetic.zuo.class04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {

        Integer[] arr = {5, 4, 3, 2, 7, 9, 1, 0};

        Arrays.sort(arr, new NormalCom());
        //Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        NormalCom normalCom = new NormalCom();
        System.out.println(normalCom.compare(2, 3));

        Arrays.sort(arr,new TCom());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        TCom tCom = new TCom();
        System.out.println(tCom.compare(2,3));


    }

    public static class TCom implements  Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }


    public static class NormalCom implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 -o2;
        }
    }
}
