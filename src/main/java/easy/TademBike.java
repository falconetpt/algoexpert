package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class TademBike {
  public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
    final Map<Boolean, Comparator<Integer>> filter = new HashMap<>();
    filter.put(true, Comparator.comparing(x -> x));
    filter.put(false, (a, b) -> - a.compareTo(b));

    final LinkedList<Integer> redShirtSorted = Arrays.stream(redShirtSpeeds)
            .boxed()
            .sorted(filter.get(false))
            .collect(Collectors.toCollection(LinkedList::new));

    final LinkedList<Integer> blueShirtSorted = Arrays.stream(blueShirtSpeeds)
            .boxed()
            .sorted(filter.get(fastest))
            .collect(Collectors.toCollection(LinkedList::new));

    return sumVelocity(blueShirtSorted, redShirtSorted);
  }

  private int sumVelocity(final LinkedList<Integer> blueShirtSorted,
                          final LinkedList<Integer> redShirtSorted) {
    if (blueShirtSorted.isEmpty()) {
      return 0;
    } else {
      final int blueValue = blueShirtSorted.pollFirst();
      final int redValue = redShirtSorted.pollFirst();

      return Math.max(blueValue, redValue)
              + sumVelocity(blueShirtSorted, redShirtSorted);
    }
  }
}
