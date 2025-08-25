package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static int[] findNextSmallerElementOptimal(int[] arr) {
        int length = arr.length;
        int[] nextSmallerElements = new int[length];
        Stack<Integer> stack=new Stack<>();
        for(int i=length-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            nextSmallerElements[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return nextSmallerElements;
    }

    public static void main(String[] args) {
        Arrays.stream(findNextSmallerElementOptimal(new int[]{10, 9, 8, 7})).forEach(System.out::println);

    }
}
