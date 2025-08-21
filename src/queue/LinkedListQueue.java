package queue;

import node.Node;
import stack.EmptyStackException;

public class LinkedListQueue<T> implements Queue<T>{

    private Node<T> head;

    public LinkedListQueue(){
        head=null;
    }

    @Override
    public T push(T value) {
        Node<T> newData=new Node<>(value);
        if(head==null){
            head=newData;
        }
        else {
            Node<T> temp=iterateToLastNode();
            temp.next=newData;
        }
        return newData.data;
    }

    @Override
    public T pop() {
        if(head==null){
            throw new EmptyQueueException();
        }
        T currentData=head.data;
        head=head.next;
        return currentData;
    }

    @Override
    public T top() {
        return head.data;
    }

    @Override
    public int size() {
        int count=0;
        Node temp=head;
        while (temp!=null) {
            count++;
            temp=temp.next;
        }
        return count;
    }

    @Override
    public void displayAll() {
        if (size()==0){
            throw new EmptyQueueException();
        }
        Node<T> temp=head;
        while (temp!=null) {
            System.out.print(temp.data+", ");
            temp=temp.next;
        }

    }

    private Node<T> iterateToLastNode(){
        Node<T> temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
}
