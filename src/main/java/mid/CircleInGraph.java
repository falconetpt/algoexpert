package mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class CircleInGraph {
  public boolean cycleInGraph(final int[][] edges) {
    final Map<Integer, Boolean> map = new HashMap<>();
    return IntStream.range(0, edges.length)
      .anyMatch(x -> !noCircle(edges, x, new HashSet<>(), map));
  }

  private boolean noCircle(final int[][] edges,
                           final int index,
                           final Set<Integer> seen,
                           final Map<Integer, Boolean> map) {
    if (edges[index].length == 0) {
      return true;
    } else if (seen.contains(index)) {
      map.put(index, false);
      return false;
    } else if(map.containsKey(index)) {
      return map.get(index);
    } else {
      seen.add(index);
      final boolean isIndexCircle = Arrays.stream(edges[index])
        .allMatch(x -> noCircle(edges, x, new HashSet<>(seen), map));
      System.out.println(isIndexCircle);
      map.put(index, isIndexCircle);
      return isIndexCircle;
    }
  }
}
