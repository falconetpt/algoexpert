package easy;

import java.util.List;

public class ProductSum {
    public static int productSum(List<Object> array) {
        // Write your code here.
        return productSum( array, 1, 0);
    }

    @SuppressWarnings (value="unchecked")
    private static int productSum(final List<Object> array,
                                  final int level,
                                  final int index) {
        if (index >= array.size()) {
            return 0;
        } else {
            Object value = array.get( index );

            if (value instanceof List) {
                List<Object> listValue = (List<Object>) value;
                int newValue = productSum( listValue, level + 1, 0 );
                return (level + 1) * newValue + productSum( array, level, index + 1 );
            } else {
                return (int) value + productSum( array, level, index + 1 );
            }
        }
    }
}
