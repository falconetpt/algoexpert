package mid;

import java.util.stream.IntStream;

public class LongestPeek {
    public static int longestPeak(int[] array) {
        // Write your code here.
        return IntStream.range( 2, array.length ).boxed()
                .map( i -> i - 1 )
                .filter( i -> array[i] > array[i-1] && array[i] > array[i+1] )
                .map( i -> 1 + getUphill(array, i + 1, array[i]) + getDownhill(array, i - 1, array[i]) )
                .reduce( 0, Math::max );
    }

    private static int getDownhill(int[] array, int i, int value) {
        if (i < 0 || array[i] >= value) {
            return 0;
        } else {
            return 1 + getDownhill( array, i - 1, array[i] );
        }
    }

    private static int getUphill(int[] array, int i, int value) {
        if (i >= array.length || array[i] >= value) {
            return 0;
        } else {
            return 1 + getUphill( array, i + 1, array[i] );
        }
    }
}
