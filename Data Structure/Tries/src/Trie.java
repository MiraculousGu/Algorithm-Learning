import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private class Node{
        public static final int ALPHABET_SIZE = 26;
        private char value;
        private HashMap<Character,Node> children = new HashMap<>(ALPHABET_SIZE);
        private boolean isEndOfWord;

        public Node() {
            this.isEndOfWord = false;
        }

        public Node(char value) {
            this.value = value;
            this.isEndOfWord = false;
        }

        public boolean hasChild(char ch){
            return this.children.containsKey(ch);
        }

        public boolean hasChild(){
            return !children.isEmpty();
        }

        public Node getChild(char ch){
            return this.children.get(ch);
        }

        public void add(char ch){
            this.children.put(ch, new Node(ch));
        }

        public void remove(char ch){
            children.remove(ch);
        }

        public Node[] getAllNodes(){
            return children.values().toArray(new Node[0]);
        }
        @Override
        public String toString() {
            return "value= " + value;
        }
    }

    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word){
        var current = root;

        for (char ch: word.toCharArray()){
            if (!current.hasChild(ch))
                current.add(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word){
        if (word == null || word.isBlank()){
            System.out.println("Invalid argument");
            return false;
        }

        var current = root;
        for(char ch: word.toCharArray()){
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse(){
        traverse(root);
    }

    private void traverse(Node node){
        System.out.println(node.value);
        //pre-order traverse
        for(Node child: node.getAllNodes())
            traverse(child);
    }

    public void remove(String word){
        if (word == null || word.isBlank()){
            System.out.println("Word doesn't exist or Invalid input");
            return;
        }
        remove(word,0,root);
    }

    private void remove(String word, int index, Node current){
        if (index == word.length() && current.isEndOfWord){
            current.isEndOfWord = false;
            return;
        }
        char ch = word.charAt(index++);
        if (!current.hasChild(ch)){
            System.out.println("Word doesn't exist");
            return;
        }
        var next = current.getChild(ch);
        remove(word,index,next);

        if (!next.isEndOfWord && !next.hasChild()){
            current.remove(ch);
        }
    }

    public void findWords(String prefix){
        List<String> words = new ArrayList<>();
        findWords(prefix,words);
        System.out.println(Arrays.toString(words.toArray()));
    }

    private List<String> findWords(String prefix, List<String> words){
        var start = findLastNodeOf(prefix); //last node of the prefix
        if (start == null)
            return null;
        if (start.isEndOfWord)
            words.add(prefix);

        for (Node current: start.getAllNodes()){
            findWords(prefix+current.value, words);
        }
        return words;
    }

    private Node findLastNodeOf(String prefix){
        var curent = root;
        for (char ch: prefix.toCharArray()) {
            var child = curent.getChild(ch);
            if (child == null)
                return null;
            curent = child;
        }

        return curent;
    }

    @Override
    public String toString() {
        traverse();
        return "Above is the trie";
    }
}
