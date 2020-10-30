package easy;

public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        // Write your code here.
        insertionSort( array, 1, array.length );
        return array;
    }

    private static void insertionSort(final int[] array,
                                       final int index,
                                       final int endIndex) {
        if (index < endIndex) {
            int prev = array[index - 1];
            int next = array[index];

            if (prev > next) {
                array[index - 1] = next;
                array[index] = prev;
                insertionSort( array, 1, index );
            }

            insertionSort( array, index + 1, endIndex );
        }
    }
}
