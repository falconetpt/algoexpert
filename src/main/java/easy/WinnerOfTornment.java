package easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinnerOfTornment {
  public String tournamentWinner(
          ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    Map<String, Long> x = IntStream.range(0, competitions.size()).boxed()
            .map(i -> results.get(i) == 0 ? competitions.get(i).get(1) : competitions.get(i).get(0))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return x.keySet().stream()
            .sorted((a, b) -> x.get(b).compareTo(x.get(a)))
            .findFirst()
            .orElse("");
  }
}
