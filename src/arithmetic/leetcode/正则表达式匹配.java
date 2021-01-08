package arithmetic.leetcode;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * <p>
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 * <p>
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 * <p>
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class 正则表达式匹配 {

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s, p));
    }

    private static Boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        if ("".equals(s) && "".equals(p)) {
            return true;
        }
        if (s == null || "".equals(s)) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        int i = sChars.length - 1;
        int j = pChars.length - 1;

        while (i >= 0 && j >= 0) {
            if (sChars[i] == pChars[j]) {
                i--;
                j--;
                continue;
            }
            if (pChars[j] == '.') {
                i--;
                j--;
                continue;
            }
            if (pChars[j] == '*') {
                if (pChars[j - 1] == '.') {
                    for (int k = 0; k < j - 1; k++) {
                        if (sChars[k] != pChars[k]) {
                            return false;
                        }
                    }
                    return true;
                } else if (pChars[j - 1] == sChars[i]) {
                    while (i >= 0 && pChars[j - 1] == sChars[i]) {
                        i--;
                    }
                    j = j - 2;
                    continue;
                } else { //pChars[j-1] == sChars[i]
                    j = j - 2;
                    continue;
                }
            }

            return false;
        }
        if (j >= 0 && pChars[j] == '*') {

/*            if (pChars[j - 1] != sChars[0]) {
                return false;
            }*/
            j = j - 2;
            while (j >= 0 && pChars[j] == sChars[0]) {
                j--;
            }
        }


        return j == i ? true : false;
    }
}
