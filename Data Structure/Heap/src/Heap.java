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

       if (isEmpty()){
           heap[size++] = item;
           return;
       }

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
        while (item > heap[parent]){
            //swap item and parent
            swap(current,parent);
            current = parent;
            parent = (current - 1) / 2;
        }
    }

    //heap can only support root removal
   public void remove(){
       //swap the leaf with the root
       swap(size-1,0);

       //clean the value
       heap[size-1] = 0;

       //bubble down?
       int position = 0;    //from the root
       bubbleDown(position);
       size--;
   }

    private void bubbleDown(int position) {
        int left = 1;
        int right = 2;
        boolean correct = heap[position] > heap[left] && heap[position] > heap[right];

        while (!correct && left < size - 1){
            if (heap[left] > heap[right])
                swap(position,left);
            else
                swap(position,right);

            position = position * 2 + 1;
            left = position * 2 + 1;
            right = position * 2 + 2;
            correct = heap[position] > heap[left] && heap[position] > heap[right];
        }
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
