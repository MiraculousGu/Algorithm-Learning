import java.util.Comparator;

public class Array <T extends Comparable<T>> {
    private T[] items;
    private int count;

    @SuppressWarnings("unchecked")
    public Array(int length) {
        this.items = (T[]) new Comparable[length];
        count = 0;
    }


    public void insert(T item){
        if (count == items.length){
            resizeArray();
        }

        items[count++] = item;
    }

    public void removeAt(int index){
        //validation
        if(index < 0 || index>= count){
            throw new IllegalArgumentException();
        }

        //remove by shifting
        for(int i = index; i < count-1; i++)
            items[i] = items[i+1];

        items[count-1] = null;
        //update the size
        count--;
    }

    public T get(int index){
        if (index < 0 || index >=count)
            throw new IllegalArgumentException("Out of array bounds");

        return items[index];
    }

    public int indexOf(T item){
        for(int i = 0; i < count; i++)
            if (items[i].equals(item))
                return i;

        return -1;
    }

    public void print(){
        for(int i = 0; i < count; i++){
            System.out.println(items[i]);
        }
    }

    public T max(){
      T max = items[0];

      for(int i = 0; i < count; i++){
          if (items[i].compareTo(max) > 0){
            max = items[i];
          }
      }

      return max;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public T[] intersect(T[] list){
        T[] result = (T[]) new Comparable[count];
        int i = 0;
        for(T item: list)
            if (indexOf(item) != -1)
                result[i++] = item;

        return result;
    }

    public Array<T> reverse(){
        Array<T> result = new Array<>(items.length);
        int j = 0;
        for(int i = count - 1; i >= 0; i--)
            result.insert(items[i]);

        return result;
    }

    public void insertAt(T item, int index){
        if (index >= count || index < 0)
            throw new IllegalArgumentException("Insert position is out of the array bounds");

        if (count == items.length){
            resizeArray();
        }

        //need to traverse in reverse order
        //if traverse in normal order, the previous items will be the 2nd item
        for (int i = count; i > index; i--){
            items[i] = items[i-1];
        };

        items[index] = item;
        count++;
    }

    private void resizeArray(){
        //resize the array
        int index = 0;
        T[] newItems = (T[]) new Comparable[items.length * 2];
        for(T element: items)
            newItems[index++] = element;
        items = newItems;
    }

}
