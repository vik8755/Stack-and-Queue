package queue;

public interface Queue<T>{

    public T push(T value);
    public T pop();
    public T top();
    public int size();
    public void displayAll();
}
