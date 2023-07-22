import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Test reverse function with Java built-in queue");
        reverse(queue);
        System.out.println(queue);

        System.out.println("Test the array-implementation queue");
        ArrayQueue arrayQueue = new ArrayQueue(5);

        System.out.println("Test enqueue");
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        System.out.println(arrayQueue);

        System.out.println("Test dequeue");
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        System.out.println(arrayQueue);

        System.out.println("Test enqueue edge case");
        arrayQueue.enqueue(60);
        arrayQueue.enqueue(70);
        System.out.println(arrayQueue);

        System.out.println("Test the Stack-implementation queue");
        StackQueue<Integer> stackQueue = new StackQueue<>(5);

        System.out.println("Test enqueue");
        stackQueue.enqueue(10);
        stackQueue.enqueue(20);
        stackQueue.enqueue(30);
        stackQueue.enqueue(40);
        System.out.println(stackQueue);

        System.out.println("Test dequeue");
        stackQueue.dequeue();
        stackQueue.dequeue();
        System.out.println(stackQueue);

        System.out.println("Test peek");
        System.out.println(stackQueue.peek());
    }

    public static void reverse(Queue<Integer> queue){
        if (queue.isEmpty())
            return;

        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty())
            stack.push(queue.remove());

        while(!stack.isEmpty())
            queue.add(stack.pop());
    }
}
