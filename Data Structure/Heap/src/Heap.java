import java.util.Arrays;

public class Heap {
   private int[] heap;
   int size;
   private final int DEFAULT_CAPACITY = 10;
   private int capacity;

   public Heap(){
       heap = new int[DEFAULT_CAPACITY];
       size = 0;
   }

   public Heap(int capacity){
       this.capacity = capacity;
       heap = new int[capacity];
       size = 0;
   }

   public void insert(int item){
       if (isFull())
           return;

       //first of all, add to the leaf
       heap[size] = item;

       bubbleUp(size);
       size++;
   }

    private void bubbleUp(int position) {
        //check if you need to bubble up
        int item = heap[position];
        int current = position;
        int parent = (position - 1) / 2;
        while (item > heap[parent] && current > 0){
            //swap item and parent
            swap(current,parent);
            current = parent;
            parent = (current - 1) / 2;
        }
    }

    //heap can only support root removal
   public int remove(){
       if (isEmpty())
           return 0;
       //swap the leaf with the root
       swap(size-1,0);

       //clean the value
       heap[size-1] = 0;

       //bubble down?
       int position = 0;    //from the root
       int result = heap[position];
       bubbleDown(position);
       size--;

       return result;
   }

    private void bubbleDown(int position) {

        boolean correct = isValidParent(position,largerChild(position));

        while (!correct && hasLeftChild(position)){
            swap(position,largerChild(position));
            //move the index
            position = position * 2 + 1;
            correct = isValidParent(position, largerChild(position));
        }
    }

    private boolean hasLeftChild(int position){
       return leftChildIndex(position) < size;
    }

    private boolean hasRightChild(int position){
       return rightChildIndex(position) < size;
    }

    private int largerChild(int position){
       if (!hasLeftChild(position))
           return position;

       int left = leftChildIndex(position);

       if (!hasRightChild(position))
           if (heap[left] > heap[position])
               return left;

       int right = rightChildIndex(position);

       return heap[left] > heap[right] ? left : right;
    }

    private boolean isValidParent(int position, int child) {
        return heap[position] > heap[child];
    }

    private int rightChildIndex(int position) {
        int right;
        right = position * 2 + 2;
        return right;
    }

    private int leftChildIndex(int position) {
        int left;
        left = position * 2 + 1;
        return left;
    }

    public Boolean isEmpty(){
       return size == 0;
   }

   public Boolean isFull(){
       return size == capacity;
   }

   private void swap(int first, int second){
       int temp = heap[first];
       heap[first] = heap[second];
       heap[second] = temp;
   }


   @Override
    public String toString(){
       return Arrays.toString(heap);
   }
}
