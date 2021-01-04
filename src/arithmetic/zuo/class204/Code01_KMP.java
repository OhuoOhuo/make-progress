package arithmetic.zuo.class204;

/**
 * 用于计算字符串匹配，
 * 暴力方法 n*m
 * kmp 可以做到 n
 */
public class Code01_KMP {

    public static int getIndexOf(String s, String m) {
        //去除几点数据
        if (s == null || m == null || s.length() < 1 || m.length() < 1) {
            return -1;
        }
        char[] str = s.toCharArray();
        char[] match = m.toCharArray();

        int[] next = getNextArray(match); // next[i]  match中i之前的字符串match[0..i-1]

        int x = 0; //str比较的位置 ，在下面的整个循环中，只增不减
        int y = 0; //match 比较的位置,在下面的整个循环中，会来回跳动

        while (x < str.length && y < match.length) {
            if (str[x] == match[y]) {//如果相等，同时移动，
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }

        return y == m.length() ? x - y : -1;//跳出循环后判断y值是否撸到最后，没有证明，不包含
    }

    /**
     * 给定的字符串，求next[i]  match中i之前的字符串match[0..i-1]
     * @param match
     * @return
     */
    private static int[] getNextArray(char[] match) {
        if (match.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i =2;

        int cn =0;
        while (i<match.length){
            if(match[i-1] == match[cn]){
                next[i++] = ++cn;
            }else if(cn >0){
                cn =next[cn];
            }else {
                next[i++]=0;
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
            if (getIndexOf(str, match) != str.indexOf(match)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }

}
