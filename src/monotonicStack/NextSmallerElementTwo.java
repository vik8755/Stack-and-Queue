package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementTwo {
    public static int[] findNextSmallerElementOptimal(int[] arr) {
        int length = arr.length;
        int[] nextSmallerElements = new int[length];
        Stack<Integer> stack=new Stack<>();
        for(int i=2*length-1;i>=0;i--){
            int element=arr[i%length];
            while (!stack.isEmpty() && stack.peek() >= element) {
                stack.pop();
            }
            if(i<length) {
                nextSmallerElements[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(element);
        }
        return nextSmallerElements;
    }

    public static void main(String[] args) {
        Arrays.stream(findNextSmallerElementOptimal(new int[]{7,2,4,5,6})).forEach(System.out::println);

    }
}
