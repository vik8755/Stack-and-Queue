package queue;

import java.util.Stack;

public class QueueUsingStack<T> implements Queue<T>{
    Stack<T> queue;
    public QueueUsingStack(){
        queue=new Stack<>();
    }
    @Override
    public T push(T value) {
        queue.addLast(value);
        return value;
    }

    @Override
    public T pop() {
        return queue.removeFirst();
    }

    @Override
    public T top() {
        return queue.firstElement();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void displayAll() {
        queue.forEach(System.out::println);

    }

    public static void main(String[] args) {
        QueueUsingStack<Integer> queue=new QueueUsingStack<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.top());
       // queue.displayAll();
     //   queue.pop();
     //   queue.displayAll();
    }
}
