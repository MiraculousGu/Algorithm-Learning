import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedList <T>{

    private class Node <T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
    private Node<T> first;
    private Node<T> last;

    int size;

    public LinkedList() {
        first = null;
        last = first;
        this.size = 0;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }


    //addFirst
    public void addFirst(T item){
        var node = new Node<>(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        //update the size
        size++;

    }

    //addLast
    public void addLast(T item){
        var node = new Node<>(item);
        if (isEmpty())
            //only node
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        //update the size
        size++;
    }

    //deleteFirst
    public void deleteFirst(){
        if (isEmpty())
            throw new NoSuchElementException("The linked list is empty");

        if (size == 1){
            first = last = null;    //only single element in the Linked List
            size--;
            return;
        }
        var second = first.getNext();
        first.next = null;          //remove the link to make sure it's got deleted from the memory
        first = second;
        size--;
    }

    //deleteLast
    public void deleteLast(){
        if (isEmpty())
            throw new NoSuchElementException("The linked list is empty");

        if (size == 1){
            first = last = null;    //only single element in the Linked List
            size--;
            return;
        }

        var temp = first;
        while (temp.getNext() != last)
            temp = temp.getNext();

        //delete the last node
        temp.setNext(null);
        last = temp;
        size--;
    }

    //indexOf
    public int indexOf(T item){
        int index = 0;
        Node<T> temp = first;
        while (temp != null){
            if (temp.getValue().equals(item)) return index;
            temp = temp.getNext();
            index++;
        }

        return -1;
    }

    //contains
    public boolean contains(T item){
        return indexOf(item) != -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public ArrayList<T> toArrayList(){
        Node<T> temp = first;
        ArrayList<T> result = new ArrayList<>();
        while (temp != null){
            result.add(temp.getValue());
            temp = temp.getNext();
        }

        return result;
    }

    public int size(){
        return size;
    }

    public void reverse(){
        var arrlist = this.toArrayList();
        int index = this.size() - 1;
        first = new Node<>(arrlist.get(index--));
        Node temp = first;
        while(index >= 0){
            Node<T> node = new Node<>(arrlist.get(index--));
            temp.next = node;
            temp = temp.next;
        }
        last = temp;
        last.next = null;
    }
}
