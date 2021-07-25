package mid;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicate {
  public int firstDuplicateValue(final int[] array) {
    return firstDuplicateValue(array, 0, new HashSet<>());
  }

  private int firstDuplicateValue(final int[] array, final int i, Set<Integer> seen) {
    if (i >= array.length) {
      return -1;
    } else {
      final int value = array[i];
      if (seen.contains(value)) return value;

      seen.add(value);

      return firstDuplicateValue(array, i + 1, seen);
    }
  }
}
