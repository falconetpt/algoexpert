package hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubArraySort {
  public static int[] subarraySort(int[] array) {
    List<Integer> sortedArray = Arrays.stream(array).boxed().sorted().collect(Collectors.toList());
    Integer[] result = IntStream.range(0, array.length).boxed()
      .filter(i -> !sortedArray.get(i).equals(array[i]))
      .toArray(Integer[]::new);

    return result.length == 0
      ? new int[]{-1, -1}
      : new int[]{result[0], result[result.length - 1]};
  }
}
