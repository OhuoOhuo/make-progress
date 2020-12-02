package arithmetic.zuo.class11;

public class Code01_Hanoi {


    public static void main(String[] args) {
        int i =3;
        hanoi1(i);
        System.out.println("++++++++++++++++++");
        hanoi2(i);
        System.out.println("============");
        hanoi3(i);
    }

    private static void hanoi3(int i) {
        process1(i,"left","right","mid");
    }

    private static void process1(int i, String from, String to, String other) {
        if(i ==1){
            System.out.println("move "+i+from+ " to"+ to);
        }else {
            process1(i-1,from,other,to);
            System.out.println("move " + i + from + " to "+to);
            process1(i-1,other,to,from);
        }
    }

    private static void hanoi2(int i) {
        process(i,"left","right","mid");
    }

    private static void process(int n,String from ,String to,String other){
        if(n ==0){
            return;
        }else {
            process(n-1,from,other,to);
            System.out.println("move "+ n + from+ " to " + to );
            process(n-1,other,to,from);
        }
    }

    private static void hanoi1(int n) {

        left2mid(n-1);
        System.out.println("move " +n +"left to right");
        mid2right(n-1);
    }

    private static void mid2right(int n) {
        if(n <1){
            return;
        }
        mid2left(n-1);
        System.out.println("move "+n+"mid to right ");
        left2right(n-1);
    }

    private static void left2right(int n) {
        if(n <1){
            return;
        }
        left2mid(n-1);
        System.out.println("move "+n+"left to right");
        mid2right(n-1);
    }

    private static void mid2left(int n) {
        if(n <1){
            return;
        }
        mid2right(n-1);
        System.out.println("move "+n +" mid to left");
        right2left(n-1);
    }

    private static void right2left(int n) {
        if(n<1){
            return;
        }
        right2mid(n-1);
        System.out.println("move "+n +"right to left");
        mid2left(n-1);
    }

    private static void right2mid(int n) {
        if(n<1){
            return;
        }
        right2left(n-1);
        System.out.println("move "+n+ " right to mid");
        left2right(n-1);
    }

    private static void left2mid(int n) {
        if(n <1){
            return;
        }
        left2right(n-1);
        System.out.println("move "+n+"left to mid");
        right2mid(n-1);
    }




}
