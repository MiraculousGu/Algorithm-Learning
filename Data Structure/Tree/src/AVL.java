public class AVL<T extends Comparable<T>> {
    private class Node<T> {
        Node<T> leftChild;
        Node<T> rightChild;
        T value;
        int height;

        public Node(T value) {
            this.value = value;
            height = 0;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "value = " + getValue() + " height: " + height;
        }
    }

    private Node<T> root;

    public void insert(T value) {
        root = insert(this.root, value);
    }

    private Node<T> insert(Node<T> root, T value) {
        if (root == null)
            return new Node<>(value);

        if (root.getValue().equals(value))
            return null;
        else if (root.getValue().compareTo(value) > 0)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        setHeight(root);
        return balance(root);
    }


    private Node<T> balance(Node<T> root) {
        if (isLeftHeavy(root)) {
            if (getBalanceFactor(root.leftChild) < 0)
                root.leftChild = leftRotate(root.leftChild);
            root = rightRotate(root);
        } else if (isRightHeavy(root)) {
            if (getBalanceFactor(root.rightChild) > 0)
                root.rightChild = rightRotate(root.rightChild);
            root = leftRotate(root);
        }
        return root;
    }

    private int getBalanceFactor(Node<T> root) {
        return getHeight(root.leftChild) - getHeight(root.rightChild);
    }

    private Node<T> leftRotate(Node<T> root) {
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private Node<T> rightRotate(Node<T> root) {
        var newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    public void displayTree() {
        displayTree(root);
    }

    private void displayTree(Node<T> root) {
        if (root == null)
            return;

        System.out.println(root);
        displayTree(root.leftChild);
        displayTree(root.rightChild);
    }

    private Boolean isLeftHeavy(Node<T> root) {
        return getBalanceFactor(root) > 1;
    }

    private Boolean isRightHeavy(Node<T> root) {
        return getBalanceFactor(root) < -1;
    }

    private Boolean isLeaf(Node<T> node) {
        return node.leftChild == null && node.rightChild == null;
    }

    private int getHeight(Node<T> node) {
        return node == null ? -1 : node.getHeight();
    }

    private void setHeight(Node<T> root) {
        root.height = Math.max(
                getHeight(root.leftChild),
                getHeight(root.rightChild)) + 1;
    }

}
