import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayPriorityQueue<T extends Comparable<T>> {
    private Object[] queue;
    private int size;
    private int capacity;
    private int front;
    private int end;

    public ArrayPriorityQueue(int capacity) {
        this.capacity = capacity;
        size = 0;
        queue = new Object[capacity];
        front = 0;
        end = -1;
    }

    //insert
    public void insert(T item) {
        if (isFull())
            throw new IllegalStateException("The queue is full");

        int index = shiftToTheRightPosition(item);
        queue[index] = item;

        end = (end + 1) % capacity; //update the end pointer
        size++;
    }

    private int shiftToTheRightPosition(T item) {
        if (isEmpty())
            return 0;

        int index = end;
        while (index != front && ((T)queue[index]).compareTo(item) > 0){
            //move the current item to right
            int position = index + 1;
            if (index + 1 == capacity)
                position = 0;
            queue[position] = queue[index];
            index--;
            if (index < 0)
                index = capacity - 1;
        }

        if (((T)queue[front]).compareTo(item) > 0){
            queue[front + 1] = queue[front];
        } else
            index++;    //previous position is smaller
        return index;
    }

    //remove
    public T remove() {
        if (isEmpty())
            throw new IllegalStateException("The queue is empty");

        T item = (T)queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    //isFull
    public Boolean isFull() {
        return size == capacity;
    }

    //isEmpty
    public Boolean isEmpty() {
        return size == 0;
    }

    //toString
    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
