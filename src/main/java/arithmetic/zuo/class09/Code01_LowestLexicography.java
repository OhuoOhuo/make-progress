package arithmetic.zuo.class09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 给定一个字符串数组
 * 确定如何排序把数组连接成一个字符串，从而使该字符串的字典序最小
 */
public class Code01_LowestLexicography {

    // for test
    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 5);
            ans[i] = (Math.random() <= 0.5) ? (char) (65 + value) : (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    // for test
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }

    // for test
    public static String[] copyStringArray(String[] arr) {
        String[] ans = new String[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = String.valueOf(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arrLen = 6;
        int strLen = 5;
        int testTimes = 100000;
        String[] arr = generateRandomStringArray(arrLen, strLen);
        System.out.println("先打印一个生成的字符串");
        for (String str : arr) {
            System.out.print(str + ",");
        }
        System.out.println();
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String[] arr1 = generateRandomStringArray(arrLen, strLen);
            String[] arr2 = copyStringArray(arr1);
            if (!lowestString1(arr1).equals(lowestString2(arr2))) {
                for (String str : arr1) {
                    System.out.print(str + ",");
                }
                System.out.println();
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    private static String lowestString2(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String str ="";
        for (int i = 0; i <arr.length ; i++) {
            str =str+arr[i];
        }
        return str;
    }

    /**
     * 暴力方法，列举出所有可能
     */
    private static String lowestString1(String[] arr1) {
        if (arr1 == null || arr1.length == 0) {
            return "";
        }
        ArrayList<String> all = new ArrayList<>();
        HashSet<Integer> use = new HashSet<>();
        process(arr1, use, "", all);

        String lowest = all.get(0);
        for (int i = 1; i < all.size(); i++) {
            if (all.get(i).compareTo(lowest) < 0) {
                lowest = all.get(i);
            }
        }
        return lowest;
    }

    /**
     * @param arr1 原数组
     * @param use  已经使用的下标
     * @param path 拼接的字符串
     * @param all  所有完整拼接情况
     */
    private static void process(String[] arr1, HashSet<Integer> use, String path, ArrayList<String> all) {
        if (use.size() == arr1.length) {//当次已经拼接完成
            all.add(path);
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (!use.contains(i)) {
                    use.add(i);
                    process(arr1, use, path + arr1[i], all);
                    use.remove(i);
                }
            }
        }
    }
}
