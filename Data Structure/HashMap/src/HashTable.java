import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class HashTable {

    private LinkedList<EntrySet>[] table;
    private final int DEFAULT_VALUE = 10;
    private int capacity = DEFAULT_VALUE;

    private class EntrySet{
        private int key;
        private String value;

        public EntrySet(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public HashTable() {
        table = new LinkedList[capacity];
    }

    public HashTable(int capacity){
        this.capacity = capacity;
        table = new LinkedList[this.capacity];
    }

    //put
    public void put (int key, String value){
        EntrySet set = findEntry(key);
        if (set !=null) {
            set.setValue(value);
            return;
        }

        findOrCreateBucket(key).addLast(new EntrySet(key,value));
    }

    //get
    public String get(int key){
        EntrySet set = findEntry(key);
        return set == null ? null : set.getValue();
    }

    //remove
    public void remove(int key){
        EntrySet set = findEntry(key);
        if (set == null)
            throw new IllegalArgumentException("The key doesn't exist");

        findOrCreateBucket(key).remove(set);
    }

    //hash function
    private int hash(int key){
        return key % capacity;
    }


    private EntrySet findEntry(int key){
        var bucket = findOrCreateBucket(key);
        if (bucket != null)
            for (EntrySet set: bucket)
                if (set.getKey() == key)
                    return set;

        return null;
    }

    private LinkedList<EntrySet> findOrCreateBucket(int key){
         var bucket = table[hash(key)];
         if (bucket == null)
             table[hash(key)] = new LinkedList<>();
         return bucket;
    }


    @Override
    public String toString(){
        ArrayList<String> result = new ArrayList<>();
        for (LinkedList<EntrySet> list:table)
            if (list != null)
                for (EntrySet set: list)
                    result.add(set.getValue());

        return result.toString();
    }
}
