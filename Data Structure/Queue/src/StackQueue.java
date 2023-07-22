import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class StackQueue <T> {
    private Stack<T> enqueueStack;
    private Stack<T> dequeueStack;
    private int size;
    private int capacity;

    public StackQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    //enqueue
    public void enqueue(T item){
        if (isFull())
            throw new IllegalStateException("The queue is full");

        enqueueStack.push(item);
        size++;
    }

    //dequeue
    public T dequeue(){
        if (isEmpty())
            throw new IllegalStateException("The queue is empty");

        transferEnqueueToDequeue();

        size--;
        return dequeueStack.pop();
    }

    private void transferEnqueueToDequeue() {
        if (dequeueStack.isEmpty())
            while (!enqueueStack.isEmpty())
                dequeueStack.push(enqueueStack.pop());
    }

    //peek
    public T peek(){
        if (isEmpty())
            throw new IllegalStateException("The queue is empty");

        transferEnqueueToDequeue();
        return dequeueStack.peek();
    }

    //isEmpty
    public Boolean isEmpty(){
        return size == 0;
    }
    //isFull
    public Boolean isFull(){
        return size == capacity;
    }

    //toString
    @Override
    public String toString(){
        ArrayList<T> result = new ArrayList<>();

        for (T item: dequeueStack)
            result.add(item);

        Collections.reverse(result);
        for (T item: enqueueStack)
            result.add(item);

        return result.toString();
    }
}
