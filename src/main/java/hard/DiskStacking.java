package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class DiskStacking {
  public static List<Integer[]> diskStacking(final List<Integer[]> disks) {
    final var newList = new LinkedList<>(disks);
    final Comparator<Integer[]> widthComparator
      = Comparator.comparing(x -> x[0]);

    final Comparator<Integer[]> depthComparator
      = widthComparator.thenComparing(x -> x[1]);

    final Comparator<Integer[]> heightComparator
      = depthComparator.thenComparing(x -> x[2]);

    newList.sort(heightComparator);

    final var result = new ArrayList<LinkedList<Integer[]>>();

    while (!newList.isEmpty()) {
      final var next = newList.pollFirst();

      final var element = new LinkedList<Integer[]>();
      element.add(next);
      result.add(element);

      for (final var value : result) {
        if (IntStream.range(0, 3).allMatch(i -> next[i] > value.getLast()[i])) {
          value.addLast(next);
        }
      }
    }

    // Write your code here.
    return result.stream()
      .max((a, b) -> a.stream().map(i -> i[2]).reduce(0, Integer::sum)
        .compareTo(b.stream().map(i -> i[2]).reduce(0, Integer::sum)))
      .orElse(new LinkedList<>());
  }
}
