package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MergeOverlappingIntervals {
  public int[][] mergeOverlappingIntervals(int[][] intervals) {
    final LinkedList<int[]> linkedList = Arrays.stream(intervals)
      .sorted(Comparator.comparingInt(a -> a[0]))
            .collect(Collectors.toCollection(LinkedList::new));
    final List<int[]> result = new ArrayList<>();

    int[] previous = linkedList.pollFirst();
    result.add(previous);

    while (!linkedList.isEmpty()) {
      final int[] current = linkedList.pollFirst();

      if (previous[1] >= current[0]) {
        previous[0] = Math.min(previous[0], current[0]);
        previous[1] = Math.max(previous[1], current[1]);
      } else {
        result.add(current);
        previous = current;
      }
    }

    return result.stream().toArray(int[][]::new);
  }
}
