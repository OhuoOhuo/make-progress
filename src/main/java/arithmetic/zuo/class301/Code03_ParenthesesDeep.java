package arithmetic.zuo.class301;

/*
  括号问题3：给定有效括号串， 最大括号深度

  括号问题4：给定不一定有效的括号串，最长有效括号长度
 *
 */
public class Code03_ParenthesesDeep {

    public static int deep(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int ans = 0;
        int count = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
                ans = Math.max(ans, count);
            } else {
                count--;
            }
        }
        return ans;
    }


    public static int maxLength(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int ans = 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(') {
                continue;
            } else {
                int temp = 0;
                int pre = i - 1 - dp[i - 1];
                if (pre >= 0 && chars[pre] == '(') {
                    temp = dp[i - 1] + 2 + (pre - 1 >= 0 ? dp[pre - 1] : 0);
                }
                dp[i] =temp;
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxLength("(((((())))()()()))))"));
        System.out.println(maxLength1("(((((())))()()()))))"));
    }

    public static int maxLength1(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        int pre = 0;
        int ans = 0;
        // dp[0] = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ')') {
                pre = i - dp[i - 1] - 1; // 与str[i]配对的左括号的位置 pre
                if (pre >= 0 && str[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
