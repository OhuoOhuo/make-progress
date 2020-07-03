package arithmetic.principalLine.dataStructure;

import java.util.Iterator;

/**
 * @author ：cwf
 * @date ：Created in 2020/7/2 14:40
 * @description：链表实现栈
 */
public class Stack<Item> implements Iterable<Item>  {

    private Node first;
    private int size;
    public Boolean isEmpty(){ return first==null; }

    public int size(){ return this.size; }

    public Item pop(){
        if(size==0){
            throw  new  RuntimeException("无法获取了");
        }
        Item out = first.item;
        first = first.next;
        size--;
        return out;
    }
    public void push(Item item){
        Node oldFirst =first;
        first = new Node();
        first.item=item;
        first.next = oldFirst;
        size++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;

        @Override
        public boolean hasNext() {
             return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }



    private class Node{
        private Item item;
        private Node next;
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        System.out.println("初始是否为空:"+stringStack.isEmpty());
        stringStack.push("hahahahha");
        stringStack.push("hehehehe");
       /* System.out.println(stringStack.size());
        System.out.println("获取:"+stringStack.pop());
        System.out.println(stringStack.size());*/

        for (String str: stringStack) {
            System.out.println(str);
        }
    }






}
