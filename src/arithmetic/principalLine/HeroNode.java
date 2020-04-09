package arithmetic.principalLine;

/**
 * Created by cheng on 2020/3/25.
 */
public class HeroNode {

    public int no;
    public String name;
    public HeroNode next;

    public HeroNode(int no,String name){
        this.no =no;
        this.name=name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}
