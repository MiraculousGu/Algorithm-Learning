import java.util.Arrays;

public class ArrayStack {
    private int[] stack;
    private int size;

    public ArrayStack() {
        this.stack = new int[10];
        this.size = 0;
    }

    //push
    public void push(int input) {
        if (size == stack.length) resize();
        stack[size++] = input;
    }

    //pop
    public int pop() {
        if (isEmpty())
            throw new IllegalStateException("The stack is empty");

        var top = stack[--size];
        return top;
    }

    //peek
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("The stack is empty");

        return stack[size - 1];
    }

    //isEmpty
    public Boolean isEmpty() {
        return size == 0;
    }

    //resize
    private void resize() {
        int length = stack.length * 2;
        int[] newStack = new int[length];
        int index = 0;
        for (int item : stack)
            newStack[index] = item;

        stack = newStack;
    }

    @Override
    public String toString(){
        var content = Arrays.copyOfRange(stack,0,size);
        return Arrays.toString(content);
    }
}
