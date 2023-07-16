public class ArrayStack {
    private int[] stack;
    private int size;

    public ArrayStack() {
        this.stack = new int[10];
        this.size = 0;
    }

    //push
    public void push(int input){
        if (size == stack.length) resize();
        stack[size++] = input;
    }

    //pop
    public void pop(){

    }
    //peek
    //isEmpty
    //resize
    private void resize(){
        int length = stack.length * 2;
        int[] newStack = new int[length];
        int index = 0;
        for (int item: stack)
            newStack[index] = item;

        stack = newStack;
    }
}
