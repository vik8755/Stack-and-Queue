package stack;

public class EmptyStackException extends RuntimeException{
    public EmptyStackException() {
        super("Oh no! Stack is empty");
    }
}
