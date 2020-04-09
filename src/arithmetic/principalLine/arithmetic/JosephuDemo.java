package arithmetic.principalLine.arithmetic;

import arithmetic.principalLine.dataStructure.HeroNode;

/**
 * 约瑟夫问题
 */
public class JosephuDemo {

    public static void main(String [] agrs){

       /* CircleSingleLinckedList circleSingleLinckedList = new CircleSingleLinckedList();
        circleSingleLinckedList.add(5);
        circleSingleLinckedList.show();*/

        count(1,3,5);

    }

    public static void count(int starNo,int countNo,int nums){

        if(starNo <=0 || countNo < 1 || nums<1){
            System.out.println("参数不合法");
            return;
        }
        CircleSingleLinckedList circleSingleLinckedList = new CircleSingleLinckedList();
        circleSingleLinckedList.add(nums);
        HeroNode head = circleSingleLinckedList.head;

        //找到倒数第一个节点
        HeroNode temp =head;

        while (true){
            if(temp.next ==head){
                break;
            }
            temp =temp.next;
        }

        //开始点
        for (int i = 0; i < starNo-1 ; i++) {
            head =head.next;
            temp =temp.next;
        }

        while (true){
            if(temp ==head){
                break;
            }
            for (int i = 1; i < countNo -1 ; i++) {
                head =head.next;
                temp =temp.next;
            }
            System.out.println("删除 " +head.no);
            head =head.next;
            temp.next = head;
        }
        System.out.println("删除 " + head.no);

    }


}

class CircleSingleLinckedList{

        public HeroNode head =null;

    public void add(int nums){
        if(nums <1){
            return;
        }
        HeroNode temp =null ;
        for (int i = 1; i <= nums ; i++) {
            HeroNode newNode = new HeroNode(i, "");
            if(i ==1){
                head =newNode;
                head.next = head;
                temp =head;
            }else {
                temp.next =newNode;
                newNode.next =head;
                temp =newNode;
            }

        }
    }

    public void show(){
        HeroNode temp =head;
        while ( true ){
            System.out.println(temp.no);
            if(temp.next ==head){
                break;
            }
            temp =temp.next;
        }
    }


}