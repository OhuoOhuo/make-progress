package arithmetic.sword;

public class ArrayDemo1 {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */

    public static void main(String[] args){
        System.out.println(0|0);
        System.out.println(1|0);
        System.out.println(1|1);

        System.out.println(0&0);
/*        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix,3));*/
    }

    private static boolean find(int[][] arr ,int i){

        int maxRow = arr.length;
        int maxCol = arr[0].length;

        int row=0;
        int col = maxCol-1;

        while (row >=0 && row<maxRow && col >=0 && col<maxCol){
            if(arr[row][col] ==i){
                return true;
            }
            if(arr[row][col] <i){
                row ++;
            }else {
                col --;
            }

        }
        return false;
    }


}
