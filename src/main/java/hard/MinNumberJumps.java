package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MinNumberJumps {
  public static int minNumberOfJumps(final int[] array) {
    return minNumberOfJumps(array, 0, new HashMap<>());
  }

  private static int minNumberOfJumps(final int[] array,
                                      final int i,
                                      final Map<Integer, Integer> cache) {
    if (i == array.length - 1) {
      return 0;
    } else {

      if (cache.containsKey(i)) return cache.get(i);

      final var jump = array[i];

      final var min = IntStream.rangeClosed(i + 1, Math.min(i + jump, array.length - 1))
        .map(index -> 1 + minNumberOfJumps(array, index, cache))
        .min()
        .orElse(Integer.MAX_VALUE);

      cache.put(i, min);

      return min;

    }
  }
}
