public class Test {
    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put(1,"BMW");
        table.put(2,"Subaru");
        table.put(3,"Benz");
        table.put(4,"Toyota");
        table.put(1,"Honda");
        //table.remove(1);
        System.out.println(table.get(1));
    }
}
