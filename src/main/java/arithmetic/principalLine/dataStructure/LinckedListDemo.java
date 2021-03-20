package arithmetic.principalLine.dataStructure;

import arithmetic.principalLine.dataStructure.HeroNode;

/**
 * Created by cheng on 2020/3/25.
 */
public class LinckedListDemo {
    public static void main(String[] args){

    }


    public static void reverseList(HeroNode head){
        if(head ==null || head.next ==null){
            return;
        }
        HeroNode pre = null;
        HeroNode next =null;

        while (head !=null){
            next =head.next;

            head.next=  pre;
            pre =head;
            head =next;
        }

        head =pre;
    }



    public HeroNode findLastIndexNode(HeroNode heroNode,int index){

        HeroNode temp =heroNode;
        int total =0;
        while (true){
            if(heroNode.next ==null){
                break;
            }
            total++;
            temp =temp.next;
        }

        if(total <index){
            return null;
        }

        HeroNode cur =heroNode.next;
        for (int i = 0; i < total -index ; i++) {
            cur =cur.next;
        }
        return cur;
    }


    class LinckedList{

        private HeroNode head =new HeroNode(0,"");

        public void add(HeroNode node){
            HeroNode temp =head;

            while (true){
                if(temp.next ==null){
                    break;
                }
                temp =temp.next;
            }
            temp.next = node;
        }

        public void addByorder(HeroNode node){ //有序插入
            HeroNode temp =head;

            while (true){
                if(temp.next ==null){
                    break;
                }
                if(temp.next.no >= node.no){
                    break;
                }
                temp =temp.next;
            }

            node.next =temp.next;
            temp.next =node;
        }

        public void update(HeroNode node){
            HeroNode temp = head.next;
            Boolean flag =false;
            while (true){
                if(temp ==null){
                    break;
                }
                if(temp.no ==node.no){
                    flag =true;
                    break;
                }
                temp=temp.next;
            }

            if(flag){
                temp.name =node.name;
            }else {
                System.out.println("没找到");
            }
        }

        public void del(HeroNode node){
            HeroNode temp= head;
            Boolean flag =false;
            while (true){
                if(temp.next ==null){
                    break;
                }
                if(temp.next.no == node.no){
                    flag =true;
                    break;
                }
                temp =temp.next;
            }
            if(flag){
                temp.next = temp.next.next;
            }else {
                System.out.println("没找到该节点");
            }
        }

    }
}
