package arithmetic.principalLine.dataStructure;

import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * @author ：cwf
 * @date ：Created in 2020/7/3 14:11
 * @description：栈判断括号是否匹配
 */
public class Parentheses {
    private Stack<Character> in;
    private Stack<Character> out;
    private String parenthesesStr;

    public Parentheses(){
        in = new Stack();
        out = new Stack();
    }

    public void setStr(String str){
        parenthesesStr =str;
    }

    public boolean isSymmetry(){
        if(parenthesesStr==null){
            throw new RuntimeException("");
        }
        char[] chars = parenthesesStr.toCharArray();
        for (char c:chars) {
            in.push(c);
        }
        while (!in.isEmpty()){
            Character inpop = in.pop();

            if(out.isEmpty()){
                out.push(inpop);
            }else {
                Character outpop = out.pop();
                boolean match=isMatch(inpop,outpop);
                if(!match){
                    out.push(outpop);
                }
            }
        }
        if(out.isEmpty()){
            return true;
        }
        return false;
    }

    private boolean isMatch(Character inpop, Character outpop) {
        HashMap<Character, Character> matchMap = new HashMap<>();
        matchMap.put("{".charAt(0),"}".charAt(0));
        matchMap.put("}".charAt(0),"{".charAt(0));
        matchMap.put("[".charAt(0),"]".charAt(0));
        matchMap.put("]".charAt(0),"[".charAt(0));
        matchMap.put("(".charAt(0),")".charAt(0));
        matchMap.put(")".charAt(0),"(".charAt(0));
        return matchMap.get(inpop).equals(outpop);
    }

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        parentheses.setStr("[()]{}{[()()]()}");
        System.out.println(parentheses.isSymmetry());
        parentheses.setStr("[(])");
        System.out.println(parentheses.isSymmetry());
    }


}
