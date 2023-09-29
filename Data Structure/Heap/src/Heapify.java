import java.util.Arrays;

public class Heapify {

    public static int[] heapify(int[] ar){
        int lastParent = ar.length / 2 - 1;
        for (int i = lastParent; i >= 0; i--)
            bubbleDown(ar, i);

        return ar;
    }

    private static void bubbleDown(int[] ar, int position){
        int larger = largerChild(ar, position);
        while(position < ar.length - 1 && ar[position] < ar[larger]){
            swap(ar, position, larger);
            position = position * 2 + 1;
            larger = largerChild(ar, position);
        }
    }

    private static void swap(int[] ar, int first, int second){
        int temp = ar[first];
        ar[first] = ar[second];
        ar[second] = temp;
    }

    private static int leftChildIndex(int position){
        return position * 2 + 1;
    }

    private static int rightChildIndex(int position){
        return position * 2 + 2;
    }

    private static boolean hasLeftChild(int[] ar, int position){
        return leftChildIndex(position) < ar.length;
    }

    private static boolean hasRightChild(int[] ar, int position){
        return rightChildIndex(position) < ar.length;
    }

    private static int largerChild(int[] ar, int position){
        if (!hasLeftChild(ar,position))
            return position;

        int left = leftChildIndex(position);

        if (!hasRightChild(ar,position))
            if (ar[left] > ar[position])
                return left;
            else
                return position;

        int right = rightChildIndex(position);
        return ar[left] > ar[right] ? left : right;
    }

    private static void heapify(int[] ar, int index){
        int largerIndex = index;
        var leftIndex = index * 2 + 1;
        if (leftIndex < ar.length - 1 && ar[largerIndex] < ar[leftIndex]){
            largerIndex = leftIndex;
        }
        var rightIndex = index * 2 + 2;
        if (rightIndex < ar.length - 1 && ar[largerIndex] < ar[rightIndex]){
            largerIndex = rightIndex;
        }

        if (index == largerIndex)
            return;

        swap(ar,index,largerIndex);
        heapify(ar,largerIndex);
    }
}
