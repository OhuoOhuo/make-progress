package arithmetic.zuo.class11;

/**
 * 抽牌问题：
 * 给定一个数组模拟一副牌，只可以从两边抽牌，所有牌可见
 * 一个人先手，一个人后手，假如两个人都绝顶聪明（明牌，先后手决定，胜负就已经决定了），两个人抽取到的牌的和的最大值。
 */
public class Code08_CardsInLine {

    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 5, 19, 29, 80, 4};
        System.out.println(getMax(arr));

        System.out.println(dpWay(arr));

    }

    /**
     *需要谨记：需要通过base case来推到出结果，并不是循环bp表就好，需要根据base case来决定bp表的填满方式
     */
    private static int dpWay(int[] arr) {

        int[][] early = new int[arr.length][arr.length];
        int[][] later = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            early[i][i] = arr[i];
        }
        /*
        int pickLeft = arr[L] + later(arr,L+1,R);
            int pickRight = arr[R] + later(arr,L,R-1);
            return Math.max(pickLeft,pickRight);
         */
        for (int i = 1; i < arr.length; i++) {
            int L =0;
            int R =i;
            while (L <arr.length && R<arr.length){
                /**
                 *             int pickLeft = arr[L] + later(arr, L + 1, R);
                 *             int pickRight = arr[R] + later(arr, L, R - 1);
                 *             return Math.max(pickLeft, pickRight);
                 */
                early[L][R] = Math.max(arr[L]+later[L+1][R],arr[R]+later[L][R-1]);
                /**
                 * return Math.min(early(arr, L + 1, R), early(arr, L, R - 1));
                 */
                later[L][R] = Math.min(early[L+1][R],early[L][R-1]);
                L++;
                R++;
            }
        }
        return Math.max(early[0][arr.length - 1], later[0][arr.length - 1]);
    }

    private static int getMax(int[] arr) {
        return Math.max(early(arr, 0, arr.length - 1), later(arr, 0, arr.length - 1));
    }

    /**
     * 在L --->R 上先手能够获取的最大值
     */
    private static int early(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        } else {
            int pickLeft = arr[L] + later(arr, L + 1, R);
            int pickRight = arr[R] + later(arr, L, R - 1);
            return Math.max(pickLeft, pickRight);
        }
    }

    /**
     * 在L-->R 上后手能够获取的最大值
     */
    private static int later(int[] arr, int L, int R) {
        if (L == R) {//只有一个数，后手拿不到
            return 0;
        } else {
            /**
             * 应为两个人都是绝顶聪明，所以，后手，对手只可能让挑选拿走一个后小的情况
             */
            return Math.min(early(arr, L + 1, R), early(arr, L, R - 1));
        }
    }


}
