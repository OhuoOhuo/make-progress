package arithmetic.principalLine.arithmetic;

public class EightQueenDemo {


    private static int maxSize = 8;

    private static int map =0;

    private static int[][] arry = new int[maxSize][maxSize];

    public static void main(String[] args){
        findQueen(0);
        System.out.println("八皇后问题共有："+map+"种可能");
        prient();
    }

    private static void findQueen(int row) {

        if(row ==maxSize){
            map++;
            //prient();
            return;
        }

        for (int col = 0; col <  maxSize; col++) {
            if(chack(row,col)){
                arry[row][col] =1;
                findQueen(row+1);
                arry[row] [col] =0;
            }

        }

    }

    private static boolean chack(int row, int col) {

        for (int i = 0; i < maxSize; i++) {
            if (arry[i][col] ==1){
                return false;
            }
        }
        for(int i=row-1,m=col-1; i>=0 && m>=0; i--,m--){//检查左对角线
            if(arry[i][m]==1){
                return false;
            }
        }
        for(int i=row-1,m=col+1; i>=0 && m<=7; i--,m++){//检查右对角线
            if(arry[i][m]==1){
                return false;
            }
        }



        return true;
    }

    private static void prient(){
        for (int i = 0; i < maxSize ; i++) {
            for (int j = 0; j < maxSize; j++) {
                System.out.print(arry[i][j]+" ");

            }
            System.out.println();

        }

        System.out.println();

    }


}
