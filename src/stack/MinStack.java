package stack;

import java.util.Stack;

public class MinStack{
   Stack<Pair<Integer>> stack;
    public MinStack(){
        stack=new Stack<>();
    }

    public int push(int value) {
        if(stack.empty()){
            stack.push(new Pair<>(value,value));
        }
        else{
            int min= Math.min(stack.peek().min, value);
           stack.push(new Pair<>(value,min));
        }
        return value;
    }

    public int pop() {
        return stack.pop().value;
    }

    public int getMin(){
        return stack.peek().min;
    }


    public int top() {
        return stack.peek().value;
    }

    public int size() {
        return stack.size();
    }

    public void displayAll() {
        stack.forEach(x-> System.out.println(x.value+", "+x.min));

    }

    public static void main(String[] args) {
        MinStack stack=new MinStack();
        stack.push(11);
        stack.push(32);
        stack.push(9);
        stack.push(17);
        stack.displayAll();
    }
}
class Pair<Integer>{
    int value;
    int min;
    public Pair(int value, int min){
        this.value=value;
        this.min=min;
    }
}
