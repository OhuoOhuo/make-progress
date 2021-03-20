package arithmetic.zuo.class301;

/**
 * 括号问题
 * 1.给定一个只包含括号的字符串（也可有其它字符，数据处理即可），判断是否是有效括号
 * 2.给定无效的的只包含括号的字符串，问至少添加几个可以是它有效
 */
public class Code02_NeedParentheses {


    public static boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return Boolean.FALSE;
        }
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return Boolean.FALSE;
            }
        }
        return count == 0;
    }


    public static int needParentheses(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int count = 0;
        int need = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                if (count == 0) {
                    need++;
                } else {
                    count--;
                }
            }
        }
        return count + need;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()((()))"));
        System.out.println(needParentheses("((((()()))))(()))"));
    }


}
