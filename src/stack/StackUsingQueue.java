package stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue<T> implements Stack<T> {
    Queue<T> queue=new ArrayDeque<>();


    @Override
    public T push(T value) {
        queue.add(value);
        for (int i=0;i<size()-1;i++){
            queue.add(queue.peek());
            queue.remove();

        }
        return queue.peek();
    }

    @Override
    public T pop() {
        return queue.remove();
    }

    @Override
    public T top() {
        return queue.peek();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void displayAll() {
        queue.stream().forEach(System.out::println);

    }

    public static void main(String[] args) {
        StackUsingQueue<Integer> stack=new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);stack.displayAll();
    }
}
