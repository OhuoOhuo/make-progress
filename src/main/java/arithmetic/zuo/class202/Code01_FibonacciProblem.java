package arithmetic.zuo.class202;


/**
 * 1 1 2 3 5 8 13 21
 */
public class Code01_FibonacciProblem {

    private static int f(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return f(n - 2) + f(n - 1);
    }

    private static int f2(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        int one = 1;
        int two = 1;
        int cur = 0;

        int temp = 0;
        for (int i = 3; i <= n; i++) {
            cur = one + two;
            temp = one;
            one  = cur;
            two = temp;
        }

        return cur;
    }

    private static int f3(int n){
        return 1;
    }


    public static void main(String[] args) {
        System.out.println(f(6));
        System.out.println(f2(6));
    }
}
