package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeNumberSum {
  // O(n^2)
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
    List<Integer[]> result = new ArrayList<>();

    int[] sortedArray = array.clone();
    Arrays.sort(sortedArray);
    Set<Integer> numbers = Arrays.stream(array).boxed()
      .collect(Collectors.toSet());

    BiFunction<Integer, Integer, Integer> calculateDif = (start, end)
      -> targetSum - sortedArray[start] - sortedArray[end];

    BiPredicate<Integer, Integer> predicate = (start, end) -> {
      int value = calculateDif.apply(start, end);
      return numbers.contains(value) && value > sortedArray[start] && value < sortedArray[end];
    };


    return IntStream.range(0, sortedArray.length).boxed()
      .flatMap(x -> IntStream.range(x + 2, sortedArray.length).boxed()
        .sorted((a, b) -> -a.compareTo(b))
        .filter(y -> predicate.test(x, y))
        .map(y -> new Integer[]{sortedArray[x], calculateDif.apply(x, y), sortedArray[y]})
      ).collect(Collectors.toList());
  }
}
