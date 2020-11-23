package mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        return IntStream.range( 0, array.size() ).boxed()
                .flatMap( i -> getPermutations( array, i, new ArrayList<>(  ), new HashSet<>(  ), new ArrayList<>(  ) ).stream())
                .collect( Collectors.toList() );
    }

    public static List<List<Integer>> getPermutations(List<Integer> array,
                                                      int index,
                                                      List<Integer> currentResult,
                                                      Set<Integer> seen,
                                                      List<List<Integer>> result) {
        List<Integer> newCurrentResult = new ArrayList<>( currentResult );
        newCurrentResult.add( array.get( index ) );

        if (array.size() == newCurrentResult.size()) {
            result.add( newCurrentResult );
            return result;
        } else {
            Set<Integer> newSeen = new HashSet<>( seen );
            newSeen.add( index );

            IntStream.range( 0, array.size() )
                    .filter( i -> !newSeen.contains( i ) )
                    .forEach( i -> getPermutations( array, i, newCurrentResult, newSeen, result ));

            return result;
        }
    }
}
