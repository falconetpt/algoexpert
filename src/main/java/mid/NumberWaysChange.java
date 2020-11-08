package mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class NumberWaysChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>(  );
        map.put( 0, 1 );

        return numberOfWaysToMakeChange( 0, n, denoms, map );
    }

    private static int numberOfWaysToMakeChange(final int index,
                                                final int n,
                                                final int[] denoms,
                                                final Map<Integer, Integer> map) {
        if (index >= denoms.length) {
            return map.getOrDefault( n, 0 );
        } else {
            int coin = denoms[index];

            IntStream.rangeClosed( 1, n )
                    .filter( amount -> amount >= coin )
                    .peek( amount -> map.putIfAbsent( amount, 0 ) )
                    .forEach( amount -> map.put( amount, map.get( amount )
                            + map.getOrDefault( amount - coin, 0 ) )
                    );


            return numberOfWaysToMakeChange( index + 1, n, denoms, map );
        }
    }

}
