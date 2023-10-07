import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();

        System.out.println("Test insert");
        trie.insert("boy");
        trie.insert("care");
        trie.insert("car");
        trie.insert("card");
        trie.insert("careful");
        trie.insert("boat");

        System.out.println("Test contains");
        System.out.println(trie.contains("boy"));
        System.out.println(trie.contains("boi"));
        System.out.println(trie.contains(null));
        System.out.println(trie.contains(""));

        System.out.println("Test Traverse");
        trie.traverse();

        System.out.println("Test Remove");
        trie.remove("boi");
        System.out.println(trie.contains("car"));

        System.out.println("Test auto complete");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the prefix");
        String input = scanner.nextLine();
        trie.findWords(input);
    }
}
