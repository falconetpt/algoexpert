package mid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ThreeNumberSort {
    public int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>(  );

        IntStream.range( 0, order.length ).forEach( i -> map.put( order[i], i ) );

        return Arrays.stream( array ).boxed()
                .sorted( Comparator.comparing( map::get ) )
                .mapToInt( i -> i )
                .toArray();
    }
}
