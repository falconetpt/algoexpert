package mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PowerSet {
  public static List<List<Integer>> powerset(final List<Integer> array) {
    final var result = new HashSet<Set<Integer>>();

    result.add(Collections.emptySet());
    array.forEach(i -> addToSet(result, i));

    return result.stream()
      .map(ArrayList::new)
      .collect(Collectors.toList());
  }

  private static void addToSet(final Set<Set<Integer>> result, final int value) {
    final var newSetValue = result.stream()
      .map(i -> {
        final var newSet = new HashSet<>(i);
        newSet.add(value);
        return newSet;
      }).collect(Collectors.toSet());
    result.addAll(newSetValue);
  }
}
