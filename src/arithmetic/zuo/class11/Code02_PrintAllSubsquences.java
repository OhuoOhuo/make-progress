package arithmetic.zuo.class11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 子串 和 子序列：
 * abc：
 * 子串：“”（空串），"a", "b", "c", "ab", "bc", "abc"，共7个
 * 子序列：""（空串），"a", "b", "c", "ab", "ac"！！！！, "bc", "abc" 共8个
 */
public class Code02_PrintAllSubsquences {

    public static void main(String[] args) {
        String test = "aacc";
        List<String> ans1 = subs(test);
        List<String> ans2 = subsNoRepeat(test);

        for (String str : ans1) {
            System.out.println(str);
        }
        System.out.println("=================");
        for (String str : ans2) {
            System.out.println(str);
        }
        System.out.println("=================");

    }


    //获取全部子序列
    private static List<String> subs(String str) {
        char[] chars = str.toCharArray();

        List<String> ans = new ArrayList<>();
        process(chars, 0, "", ans);
        return ans;
    }

    private static void process(char[] chars, int i, String path, List<String> ans) {
        if (i == chars.length) {
            ans.add(path);
            return;
        } else {
            //要当前下标的值，再进行后续
            String yesPath = path + chars[i];
            process(chars, i + 1, yesPath, ans);
            //不要当前下标的值，再进行后续
            String noPath = path;
            process(chars, i + 1, noPath, ans);
        }
    }

    private static List<String> subsNoRepeat(String str) {

        char[] chars = str.toCharArray();

        HashSet<String> set = new HashSet<>();

        process1(chars,0,"",set);

        ArrayList<String> strings = new ArrayList<>();
        for (String path: set) {
            strings.add(path);
        }

        return strings;
    }

    private static void process1(char[] chars, int i, String path, HashSet<String> set) {
        if(i ==chars.length){
            set.add(path);
            return;
        }else {
            process1(chars,i+1,path,set);
            process1(chars,i+1,path+chars[i],set);
        }
    }


}
