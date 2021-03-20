package arithmetic.zuo.class302;

public class test {
    public static void main(String[] args) {
        System.out.println(reversalNum(-1203));

        System.out.println(isPalindromeNum(0));
    }

    public static int reversalNum(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            //处理越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            res = res * 10 + temp;
        }
        return res;
    }

    public static boolean isPalindromeNum(int x) {
        if (x < 0 || (x % 10 ==0 && x!=0)) {
            return false;
        }
        int ans = 0;
        int temp = 0;
        while (x > ans) {
            temp = x % 10;
            x = x / 10;
            ans = ans * 10 + temp;
        }
        return (x == ans)||(x ==ans /10);
    }

    public static int changeToInt(String str) {
        char[] chars = str.toCharArray();

        int start = 0;
        int end = 0;
        int res = 0;
        boolean isFu = Boolean.FALSE;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == ' ') {
                start++;
                end++;
                continue;
            }

            if (chars[i] == '-') {
                if (isFu) {
                    return res;
                }
                isFu = Boolean.TRUE;
                start++;
                end++;
            }

            if (chars[i] == '0') {

            }


        }

        return res;


    }
}
