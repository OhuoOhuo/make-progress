package arithmetic.zuo.class11;

/**
 * 给定一个数值串
 * 1-a 2-b 3-c ......26-z对应
 * 求有多少种转换方式
 */
public class Code06_ConvertToLetterString {
    public static void main(String[] args) {
        System.out.println(number("1123111"));
        System.out.println(dpWay("1123111"));
    }

    private static int dpWay(String s) {
        if(s==null ||s.length()==0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int N = chars.length;
        int[] dp = new int[N+1];
        dp[N] =1;
        for (int i = N-1; i >=0 ; i--) {
            if(chars[i] =='0'){
                dp[i]=0;
            }else
            if(chars[i] =='1'){
                int res = dp[i+1];
                if(i+1<chars.length){
                    res =  res+ dp[i+2];
                }
                dp[i] = res;
            }else
            if(chars[i] == '2'){
                int res = dp[i+1];
                if(i+1<chars.length && '0' <=chars[i+1] && chars[i+1] <='6'){
                    res =res+dp[i+2];
                }
                dp[i] = res;
            }else {
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }

    private static int number(String s) {
        if(s==null ||s.length()==0){
            return 0;
        }
        char[] chars = s.toCharArray();

        return process(chars,0);
    }

    /**
     * i 下标
     * 0 ....i-1不需要关注
     * i及以后的 有多少种情况
     */
    private static int process(char[] chars,int i){
        if(i == chars.length){//递归往往是i == 数组下标，及刚越界；走到最后是；一种可能性
            return 1;
        }
        if(chars[i] =='0'){//如果这种情况已0开头，则无法转换
            return 0;
        }
        if(chars[i] =='1'){
            int res = process(chars, i + 1);
            if(i+1<chars.length){
                res =res+process(chars,i+2);
            }
            return res;
        }
        if(chars[i] == '2'){
            int res = process(chars,i+1);
            if(i+1<chars.length && '0' <=chars[i+1] && chars[i+1] <='6'){
                res =res+process(chars,i+2);
            }
            return res;
        }

        //如果当前i对应的值大于3则，没有增加可能性，及为i+1的可能性个数
        return process(chars,i+1);

    }
}
