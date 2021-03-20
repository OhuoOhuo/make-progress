package arithmetic.principalLine.dataStructure;

/**
 * @author ：cwf
 * @date ：Created in 2020/7/2 16:51
 * @description：链表实现队列
 */
public class Queue<Item> {
    private Node first;
    private Node last;
    private int size;

    public boolean isEmpty(){return size==0;}
    public int size(){return this.size;}

    public Item get(){
        if(size==0){
            throw new RuntimeException("无法获取了");
        }
        Item oldFirst=first.item;
        first = first.next;
        size--;
        return oldFirst;
    }

    public void push(Item item){
        Node oldLast =last;
        last = new Node();
        last.item =item;
        if(size ==0){
            first = last;
        }else {
            oldLast.next=last;
        }
        size++;
    }

    private class Node{
        private Item item;
        private Node next;
    }


    public static void main(String[] args) {
        Queue<String> stringStack = new Queue<>();
        System.out.println("初始是否为空:"+stringStack.isEmpty());
        stringStack.push("hahahahha");
        stringStack.push("hehehehe");
        System.out.println(stringStack.size());
        System.out.println("获取:"+stringStack.get());
        System.out.println(stringStack.size());
    }
}
