package hard;

import java.util.stream.IntStream;

public class SearchForRange {
  public static int[] searchForRange(int[] array, int target) {
    final var result  = IntStream.range(0, array.length)
      .filter(i -> array[i] == target)
      .toArray();

    return result.length == 0
      ? new int[] { -1, -1 }
      : new int[] {result[0], result[result.length - 1]};
  }
}
