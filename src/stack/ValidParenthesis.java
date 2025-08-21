package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Dictionary;
import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValidParentheses(String parentheses){
        Deque<Character> stack=new ArrayDeque<>();
        for (int index=0;index<parentheses.length();index++){
            char paren=parentheses.charAt(index);
            if(paren=='[' ||paren=='{' ||paren=='('){
                stack.push(paren);
            }
            else{
                // This deals if only close parentheses are present in the start.
                if(stack.isEmpty()){
                    return false;
                }
                if (stack.peek()=='[' && paren==']'
                        ||stack.peek()=='{' && paren=='}'
                        ||stack.peek()=='(' && paren==')' ) {
                    stack.pop();
                }
                else stack.push(paren);

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidParentheses( "(])"));
    }
}
