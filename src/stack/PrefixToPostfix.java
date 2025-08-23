package stack;

import java.util.Stack;

public class PrefixToPostfix {
    public static String convertPrefixToPostfix(String prefix) {
        Stack<String> stack = new Stack<>();
        int index = prefix.length() - 1;
        while (index >= 0) {
            char character = prefix.charAt(index);
            if (Character.isLetterOrDigit(character)) {
                stack.push(String.valueOf(character));
            } else {
                String expression =
                        stack.pop() +
                        stack.pop() +
                        character;
                stack.push(expression);

            }
            index--;
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(convertPrefixToPostfix("*-A/BC-/AKL"));
    }
}
