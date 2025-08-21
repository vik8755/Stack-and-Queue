package stack;

import node.Node;
import queue.EmptyQueueException;

public class LinkedListStack<T> implements Stack<T>{

    private Node<T> head;

    public LinkedListStack(){
        head=null;
    }

    @Override
    public T push(T value) {
        Node<T> newData=new Node<>(value);
        if(head==null){
            head=newData;
        }
        else {
            newData.next = head;
            head = newData;
        }
        return newData.data;
    }

    @Override
    public T pop() {
        if(head==null){
            throw new EmptyStackException();
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
            throw new EmptyStackException();
        }
        Node<T> temp=head;
        while (temp!=null) {
            System.out.print(temp.data+", ");
            temp=temp.next;
        }

    }
    }

