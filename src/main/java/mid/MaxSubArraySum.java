package mid;

public class MaxSubArraySum {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        } else {
            return maxSubsetSumNoAdjacent( array, 2, array[0], Math.max( array[0], array[1] ) );
        }
    }

    private static int maxSubsetSumNoAdjacent(int[] array, int i, int first, int sec) {
        if (i >= array.length) {
            return Math.max( first, sec );
        } else {
            return maxSubsetSumNoAdjacent( array, i + 1, sec, Math.max( first + array[i], sec ) );
        }
    }
}
