package stack;

import java.util.Stack;

public class PostfixToInfix {
    public static String convertPostfixToInfix(String postFix){
        Stack<String> stack=new Stack<>();
        int index=0;
        while (index<postFix.length()){
            char character=postFix.charAt(index);
            if(Character.isLetterOrDigit(character)){
                stack.push(String.valueOf(character));
            }else{
                StringBuilder expression=new StringBuilder();
                expression.append('(');
                expression.append(stack.pop());
                expression.insert(1,character);
                expression.insert(1,stack.pop());
                expression.append(')');
                stack.push(expression.toString());

            }
            index++;
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(convertPostfixToInfix("abc+*d/"));
    }
}
