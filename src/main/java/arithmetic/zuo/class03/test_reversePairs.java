package arithmetic.zuo.class03;

public class test_reversePairs {

    public static void main(String[] args) {
        int[] arr= {2,4,3,5,1};
        System.out.println(reversePairs(arr));

    }

    public static int reversePairs(int[] nums) {
        if(nums==null || nums.length < 2){
            return 0;
        }
        return process(nums,0,nums.length -1);
    }


    public static int process(int[] nums,int L,int R){
        if(L >= R){
            return 0;
        }
        int mid = (R+L)/2;
        //return process(nums,L,mid)+process(nums,mid+1,R) +merge(nums,L,R,mid);
        int process1 = process(nums, L, mid);
        int process = process(nums, mid + 1, R);
        int merge = merge(nums, L, R, mid);
        int sum = process1+process+merge;
        return sum;
    }

    public static int merge(int[] nums,int L,int R,int mid){
        int[] help =new int[R-L+1];
        int sum =0;
        int i = 0;
        int p1 = L;
        int p2 = mid+1;

        while(p1 <=mid && p2 <= R){
            if(nums[p1] > nums[p2]){
                sum = sum + (mid-p1+1);
                help[i++] = nums[p2++];
            }else{
                help[i++] = nums[p1++];
            }
        }

        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }
        while (p2 <= R) {
            help[i++] = nums[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[L+j] = help[j];
        }
        return sum;
    }
}
