package stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack=new ArrayStack<>(10);
        stack.push(33);
        stack.push(32);
        stack.push(23);
        stack.push(55);
        stack.push(764);
        stack.push(343);
        stack.push(354);
        stack.push(242);
        stack.displayAll();


    }
}
