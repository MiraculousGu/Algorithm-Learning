public class TreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        System.out.println("Test insert");
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println("Test Pre-order Traverse");
        tree.preOrderTraverse();
        System.out.println("Test In-order Traverse");
        tree.inOrderTraverse();
        System.out.println("Test Post-Order Traverse");
        tree.postOrderTraverse();
        System.out.println("Test height");
        System.out.println(tree.height());
        System.out.println("Test find");
        System.out.println(tree.find(30));
        System.out.println("Test find the minimal value");
        System.out.println(tree.min());

        System.out.println("Test equals");
        BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
        tree1.insert(7);
        tree1.insert(4);
        tree1.insert(9);
        tree1.insert(1);
        tree1.insert(6);
        tree1.insert(8);
        tree1.insert(10);
        System.out.println(tree.equals(tree1));

        System.out.println("Test find Kth distance nodes");
        System.out.println(tree.getNodesAtDistance(2));

        System.out.println("Test level traverse");
        tree.levelTraverse();
    }
}
