package arithmetic.zuo.class11;

public class Code10_OLaEnvelope {

    public static void main(String[] args) {

        System.out.println(oLaEnvelope(4));
    }

    public static int oLaEnvelope(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if(n ==3){
            return 2;
        }

        return process(n);
    }

    public static int process(int n){
        if(n ==2){
            return 1;
        }
        if(n ==3){
            return 2;
        }

        return (n-1)*(process(n-1)+process(n-2));
    }
}
