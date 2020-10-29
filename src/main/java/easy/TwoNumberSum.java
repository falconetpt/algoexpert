package easy;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TwoNumberSum {

    // Option 2
    public static int[] twoNumberSum(int[] array, final int targetSum) {
        int[] newArray = array.clone();

        // O (log n)
        Arrays.sort( newArray );

        return twoNumberSum( newArray, 0, newArray.length - 1, targetSum );
    }

    private static int[] twoNumberSum(int[] newArray, int left, int right, int targetSum) {
        if (left > right) {
            return new int[0];
        } else {
            int value = newArray[right] + newArray[left];

            if (value == targetSum) {
                return new int[] { newArray[right], newArray[left] };
            } else if (value > targetSum) {
                return twoNumberSum( newArray, left, right - 1, targetSum );
            } else {
                return twoNumberSum( newArray, left + 1, right, targetSum );
            }
        }
    }

    // Option 1: Using the Map to cope with things
//    public static int[] twoNumberSum(int[] array, final int targetSum) {
//        // O(N)
//        Map<Integer, Long> numberFrequency = Arrays.stream(array).boxed()
//                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting()));
//        Predicate<Integer> hasSumCorrespondance = k -> {
//            int difference = targetSum - k;
//            long frequency = numberFrequency
//                    .getOrDefault( difference, 0L );
//            return difference == k ? frequency > 1 : frequency > 0;
//        };
//
//        // O(N)
//        return numberFrequency.keySet().stream()
//                .filter( hasSumCorrespondance )
//                .map( n -> new int[] {n, targetSum - n} )
//                .findFirst()
//                .orElse( new int[0] );
//    }

}
