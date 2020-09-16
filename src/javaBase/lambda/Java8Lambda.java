package javaBase.lambda;

public class Java8Lambda {

    public static void main(String[] args) {
        Java8Lambda java8Lambda = new Java8Lambda();
        MathOperation addition =(int a,int b)->a+b;

        MathOperation addition1=(a,b)->a+b;

        MathOperation addition2=(a,b)->{ return a*b ;};

        MathOperation addition3=(a,b) -> a/b;

        System.out.println(java8Lambda.operate(1,2,addition));
        System.out.println(java8Lambda.operate(2,3,addition1));
        System.out.println(java8Lambda.operate(3,4,addition2));
        System.out.println(java8Lambda.operate(4,5,addition3));
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }



}
