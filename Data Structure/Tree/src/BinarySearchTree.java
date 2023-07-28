import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    private class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }

        public Node() {
            leftChild = new Node<>();
            rightChild = new Node<>();
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Node = " + getValue();
        }
    }

    public BinarySearchTree() {
        size = 0;
        root = null;
    }

    public void insert(T value) {
        var node = new Node<>(value);
        if (size == 0) {
            root = node;
            size++;
            return;
        }

        Node<T> current = root;
        while (true) {
            if (current.getValue().equals(value))
                return;
            if (current.getValue().compareTo(value) > 0)
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                } else
                    current = current.leftChild;

            else if (current.rightChild == null) {
                current.rightChild = node;
                break;
            } else
                current = current.rightChild;
        }
        size++;
    }

    public Boolean find(T value) {
        Node<T> current = root;
        while (current != null) {
            if (current.getValue().equals(value))
                return true;

            if (current.getValue().compareTo(value) < 0)
                current = current.rightChild;
            else
                current = current.leftChild;
        }

        return false;
    }

    public void preOrderTraverse() {
        preOrderTraverse(root);
    }

    private void preOrderTraverse(Node<T> root) {
        if (root == null)
            return;

        System.out.println(root.value);
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }

    public void inOrderTraverse() {
        inOrderTraverse(root);
    }

    private void inOrderTraverse(Node<T> root) {
        if (root == null)
            return;

        inOrderTraverse(root.leftChild);
        System.out.println(root.value);
        inOrderTraverse(root.rightChild);
    }

    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    private void postOrderTraverse(Node<T> root) {
        if (root == null)
            return;

        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node<T> root) {
        if (root == null)
            return -1;

        if (root.leftChild == null && root.rightChild == null)
            return 0;

        return 1 + Math.max(
                height(root.leftChild),
                height(root.rightChild)
        );
    }

    public T min() {
        return min(root);
    }

    private T min(Node<T> root) {
        if (root == null)
            return null;

        if (isLeaf(root))
            return root.getValue();

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        if (left == null)
            return right;
        if (right == null)
            return left;

        return left.compareTo(right) > 0 ? right : left;
    }

    public Boolean isLeaf(Node<T> node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public Boolean equals(BinarySearchTree<T> otherTree) {
        if (otherTree == null)
            return false;
        return equals(this.root, otherTree.root);
    }

    private Boolean equals(Node<T> root, Node<T> otherRoot) {
        if (root == null && otherRoot == null)
            return true;

        if (root != null && otherRoot != null) {
            return root.getValue().equals(otherRoot.getValue())
                    && equals(root.leftChild, otherRoot.leftChild)
                    && equals(root.rightChild, otherRoot.rightChild);
        }

        return false;
    }

    public ArrayList<T> getNodesAtDistance(int distance){
        if (root == null){
            System.out.println("The tree is empty.");
            return null;
        }
        ArrayList<T> list = new ArrayList<>();
        getNodesAtDistance(root,distance,list);
        return list;
    }

    private void getNodesAtDistance(Node<T> root, int distance, ArrayList<T> list){
        if (distance == 0) {
            list.add(root.getValue());
            return;
        }

        if (isLeaf(root)){
            return;
        }

        if (root.leftChild != null)
            getNodesAtDistance(root.leftChild,distance-1, list);
        if (root.rightChild != null)
            getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void levelTraverse(){
        var height = height();
        for (int i = 0; i <= height; i++)
            for (var value: getNodesAtDistance(i))
                System.out.println(value);
    }
}
