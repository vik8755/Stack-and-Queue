package queue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue=new ArrayQueue<>(6);
        queue.push(32);
        queue.push(533);
        queue.push(33434);
        queue.push(3224);
        queue.push(32424);
        queue.displayAll();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        System.out.println();
        queue.displayAll();
    }
}
