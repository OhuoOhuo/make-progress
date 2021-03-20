package javaBase.lambda;



import com.sun.tools.javac.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Stream {
    public static void main(String[] args) {

        // 计算空字符串
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println("列表: " +strings);
        long count = getCountEmptyStringUsingJava7(strings);
        System.out.println("java7：空字符串的个数："+count);

        long count1 = strings.stream().count();
        System.out.println("java8:空字符串个数："+count1);


        // 删除空字符串
        List<String> filtered = deleteEmptyStringsUsingJava7(strings);
        System.out.println("java7,筛选后的列表: " + filtered);
        List<String> collect = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("java8,筛选后的列表: "+collect);

        //字符串长度为 3 的数量为
        count = getCountLength3UsingJava7(strings);
        System.out.println("java7:字符串长度为 3 的数量为: " + count);
        long count2 = strings.stream().filter(str -> str.length() == 3).count();
        System.out.println("java8:字符串长度为 3 的数量为: " + count2);


        // 删除空字符串，并使用逗号把它们合并起来
        String mergedString = getMergedStringUsingJava7(strings,",");
        System.out.println("java7:合并字符串: " + mergedString);
        String collect1 = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(","));
        System.out.println("java8:合并字符串: " + collect1);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        // 获取列表元素平方数
        List<Integer> squaresList = getSquares(numbers);
        System.out.println("java7平方数列表: " + squaresList);
        List<Integer> collect2 = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("java8平方数列表: " + collect2);


        System.out.println("---------------------------------------------");
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        System.out.println("列表: " +integers);
        System.out.println("列表中最大的数 : " + getMax(integers));
        System.out.println("列表中最小的数 : " + getMin(integers));
        System.out.println("所有数之和 : " + getSum(integers));
        System.out.println("平均数 : " + getAverage(integers));

        IntSummaryStatistics intSummaryStatistics = integers.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("列表中最大的数 : " + intSummaryStatistics.getMax());
        System.out.println("列表中最小的数 : " + intSummaryStatistics.getMin());
        System.out.println("所有数之和 : " + intSummaryStatistics.getSum());
        System.out.println("平均数 : " + intSummaryStatistics.getAverage());


        // 输出10个随机数
        Random random = new Random();

        for(int i=0; i < 10; i++){
            System.out.print(random.nextInt() +" ");
        }

        List<Integer> integers2 = Arrays.asList(1,2,13,4,15,6,17,8,19);
        integers2.stream().sorted(Comparator.reverseOrder()).limit(5).forEach(s -> System.out.println(s));



    }

    private static int getMin(List<Integer> numbers){
        int min = numbers.get(0);

        for(int i=1;i < numbers.size();i++){
            Integer number = numbers.get(i);

            if(number.intValue() < min){
                min = number.intValue();
            }
        }
        return min;
    }

    private static int getSum(List numbers){
        int sum = (int)(numbers.get(0));

        for(int i=1;i < numbers.size();i++){
            sum += (int)numbers.get(i);
        }
        return sum;
    }

    private static int getAverage(List<Integer> numbers){
        return getSum(numbers) / numbers.size();
    }


    private static int getMax(List<Integer> numbers){
        int max = numbers.get(0);

        for(int i=1;i < numbers.size();i++){

            Integer number = numbers.get(i);

            if(number.intValue() > max){
                max = number.intValue();
            }
        }
        return max;
    }

    private static List<Integer> getSquares(List<Integer> numbers) {
        List<Integer> squaresList = new ArrayList<Integer>();

        for(Integer number: numbers){
            Integer square = new Integer(number.intValue() * number.intValue());

            if(!squaresList.contains(square)){
                squaresList.add(square);
            }
        }
        return squaresList;
    }

    private static String getMergedStringUsingJava7(List<String> strings, String separator) {
        StringBuilder stringBuilder = new StringBuilder();

        for(String string: strings){

            if(!string.isEmpty()){
                stringBuilder.append(string);
                stringBuilder.append(separator);
            }
        }
        String mergedString = stringBuilder.toString();
        return mergedString.substring(0, mergedString.length()-1);
    }

    private static long getCountLength3UsingJava7(List<String> strings) {
        int count = 0;

        for(String string: strings){

            if(string.length() == 3){
                count++;
            }
        }
        return count;
    }

    private static List<String> deleteEmptyStringsUsingJava7(List<String> strings) {
        ArrayList<String> strings1 = new ArrayList<>();
        for (String str: strings) {
            if(!str.isEmpty()){
                strings1.add(str);
            }
        }
        return strings1;
    }

    private static long getCountEmptyStringUsingJava7(List<String> strings) {
        int count =0;
        for (String str:strings) {
            if(0>1){
                count++;
            }
        }
        return count;
    }
}
