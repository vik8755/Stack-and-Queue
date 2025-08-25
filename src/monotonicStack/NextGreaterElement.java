package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
  /**  Given an array of integers we need to find the next greater element
    *  for every element i.e. arr=[6,0,8,1,3], next greater elements
    *  would be [8,8,-1,3,-1]
   */
    public static int[] findNextGreaterElementBrute(int[] arr){
        int length=arr.length;
        int[] nextGreaterElements=new int[length];
        for (int i=0;i<length;i++){
            boolean isNextGreaterPresent=false;
            for (int j=i+1;j<length;j++){
                if(arr[i]<arr[j]){
                    nextGreaterElements[i]=arr[j];
                    isNextGreaterPresent=true;
                    break;
                }
            }
            if (!isNextGreaterPresent){
                nextGreaterElements[i]=-1;
            }
        }
        return nextGreaterElements;

    }

    public static int[] findNextGreaterElementOptimal(int[] arr) {
        int length = arr.length;
        int[] nextGreaterElements = new int[length];
        Stack<Integer> stack=new Stack<>();
        for(int i=length-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            nextGreaterElements[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return nextGreaterElements;
    }

    public static void main(String[] args) {
        Arrays.stream(findNextGreaterElementBrute(new int[]{6,0,8,1,3})).forEach(System.out::println);
        Arrays.stream(findNextGreaterElementOptimal(new int[]{6,0,8,1,3})).forEach(System.out::println);

    }
}
