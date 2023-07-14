public class LinkedListTest {
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("Test addFirst");
        //test addFirst
        list.addFirst(0);
        list.addFirst(5);
        list.addFirst(1);
        System.out.println(list.toArray());

        //test addLast
        System.out.println("Test addLast");
        list.addLast(10);
        list.addLast(99);
        System.out.println(list.toArray().toString());

        //test deleteFirst
        System.out.println("Test delete first");
        list.deleteFirst();
        System.out.println(list.toArray().toString());
        //test deleteLast
        System.out.println("Test delete last");
        list.deleteLast();
        System.out.println(list.toArray().toString());

        //test contains
        System.out.println("Test contains");
        System.out.println("If the linkedList contains " + 0);
        System.out.println(list.contains(0));

        //test indexOf
        System.out.println("Test indexOf");
        System.out.println("The index of 10 is " + list.indexOf(10));

    }
}
