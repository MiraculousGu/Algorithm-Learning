public class TestArray {
    static Array<Integer> array = new Array<>(3);
    public static void main(String[] args) {
        testInsertion();
        testRemove();
        testIndexOf();
        testMax();
        testReverse();
        testInsertAt();

    }

    @Test
    public static void testInsertion(){
        System.out.println("Test Insertion:");
        //test insertion
        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);
        array.insert(7);
        array.insert(9);
        //test print
        array.print();
    }

    @Test
    public static void testRemove(){
        System.out.println("Test Remove:");
        //test remove
        array.removeAt(1);

        //test print
        array.print();
    }

    @Test
    public static void testIndexOf(){
        System.out.println("Test IndexOf");
        System.out.println(array.indexOf(3));
    }

    @Test
    public static void testMax(){
        System.out.println("Test find max");
        System.out.println(array.max());
    }

    @Test
    public static void testReverse(){
        System.out.println("Test Reverse: ");
        Array<Integer> result = array.reverse();
        result.print();
    }

    @Test
    public static void testInsertAt(){
        System.out.println("Test InsertAt: ");
        array.insertAt(99,2);
        array.print();
    }

}
