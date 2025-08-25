package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementTwo {
   /**
    * Similar to next greater element but if we did not find the
    * greater element in the right direction then we need to look
    * in the left direction from 0 index.
    * In this we will use the concept of circular array i.e.
    * we use % operator to start from 0 in case of if we did not
    * find the next greater element.
    */
   public static int[] findNextGreaterElementBrute(int[] arr) {
      int length = arr.length;
      int[] nextGreaterElements = new int[length];
      for (int i = 0; i < length; i++) {
         boolean isNextGreaterPresent = false;
         for (int j = i + 1; j < length + i; j++) {
            int element = arr[j % length];
            if (arr[i] < element) {
               nextGreaterElements[i] = element;
               isNextGreaterPresent = true;
               break;
            }
         }
         if (!isNextGreaterPresent) {
            nextGreaterElements[i] = -1;
         }
      }
      return nextGreaterElements;
   }

   public static int[] findNextGreaterElementOptimal(int[] arr) {
      int length = arr.length;
      int[] nextGreaterElements = new int[length];
      Stack<Integer> stack=new Stack<>();
      for(int i=2*length-1;i>=0;i--){
         int element=arr[i%length];
         while (!stack.isEmpty() && stack.peek() <= element) {
            stack.pop();
         }
         if(i<length) {
            nextGreaterElements[i] = stack.isEmpty() ? -1 : stack.peek();
         }
         stack.push(element);
      }
      return nextGreaterElements;
   }

   public static void main(String[] args) {
      Arrays.stream(findNextGreaterElementBrute(new int[]{2,10,12,1,11})).forEach(System.out::println);
      Arrays.stream(findNextGreaterElementOptimal(new int[]{2,10,12,1,11})).forEach(System.out::println);

   }
}
