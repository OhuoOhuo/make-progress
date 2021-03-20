package arithmetic.principalLine.arithmetic;



public class BinaryOperation {
    /*
     &（“与”）、|（“或”）、^（“异或”）、~（“非”）
     这些运算符只能作用于整型操作数。有符号的或无符号的。
     */


    public static void main(String[] args){

        /*
         只有两个位都是1，结果才是1
        （&）经常用于屏蔽某些二进制位
         */
        int a=129;
        int b=118;
        String aStr = Integer.toBinaryString(a);
        String bStr = Integer.toBinaryString(b);
        System.out.println(aStr);
        System.out.println(bStr);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String andStr = Integer.toBinaryString(a & b);
        System.out.println("a & b = "+(a&b));
        System.out.println(aStr + " & "+bStr +" =" + andStr);


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        /*
        只要两个位上有一个1，结果就是1
          ( | )常用于将某些位置为1
         */
        String orStr = Integer.toBinaryString(a | b);
        System.out.println("a | b = "+(a | b));
        System.out.println(aStr + " | "+bStr +" =" + orStr);

        /*
         （^） 相同则结果为0，不同则结果为1
         */
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String notStr = Integer.toBinaryString(a ^ b);
        System.out.println("a ^ b = "+(a ^ b));
        System.out.println(aStr + " ^ "+bStr +" =" + notStr);

        /*
          ~求整数的二进制反码，~0可获得与机器字长无关的一串1。
         */
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(" ~ " + a +" = " + (~a) );
        System.out.println("~ "+ aStr +" = "+ Integer.toBinaryString(~a));

        /*
        <<:左移	左边最高位丢弃，右边补齐0;
         */
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

        //把<<左边的数据乘以2的移动次幂
        System.out.println(3<<2);

        /*
        >>:右移	最高位是0，左边补齐0；最高为是1，左边补齐1；
         */
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(b>>2);
        System.out.println(Integer.toBinaryString(b>>2));

        /*
         >>>:无符号右移 无论最高位是0还是1，左边补齐0
         */







    }



}
