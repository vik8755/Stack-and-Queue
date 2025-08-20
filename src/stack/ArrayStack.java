package stack;

public class ArrayStack<T> implements Stack<T>{

    private  final T[] arr;
   private int index;
   private int length;
    public ArrayStack(int length){
        this.length=length;
        arr=(T[]) new Object[length];
        index=-1;
    }
    @Override
    public T push(T value) {
        if(size()>=length){
          throw new StackOverflowError( "Stack is full");
        }
        index++;
        arr[index]=value;
        return arr[index];
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        T temp=arr[index];
        arr[index]=null;
        index--;
        return temp;
    }

    @Override
    public T top() {
        if(isEmpty()){
            throw new RuntimeException("Empty stack");
        }
        return arr[index];
    }

    @Override
    public int size() {
        return index+1;
    }

    @Override
    public void displayAll() {
        for (int i = 0; i <= index; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    private boolean isEmpty(){
        return size()==0;
    }
}
