package mid;

public class ArrayOfProducts {
    public int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];

        int left = 1;

        for (int i = 0; i < array.length; i++) {
            result[i] = left;
            left *= array[i];
        }

        int right = 1;

        for (int i = array.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= array[i];
        }

        return result;
    }
}
