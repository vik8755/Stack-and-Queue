package stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack=new LinkedListStack<>();
        stack.push(33);
        stack.push(32);
        stack.push(23);
        stack.push(55);
        stack.push(764);
        stack.push(343);
        stack.push(354);
        stack.push(242);
        stack.displayAll();
        System.out.println(stack.size());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        stack.displayAll();


    }
}
