package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MinWeight {
  public int minimumWaitingTime(int[] queries) {
    final LinkedList<Integer> list = Arrays.stream(queries).boxed()
            .sorted()
            .collect(Collectors.toCollection(LinkedList::new));

    list.pollFirst();

    int result = 0;
    int previous = 0;

    for (int value : list) {
      result += previous;
      previous = previous + value;
    }

    return result;
  }
}
