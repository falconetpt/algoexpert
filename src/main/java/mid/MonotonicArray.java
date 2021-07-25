package mid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MonotonicArray {
  public static boolean isMonotonic(int[] array) {
    List<Integer> ascSortedList = Arrays.stream(array).boxed()
      .sorted().collect(Collectors.toList());
    List<Integer> desSortedList = Arrays.stream(array).boxed()
      .sorted((a, b) -> -a.compareTo(b)).collect(Collectors.toList());

    return IntStream.range(0, array.length).allMatch(i -> ascSortedList.get(i) == array[i])
      || IntStream.range(0, array.length).allMatch(i -> desSortedList.get(i) == array[i]);
  }
}
