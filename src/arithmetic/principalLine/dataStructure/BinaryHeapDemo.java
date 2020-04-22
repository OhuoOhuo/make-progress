package arithmetic.principalLine.dataStructure;

import java.util.Arrays;

public class BinaryHeapDemo {

    public static void main(String[] args){
        int[] arr= {1,3,2,6,5,7,8,9,10};
        //upAdjust(arr);
       // upAdjustImprove(arr);
        System.out.println(Arrays.toString(arr));

        delArrNum(arr,0);
        //downAdjust(arr,0);
        System.out.println(Arrays.toString(arr));
    }

    private static void delArrNum(int[] arr, int i) {
        int temp;
        temp = arr[i];
        arr[i] = arr[arr.length -1];
        arr[arr.length -1] = temp;
        downAdjust(arr,i,arr.length-1);
    }

    public static void buildHeap(int[] arr){
        for (int i = (arr.length -2)/2; i >=0 ; i--) {
            downAdjust(arr,i,arr.length);
        }
    }

    /**
     * 下沉调整，改进版
     */
    private static void downAdjustImprove(int[] arr,int downIndex,int length) {
        int temp = arr[downIndex];
        int childIndex = 2* downIndex +1;
        while (childIndex <length){
            if(childIndex +1 <length &&arr[childIndex+1] <arr[childIndex]){
                childIndex++;
            }
            if(temp <= arr[childIndex]){
                break;
            }
            arr[downIndex] = arr[childIndex];
            downIndex =childIndex;
            childIndex = 2*downIndex +1;
        }
        arr[downIndex] =temp;
    }


    /**
     * 下沉调整，（删除调整）
     * @param arr
     */
    private static void downAdjust(int[] arr,int downIndex,int length) {
        int temp ;
        while (downIndex < length){
            int childIndex = 2*downIndex +1;
            //判断要删除节点的子节点到底取左还是又右
            if(childIndex +1 <length && arr[childIndex+1] < arr[childIndex]){
                childIndex ++;
            }

            if(childIndex >length || arr[downIndex] < arr[childIndex]){
                break;
            }
            //交换
            temp = arr[downIndex];
            arr[downIndex] = arr[childIndex];
            arr[childIndex] =temp;

            downIndex = childIndex;
        }

    }


    /**
     * 上调改版，不用每次都交换，只是覆盖
     * @param arr
     */
    private static void upAdjustImprove(int[] arr) {
        int childIndex=arr.length -1;
        int parentIndex = (childIndex-1)/2;
        int startNum = arr[childIndex];

        while (childIndex >0 && startNum <arr[parentIndex]){
            arr[childIndex] =arr[parentIndex];
            childIndex =parentIndex;
            parentIndex = (parentIndex-1)/2;
        }
        arr[childIndex] =startNum;
    }

    /**
     * 原始版本实现，每次和父节点比较，满足条件都交换
     * @param arr
     */
    private static void upAdjust(int[] arr) {
        int startIndex = arr.length -1;
        //int startNum = arr[startIndex];
        int temp ;
        while (startIndex>0&&arr[startIndex] < arr[(startIndex-1)/2]){
            temp =arr[(startIndex-1)/2];
            arr[(startIndex-1)/2]= arr[startIndex];
            arr[startIndex] =temp;
            startIndex = (startIndex-1)/2;
        }
    }




}
