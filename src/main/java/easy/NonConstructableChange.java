package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class NonConstructableChange {
  public int nonConstructibleChange(int[] coins) {
    return nonConstructibleChange(Arrays.stream(coins).boxed().sorted().collect(Collectors.toCollection(LinkedList::new)), 0);
  }

  private int nonConstructibleChange(LinkedList<Integer> linkedList, int i) {
    if (linkedList.isEmpty()) {
      return i + 1;
    } else {
      int next = linkedList.pollFirst();
      if (next <= i + 1) {
        return nonConstructibleChange(linkedList, i + next);
      } else {
        return i + 1;
      }
    }
  }
}
