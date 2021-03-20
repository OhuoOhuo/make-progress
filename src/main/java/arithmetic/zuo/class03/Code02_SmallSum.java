package arithmetic.zuo.class03;

/**
 * 数组的小和问题
 * <p>
 * 一个数组中，一个数左边所有比它小的数的和，叫做这个数的小和，数组中所有数的小和累加起来，叫做数组小和
 * <p>
 * ex：
 * 【1,3,4,2,5】
 * 1的小和 没有
 * 3的小和 1
 * 4的小和 1,3
 * 2的小和 1
 * 5的小和 1,3,4,2
 * 数组小和：1+1+3+1+1+3+4+2
 */
public class Code02_SmallSum {
    //[1,3,4,2,5]  数组小和，可以转换为，所有在1的右边比1 大的数的个数，加上3的右边比3 大的个数 ，加上4的右边比4大的个数。。。。。1*4+3*2+4*1+2*1
    //可以借助归并排序的merge过程，merge过程的本质即为，把比较过的记录下来，减少了比较次数，这也比冒泡这类排序快的原因

    public static void main(String[] args) {
        int[] arr = {1, 3,3, 4, 2, 5};//1*5+3*2+3*2 +4*1+2*1 =23
        int sum = smallSum(arr);
        System.out.println(sum);
    }

    private static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int sum = 0;
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            //注意相等情况，归并排序对于相等情况靠那边都可以，小和问题需要严格限定。类似的有降序对问题（改变sum的算法即可）
            if(arr[p1] <arr[p2]){
                sum = sum + arr[p1]*(r-p2+1);
                help[i++] = arr[p1++];
            }else{
                help[i++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l+j] = help[j];
        }
        return sum;
    }


}
