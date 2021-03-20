package arithmetic.principalLine.dataStructure;

/**
 * Created by cheng on 2020/3/25.
 */
public class DoubleLinckedListDemo {
    public static void main(String[] args){

    }





    class DoubleLinckedList{

        private HeroNode2 head =new HeroNode2(0,"");



        public void addByorder(HeroNode2 node){ //有序插入
            HeroNode2 temp =head;

            while (true){
                if(temp.next ==null){
                    break;
                }
                if(temp.next.no >= node.no){
                    break;
                }
                temp =temp.next;
            }

            temp.pre.next =node;
            node.pre =temp.pre;
            temp.pre =node;
            node.next =temp;

        }



    }
}
