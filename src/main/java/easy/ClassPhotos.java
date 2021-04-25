package easy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClassPhotos {
  public boolean classPhotos(
    final List<Integer> redShirtHeights,
    final List<Integer> blueShirtHeights) {
    final List<Integer> sortedRed = redShirtHeights.stream()
      .sorted()
      .collect(Collectors.toList());
    final List<Integer> sortedBlue = blueShirtHeights.stream()
      .sorted()
      .collect(Collectors.toList());

    return Math.abs(IntStream.range(0, sortedBlue.size())
      .filter(i -> !sortedBlue.get(i).equals(sortedRed.get(i)))
      .map(i -> sortedBlue.get(i) > sortedRed.get(i) ? 1 : -1)
      .sum()) == sortedBlue.size();
  }
}
