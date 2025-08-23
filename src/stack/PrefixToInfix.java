package stack;

import java.util.Stack;

public class PrefixToInfix {
    public static String convertPrefixToInfix(String prefix) {
        // Follow the same process that we followed in
        // postfix to infix but in reverse direction.
        java.util.Stack<String> stack = new Stack<>();
        int index = prefix.length() - 1;
        while (index >= 0) {
            char character = prefix.charAt(index);
            if (Character.isLetterOrDigit(character)) {
                stack.push(String.valueOf(character));
            } else {
                StringBuilder expression = new StringBuilder();
                expression.append('(');
                expression.append(stack.pop());
                expression.append(character);
                expression.append(stack.pop());
                expression.append(')');
                stack.push(expression.toString());

            }
            index--;
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(convertPrefixToInfix("*-A/BC-/AKL"));
    }
}
