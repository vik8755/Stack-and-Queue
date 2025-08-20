package queue;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayQueue<T> implements Queue<T>{

    private  final T[] arr;
    private int start;
    private int end;
    private int length;
    public ArrayQueue(int length){
        this.length=length;
        arr=(T[]) new Object[length];
        start=0;
        end=-1;
    }

    @Override
    public T push(T value) {
        if(size()>=length){
            throw new QueueOverflowException();
        }
        end++;
        arr[end]=value;
        return arr[end];
    }


    @Override
    public T pop() {
        if(size()==0){
            throw new EmptyQueueException();
        }
        T temp=arr[start];
        arr[start]=null;
        start++;
        return temp;
    }

    @Override
    public T top() {
        if(size()==0){
            throw new EmptyQueueException();
        }
        return arr[start];
    }

    @Override
    public int size() {
        return end-start+1;
    }

    @Override
    public void displayAll() {
        for (int index=start;index<=end;index++){
            System.out.print(arr[index]+", ");
        }
    }

}
