package easy;

import java.util.Arrays;

public class FindTheTreeLargeNumbers {
  public static int[] findThreeLargestNumbers(int[] array) {
    // Write your code here.

    return Arrays.stream(array).boxed()
      .sorted((a, b) -> -a.compareTo(b))
      .limit(3)
      .sorted()
      .mapToInt(i -> i)
      .toArray();
  }
}
