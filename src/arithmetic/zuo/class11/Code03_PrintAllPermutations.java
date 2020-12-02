package arithmetic.zuo.class11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 获取字符串的全排列
 */
public class Code03_PrintAllPermutations {

    public static void main(String[] args) {
        String s = "aac";
        List<String> ans1 = permutation(s);
        for (String str : ans1) {
            System.out.println(str);
        }
        System.out.println("=======");
        List<String> ans2 = permutationNoRepeat(s);
        for (String str : ans2) {
            System.out.println(str);
        }

    }


    /**
     * 全排列
     *
     * @param str
     * @return
     */
    private static List<String> permutation(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] chars = str.toCharArray();
        ArrayList<String> strings = new ArrayList<>();
        process(chars, 0, strings);
        return strings;
    }

    private static void process(char[] chars, int i, List<String> ans) {
        if (i == chars.length) {
            ans.add(String.valueOf(chars));
            return;
        } else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                process(chars, i + 1, ans);
                swap(chars, j, i);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


    /**
     * 全排列去重：
     * 1.暴力方法：放到一个set里，去重转换为list
     * 2.剪切分支
     */
    private static List<String> permutationNoRepeat(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        char[] chars = str.toCharArray();
        List<String> list = new ArrayList<>();

        process1(chars, 0, list);

        return list;
    }

    private static void process1(char[] chars, int i, List<String> ans) {
        if (i == chars.length) {
            ans.add(String.valueOf(chars));
            return;
        } else {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (!set.contains(chars[j])) {
                    set.add(chars[j]);
                    swap(chars, i, j);
                    process1(chars, i + 1, ans);
                    swap(chars, i, j);
                }
            }
        }
    }


}
