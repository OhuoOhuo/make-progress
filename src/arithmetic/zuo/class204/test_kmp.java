package arithmetic.zuo.class204;

public class test_kmp {

    public static int kmp(String str, String match) {
        if (str == null || match == null || str.length() == 0 || match.length() == 0) {
            return -1;
        }
        char[] strArr = str.toCharArray();
        char[] matchArr = match.toCharArray();
        int[] next = getNextArray(matchArr);
        int i = 0;
        int j = 0;
        while (i < strArr.length && j < matchArr.length) {
            if (strArr[i] == matchArr[j]) {
                i++;
                j++;
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == matchArr.length ? i - j : -1;
    }


    private static int[] getNextArray(char[] matchArr) {
        if (matchArr.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[matchArr.length];
        next[0] = -1;
        next[1] = 0;

        int i=2;
        int cn=0;
        while (i<matchArr.length){
            if(matchArr[i-1] == matchArr[cn]){
                next[i++] = ++cn;
            }else if(cn >0){
                cn = next[cn];
            }else {
                next[i++] =0;
            }
        }

        return next;
    }

    // for test
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        int possibilities = 5;
        int strSize = 20;
        int matchSize = 5;
        int testTimes = 5000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            String match = getRandomString(possibilities, matchSize);
            if (kmp(str, match) != str.indexOf(match)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }
}
