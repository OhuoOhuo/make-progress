package arithmetic.zuo.class12;

public class Code05_LongestCommonSubsequence {

    public static void main(String[] args) {
        //System.out.println(lcse("zabcde".toCharArray(),"acez".toCharArray()));
        String a = "zabcdef";
        String b = "acfff";
       // System.out.println(process(a.toCharArray(), b.toCharArray(), 0, 0));
        System.out.println(bp(a.toCharArray(), b.toCharArray()));
        System.out.println(lcse(a.toCharArray(),b.toCharArray()));


        System.out.println(minx(a.toCharArray(),b.toCharArray(),0,0)  +" vs "+(a.length()+b.length()-2*lcse(a.toCharArray(),b.toCharArray())));
    }

    public static int minx(char[] arr, char[] brr, int a, int b) {
        if (a == arr.length - 1) {
            for (int i = 0; i < brr.length; i++) {
                if (arr[a] == brr[i]) {
                    return brr.length - 1;
                }
            }
            return brr.length+1;
        }
        if (b == brr.length - 1) {
            for (int i = 0; i < arr.length; i++) {
                if (brr[b] == arr[i]) {
                    return arr.length - 1;
                }
            }
            return arr.length+1;
        }

        int minx1= minx(arr, brr, a + 1, b );
        int minx2 = minx(arr, brr, a, b + 1);
        int minx3 = minx(arr, brr, a + 1, b + 1);

        int max = Math.min(minx3,Math.min(minx1,minx2));

        if(arr[a] == brr[b]){
            return max;
        }
        return max+1;
    }


    private static int process(char[] arr, char[] brr, int i, int j) {

        if (i == (arr.length - 1) && j == (brr.length - 1)) {

            return arr[i] == brr[j] ? 1 : 0;
        }

        if (i == arr.length - 1) {//base case
            for (int k = 0; k < brr.length; k++) {
                if (arr[i] == brr[k]) {
                    return 1;
                }
            }
            return 0;
        }
        if (j == brr.length - 1) {//base case
            for (int k = 0; k < arr.length; k++) {
                if (brr[j] == arr[k]) {
                    return 1;
                }
            }
            return 0;
        }
        int process1 = process(arr, brr, i + 1, j);
        int process2 = process(arr, brr, i, j + 1);
        int process3 = process(arr, brr, i + 1, j + 1);

        int max = Math.max(Math.max(process1, process2), process3);
        if (arr[i] == brr[j]) {
            return Math.max(process3 + 1, max);
        }
        return max;
    }

    private static int bp(char[] arr, char[] brr) {
        int M = arr.length;
        int N = brr.length;
        int[][] bp = new int[M][N];

        bp[M - 1][N - 1] = arr[M - 1] == brr[N - 1] ? 1 : 0;

        boolean isFind =false;
        for (int m = M-2; m >= 0; m--) {
            if (isFind){
                bp[m][N-1] = 1;
            }else {
                if (brr[N-1] == arr[m]) {
                    bp[m][N-1] = 1;
                    isFind =true;
                }
            }
        }
        isFind =false;
        for (int n = N-2; n >=0; n--) {
            if(isFind){
                bp[M-1][n] = 1;
            }else {
                if (arr[M-1] == brr[n]) {
                    bp[M-1][n] = 1;
                    isFind =true;
                }
            }
        }

        for (int m = M - 2; m >= 0; m--) {
            for (int n = N - 2; n >= 0; n--) {

/*                int process1 = process(arr, brr, i + 1, j);
                int process2 = process(arr, brr, i, j + 1);
                int process3 = process(arr, brr, i + 1, j + 1);

                int max = Math.max(Math.max(process1, process2), process3);
                if (arr[i] == brr[j]) {
                    return Math.max(process3 + 1, max);
                }*/
                int process1 = bp[m + 1][n];
                int process2 = bp[m][n + 1];
                int process3 = bp[m + 1][n + 1];

                int max = Math.max(Math.max(process1, process2),process3);
                if (arr[m] == brr[n]) {
                    max = Math.max(max, process3 + 1);
                }
                bp[m][n] = max;
            }
        }
        return bp[0][0];
    }


    public static int lcse(char[] str1, char[] str2) {




        int[][] dp = new int[str1.length][str2.length];



        dp[0][0] = str1[0] == str2[0] ? 1 : 0;


        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[str1.length - 1][str2.length - 1];
    }


}
