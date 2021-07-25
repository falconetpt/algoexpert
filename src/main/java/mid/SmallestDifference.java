package mid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmallestDifference {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
    TreeSet<Integer> treeSetOne = Arrays.stream(arrayOne).boxed()
      .collect(Collectors.toCollection(TreeSet::new));

    TreeSet<Integer> treeSetTwo = Arrays.stream(arrayTwo).boxed()
      .collect(Collectors.toCollection(TreeSet::new));


    return smallestDifference(treeSetOne, treeSetTwo, Integer.MAX_VALUE, new int[]{});
  }

  private static int[] smallestDifference(NavigableSet<Integer> treeSetOne,
                                          NavigableSet<Integer> treeSetTwo,
                                          int minValue,
                                          int[] result) {
    if (treeSetOne.isEmpty()) {
      return result;
    } else {
      int value = treeSetOne.pollFirst();
      Optional<int[]> newResult = Stream.of(treeSetTwo.floor(value), treeSetTwo.ceiling(value))
        .filter(Objects::nonNull)
        .filter(v -> Math.abs(value - v) < minValue)
        .sorted(Comparator.comparingInt(a -> Math.abs(value - a)))
        .limit(1)
        .findFirst()
        .map(v -> new int[]{value, v});

      return newResult.map(v -> smallestDifference(treeSetOne, treeSetTwo, Math.abs(v[0] - v[1]), v))
        .orElse(smallestDifference(treeSetOne, treeSetTwo, minValue, result));
    }
  }
}
