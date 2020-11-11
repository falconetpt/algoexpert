package mid;

public class KandaneAlgorithm {
    public static int kadanesAlgorithm(int[] array) {
        // Write your code here.
        int maxLocal = array[0];
        int maxTotal = array[0];

        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            maxLocal = Math.max( num + maxLocal, num );
            maxTotal = Math.max( maxLocal, maxTotal );
        }

        return maxTotal;
    }
}
