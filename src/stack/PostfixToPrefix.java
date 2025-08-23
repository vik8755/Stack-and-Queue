package stack;

import java.util.Stack;

public class PostfixToPrefix {
    public static String convertPostfixToPrefix(String postFix) {
        Stack<String> stack=new Stack<>();
        int index=0;
        while (index<postFix.length()){
            char character=postFix.charAt(index);
            if(Character.isLetterOrDigit(character)){
                stack.push(String.valueOf(character));
            }else{
                StringBuilder expression=new StringBuilder();
                expression.append(stack.pop());
                expression.insert(0,stack.pop());
                expression.insert(0,character);
                stack.push(expression.toString());

            }
            index++;
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(convertPostfixToPrefix("AB+C*DE--FGH*+^I-"));
    }
}
