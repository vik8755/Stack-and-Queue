package queue;

public class QueueOverflowException extends RuntimeException{
    public QueueOverflowException() {
        super("Oops! no space left to add element in queue. Better luck next time");
    }
}
