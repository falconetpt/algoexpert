package mid;

import java.util.List;
import java.util.stream.Stream;

public class SortStack {
  public List<Integer> sortStack(List<Integer> stack) {
    final Stream<Integer> stream = stack.stream()
      .sorted();

    stream.peek(i -> stack.remove(0))
      .forEach(stack::add);

    return stack;
  }
}
