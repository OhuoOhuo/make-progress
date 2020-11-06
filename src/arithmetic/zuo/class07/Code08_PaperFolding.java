package arithmetic.zuo.class07;

public class Code08_PaperFolding {


    public static void main(String[] args) {
        int N = 4;
        printPro(N);
    }

    private static void printPro(int N) {
        process(1,N,true);
    }


    private static void process(int i,int N,boolean down){
        if(i > N){
            return;
        }
        process(i+1,N,true);
        System.out.print(down?"凹 ":"凸 ");
        process(i+1,N,false);
    }
}
