package queue;

public class EmptyQueueException extends RuntimeException{
    public EmptyQueueException() {
        super("Oh no! Queue is empty");
    }
}
