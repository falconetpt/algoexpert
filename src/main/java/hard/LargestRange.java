package hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class LargestRange {
  public static int[] largestRange(final int[] array) {
    final LinkedList<Integer> queue = Arrays.stream(array).boxed()
      .distinct()
      .sorted()
      .collect(Collectors.toCollection(LinkedList::new));


    return largestRange(queue, array, queue.peek(), queue.peek(), new int[]{queue.peek(), queue.poll()});
  }

  private static int[] largestRange(LinkedList<Integer> queue,
                                    int[] array,
                                    Integer base,
                                    Integer result,
                                    int[] integers) {
    if (queue.isEmpty()) {
      int size = integers[1] - integers[0];
      return size > result - base ? integers : new int[]{base, result};
    } else {
      int value = queue.poll();

      if (value - result == 1) {
        return largestRange(queue, array, base, value, integers);
      } else {
        int size = integers[1] - integers[0];
        return largestRange(queue, array, value, value, size > result - base ? integers : new int[]{base, result});
      }
    }
  }
}
