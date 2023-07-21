import java.util.Arrays;

public class ArrayQueue {
    private int[] queue;
    private int front;  //front index for the earliest item
    private int end;    //end of the queue
    private int size;

    private final int capacity;

    public ArrayQueue(int capacity) {
        this.queue = new int[capacity];
        this.end = -1;
        this.front = 0;
        this.size = 0;
        this.capacity = capacity;
    }

    //enqueue
    public void enqueue(Integer item){
        if (isFull())
            throw new IllegalStateException("The queue is full, cannot add any item");

//        if (end == capacity - 1 || isEmpty())
//            end = -1;   //move the pointer to the left
//        queue[++end] = item;
        end = (end + 1) % capacity;
        queue[end] = item;
        size++;
    }

    //dequeue
    public Integer dequeue(){
        if (isEmpty())
            throw new IllegalStateException("The queue is empty, cannot delete any item");

        var result = queue[front];

        if (!isEmpty()){
            front = (front + 1) % capacity;
        }

        size--;

        return result;
    }

    //peek
    public Integer peek(){
        if (isEmpty())
            throw new IllegalStateException("The queue is empty, cannot peek any item");

        return queue[front];
    }
    //isEmpty
    public Boolean isEmpty(){
        return this.size == 0;
    }

    //isFull
    public Boolean isFull(){
        return this.size == capacity;
    }

    @Override
    public String toString(){
        int[] content = new int[size];
        if (front <= end){
            content = Arrays.copyOfRange(queue,front,end+1);
        }
        else {
            int index = 0;
            while (front != end) {
                if (front == queue.length)
                    front = 0;
                content[index++] = queue[front++];
            }
            content[index] = queue[end];
        }
        return Arrays.toString(content);
    }
}
