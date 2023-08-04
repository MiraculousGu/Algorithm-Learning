public class AVLTest {
    public static void main(String[] args) {

        AVL<Integer> avl = new AVL<>();
        System.out.println("Test Insert");
//        avl.insert(12);
//        avl.insert(3);
//        avl.insert(9);
//        avl.insert(4);
//        avl.insert(6);
//        avl.insert(2);
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.insert(5);
        avl.displayTree();
    }
}
