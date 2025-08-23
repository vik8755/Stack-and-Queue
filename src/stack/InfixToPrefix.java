package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPrefix {
    public static StringBuilder changeInfixToPrefix(String infix) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        if (infix.isEmpty()) return answer;
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('^', 3);
        priority.put('/', 2);
        priority.put('*', 2);
        priority.put('+', 1);
        priority.put('-', 1);
        char[] arr= reverse(infix.toCharArray());
        for (int i=0;i<arr.length;i++){
            if (arr[i] == '(' || arr[i] == ')') {
                arr[i] = (arr[i] == '(') ? ')' : '(';
            }
        }
        int index = 0;
        while (index<arr.length){

            char character=arr[index];

            if(Character.isLetterOrDigit(character)){
                answer.append(character);
            } else if (character=='(') {
                stack.push(character);
            }
            else if (character==')') {
                while (!stack.isEmpty()&& stack.peek() !='(') {
                    answer.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            }
            else{
                if(!stack.empty()&&priority.getOrDefault(character,0)<priority.getOrDefault(stack.peek(),0)){
                    // Only replace when priority is greater.
                    while (!stack.isEmpty()&&priority.getOrDefault(stack.peek(),0)>priority.getOrDefault(character,0)){
                        answer.append(stack.peek());
                        stack.pop();
                    }
                }stack.push(character);
            }
            index++;
        }
        while (!stack.empty()) {
            answer.append(stack.peek());
            stack.pop();
        }
        return answer.reverse();
    }
    private static char[] reverse(char[] arr){
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(changeInfixToPrefix("(a-b/c)*(a/k-l)"));
    }
}
