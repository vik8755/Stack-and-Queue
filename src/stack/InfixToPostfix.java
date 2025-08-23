package stack;

import java.util.*;
import java.util.Stack;

public class InfixToPostfix {
    public static StringBuilder changeInfixToPostfix(String infix){
        StringBuilder answer=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        if(infix.isEmpty()) return answer;
        Map<Character,Integer> priority=new HashMap<>();
        priority.put('^',3);
        priority.put('/',2);
        priority.put('*',2);
        priority.put('+',1);
        priority.put('-',1);
        int index=0;
        while (index<infix.length()){

            char character=infix.charAt(index);

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
                    while (!stack.isEmpty()&&priority.getOrDefault(stack.peek(),0)>=priority.getOrDefault(character,0)){
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
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(changeInfixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }
}
