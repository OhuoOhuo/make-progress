package arithmetic.zuo.class205;

/**
 * 用于回文字符的计算
 * 暴力方法（中心扩散） n * m
 * manacher算法 n
 */
public class Manacher {
    private static char[] getManacherChar(char[] strChar) {
        char[] res = new char[2 * strChar.length + 1];
        int j = 0;
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = '#';
            } else {
                res[i] = strChar[j];
                j++;
            }
        }
        return res;
    }
    public static String mancher1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        char[] str = getManacherChar(s.toCharArray());
        int[] pArr = new int[str.length];//存放每个点的直径
        int C = -1;//扩为最大时中心
        int R = -1;//扩为最大时最最右边界
        int maxValue = 0;
        for (int i = 0; i < str.length; i++) {
            if (i > R) {//当i在R外，暴力扩散
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < str.length && str[left] == str[right]) {
                    left--;
                    right++;
                }
                if (maxValue < (right - left - 1)) {
                    R = right - 1;
                    C = i;
                    maxValue = right - left - 1;
                }
                pArr[i] = (right - left) / 2 == 0 ? 1 : (right - left) / 2;
            } else {//当i在R内部。
                //i关于C 的对称点
                int j = 2 * C - i;
                if (j - pArr[j] > C - pArr[C]) {
                    pArr[i] = pArr[j];
                } else if (j - pArr[j] < C - pArr[C]) {
                    pArr[i] = pArr[R - i];
                } else {
                    int left = 2 * i - R - 1;
                    int right = R + 1;
                    while (left >= 0 && right < str.length && str[left] == str[right]) {
                        left--;
                        right++;
                    }
                    if (maxValue < (right - 1 - i) * 2 + 1) {
                        R = right - 1;
                        C = i;
                        maxValue = (right - 1 - i) * 2 + 1;
                    }
                    pArr[i] = (right - left) / 2 == 0 ? 1 : (right - left) / 2;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 2 * C - R; i < R; i++) {
            if('#'!=str[i]){
                stringBuffer.append(str[i]);
            }
        }
        return stringBuffer.toString();
    }


    public static int mancher(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] str = getManacherChar(s.toCharArray());
        int[] pArr = new int[str.length];//存放每个点的直径
        int C = -1;//扩为最大时中心
        int R = -1;//扩为最大时最最右边界
        int maxValue = 0;
        for (int i = 0; i < str.length; i++) {
            if (i > R) {//当i在R外，暴力扩散
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < str.length && str[left] == str[right]) {
                    left--;
                    right++;
                }
                if (maxValue < (right - left - 1)) {
                    R = right - 1;
                    C = i;
                    maxValue = right - left - 1;
                }
                pArr[i] = (right - left) / 2 == 0 ? 1 : (right - left) / 2;
            } else {//当i在R内部。
                //i关于C 的对称点
                int j = 2 * C - i;
                if (j - pArr[j] > C - pArr[C]) {
                    pArr[i] = pArr[j];
                } else if (j - pArr[j] < C - pArr[C]) {
                    pArr[i] = pArr[R - i];
                } else {
                    int left = 2 * i - R - 1;
                    int right = R + 1;
                    while (left >= 0 && right < str.length && str[left] == str[right]) {
                        left--;
                        right++;
                    }
                    if (maxValue < (right - 1 - i) * 2 + 1) {
                        R = right - 1;
                        C = i;
                        maxValue = (right - 1 - i) * 2 + 1;
                    }
                    pArr[i] = (right - left) / 2 == 0 ? 1 : (right - left) / 2;
                }
            }
        }

        return maxValue / 2;
    }


    public static String violenceMethod(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        char[] strChar = s.toCharArray();
        char[] manacherChar = getManacherChar(strChar);
        int maxValue = 0;
        int frist = 0;
        int seconed = 0;
        for (int i = 0; i < manacherChar.length; i++) {
            int pre = i - 1;
            int next = i + 1;
            while (pre >= 0 && next < manacherChar.length && manacherChar[pre] == manacherChar[next]) {
                pre--;
                next++;
            }
            if (next - pre - 1 > maxValue) {
                maxValue = next - pre - 1;
                frist = pre + 1;
                seconed = next - 1;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = frist; i <= seconed; i++) {
            if (manacherChar[i] != '#') {
                stringBuffer.append(manacherChar[i]);
            }
        }
        return stringBuffer.toString();
    }



    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    // for test
    public static int right(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s);
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            int L = i - 1;
            int R = i + 1;
            while (L >= 0 && R < str.length && str[L] == str[R]) {
                L--;
                R++;
            }
            max = Math.max(max, R - L - 1);
        }
        return max / 2;
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

        //System.out.println(violenceMethod("cbbd"));

       String cacaccebcb = mancher1("eeeebba");
        System.out.println(cacaccebcb);
        int possibilities = 5;
        int strSize = 20;
        int testTimes = 5000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            int i1 = mancher(str);
            int right = right(str);
            if (i1 != right) {
                System.out.println(str);
                System.out.println(i1 + " vs " + right);
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }
}
