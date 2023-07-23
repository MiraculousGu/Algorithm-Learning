import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapImplementation {
    public static void main(String[] args) {
        var result = findFirstNoneRepeatedCharacter("a green apple");
        System.out.println(result);

        result = findFirstRepeatedCharaters("a green apple");
        System.out.println(result);
    }

    static Character findFirstNoneRepeatedCharacter(String str){
        str = str.toLowerCase();
        var chars = str.toCharArray();
        Map<Character,Integer> hashMap = new HashMap<>();
        for (char c: chars){
            int count = hashMap.getOrDefault(c, 0);
            hashMap.put(c,count+1);
        }

        for (char c:chars){
            if (hashMap.get(c) == 1){
                return c;
            }
        }

        return Character.MIN_VALUE;
    }

    static Character findFirstRepeatedCharaters(String str){
        var chars = str.toLowerCase().toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c: chars) {
            if (set.contains(c))
                return c;
            set.add(c);
        }

        return Character.MIN_VALUE;
    }
}
