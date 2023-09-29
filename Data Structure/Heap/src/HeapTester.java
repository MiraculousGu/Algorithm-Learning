public class HeapTester {
    public static void main(String[] args) {
        Heap heap = new Heap(5);
        System.out.println("Test Insert");
        heap.insert(10);
        heap.insert(21);
        heap.insert(15);
        heap.insert(25);
        heap.insert(17);
        System.out.println(heap);;

        System.out.println("Test remove");
        System.out.println("First remove");
        heap.remove();
        System.out.println(heap);
        System.out.println("Second remove");
        heap.remove();
        System.out.println(heap);
        System.out.println("Third remove");
        heap.remove();
        System.out.println(heap);
    }
}
