package arithmetic.principalLine;

import java.util.Arrays;

public class sortDemo {

    public static void main(String[] args){
        int[] arr= {65,58,95,10,57,62,13,106,78,23,85};
      // bobSort(arr);

        //insertSort(arr);
       // System.out.println("排序前："+ Arrays.toString(arr));

        quickSort(arr,0,arr.length-1);
        System.out.println("排序前："+ Arrays.toString(arr));
    }



    public static void insertSort(int[] arrs){

        for (int i = 1; i < arrs.length; i++) {
            int temp =0;
            int index=i;
           while (arrs[index]<arrs[index-1]){
                temp = arrs[index-1] ;
                arrs[index-1] =arrs[index];
                arrs[index] = temp;
                index--;
                if(index ==0){
                    break;
                }
            }
        }
    }

    public static void choiceSort(int[] arrs){


        for (int i = 0; i < arrs.length; i++) {

            int min = arrs[i];
            int index = i;

            for (int j = i+1; j < arrs.length; j++) {
                if(min> arrs[j]){
                    min = arrs[j];
                    index =j;
                }

            }

            arrs[index] = arrs[i];
            arrs[i] = min;

        }

    }


    public static void bobSort(int[] arrs){

        boolean flag =true;
        for (int i = 0; i < arrs.length; i++) {
            int k;
            for (int j = i+1; j < arrs.length; j++) {
                if(arrs[i] >arrs[j]){
                    k= arrs[j];
                    arrs[j] = arrs[i];
                    arrs[i] = k;
                    flag =false;
                }
            }
            if(flag){
                break;
            }
        }

    }







    public static void quickSort(int[] arrs,int left,int right){
        if(arrs ==null || arrs.length ==1){
            return;
        }
        if(left <right){
            int mid = partition2(arrs, left, right);
            quickSort(arrs,left,mid-1);
            quickSort(arrs,mid+1,right);
        }
    }


    public static int partition(int[] arrs,int left,int right){
        int mid =arrs[left];
        while (left<right){
            while (left <right &&arrs[right] > mid){
                right --;
            }
            arrs[left] = arrs[right];
            while (left< right &&arrs[left] <mid){
                left ++;
            }
            arrs[right] = arrs[left];
        }
        arrs[left]=mid;
        return left;

    }

    private static int partition2(int[] arrs,int left,int right){

        int index =left;
        int start = arrs[left] ;

        for (int i = left+1; i <=right; i++) {
            if(start >arrs[i]){
                index++;
                int p = arrs[i];
                arrs[i] =arrs[index];
                arrs[index] = p;

            }

        }
        arrs[left]= arrs[index];

        arrs[index] = start;


        return index;
    }

    private static int partition3(int[] arr, int startIndex,
                                 int endIndex) {
         // 取第1个位置（ 也可以选择随机位置） 的元素作为基准元素
         int pivot = arr[startIndex];
         int mark = startIndex;

         for(int i=startIndex+1; i<=endIndex; i++){
             if(arr[i]<pivot){
                 mark ++;
                 int p = arr[mark];
                 arr[mark] = arr[i];
                 arr[i] = p;
                 }
             }

         arr[startIndex] = arr[mark];
         arr[mark] = pivot;
         return mark;
         }

}
