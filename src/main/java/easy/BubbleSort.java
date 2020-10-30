package easy;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        // Write your code here.
        bubbleSort( array, 1, false );
        return array;
    }

    private static void bubbleSort(int[] array, int i, boolean reset) {
        if (i >= array.length) {
            if (reset) bubbleSort( array, 1, false );
        } else {
            int prev = array[i-1];
            int next = array[i];

            if (prev > next) {
                array[i-1] = next;
                array[i] = prev;

                bubbleSort( array, i + 1,  true);
            } else {
                bubbleSort( array, i + 1,  reset);
            }

        }
    }
}
