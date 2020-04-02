package arithmetic.sword;

public class ArrayDemo2 {

    public static void main(String[] args){

        int[] arr= {5,6,8,9,11,15,1,2,4,5};

        System.out.println(findMin(arr));

    }

    private static int findMin(int[] arr) {

        if(arr ==null || arr.length ==0 ){
            return -1;
        }

        int low =0;
        int hig = arr.length-1;

        if(arr[low] <arr[hig]){
            return arr[low];
        }

        while (low < hig){
            int mid = low + (low +hig)/2;

            if(arr[mid]<arr[low]){
                low = mid;
            }

            if(arr[mid] <arr[hig]){
                hig =mid;
            }
        }


        return -1;
    }


}
