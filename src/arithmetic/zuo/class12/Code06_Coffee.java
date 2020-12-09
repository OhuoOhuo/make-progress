package arithmetic.zuo.class12;

public class Code06_Coffee {


    public static int process(int[] drinks, int a, int b, int index, int washLine) {

        if (index == drinks.length - 1) { //base case
            return Math.min(washLine + a, drinks[index] + b);
        }


        return 0;
    }


    public static int minx(char[] arr, char[] brr, int a, int b) {
        if (a == arr.length - 1) {
            for (int i = 0; i < brr.length; i++) {
                if (arr[a] == brr[i]) {
                    return brr.length - 1;
                }
            }
            return brr.length+1;
        }
        if (b == brr.length - 1) {
            for (int i = 0; i < arr.length; i++) {
                if (brr[b] == arr[i]) {
                    return arr.length - 1;
                }
            }
            return arr.length+1;
        }

        int minx1= minx(arr, brr, a + 1, b );
        int minx2 = minx(arr, brr, a, b + 1);
        int minx3 = minx(arr, brr, a + 1, b + 1);

        int max = Math.min(minx3,Math.min(minx1,minx2));

        if(arr[a] == brr[b]){
            return max;
        }
        return max+1;
    }

    public static void main(String[] args) {
        String a ="sea23";
        String b = "eatef";
        System.out.println(minx(a.toCharArray(),b.toCharArray(),0,0));
    }
}
