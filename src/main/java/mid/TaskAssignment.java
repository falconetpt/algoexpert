package mid;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskAssignment {
  public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
    java.util.LinkedList<Point> values = IntStream.range(0, tasks.size()).boxed()
      .map(i -> new Point(tasks.get(i), i))
      .sorted(Comparator.comparingInt(a -> a.x))
      .collect(Collectors.toCollection(java.util.LinkedList::new));


    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      ArrayList<Integer> local = new ArrayList<>();
      local.add(values.pollFirst().y);
      local.add(values.pollLast().y);

      result.add(local);
    }

    // Write your code here.
    return result;
  }
}
