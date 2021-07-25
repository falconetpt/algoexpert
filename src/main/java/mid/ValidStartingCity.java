package mid;

import java.util.stream.IntStream;

public class ValidStartingCity {
  public int validStartingCity(final int[] distances,
                               final int[] fuel,
                               final int mpg) {
    return IntStream.rangeClosed(1, distances.length)
      .filter(i -> fuel[i - 1] * mpg >= distances[i % distances.length])
      .filter(i -> canGoToEveryLocation(distances, fuel, mpg, i - 1, i - 1, 0))
      .map(i -> i - 1)
      .findFirst()
      .orElse(-1);
  }

  private boolean canGoToEveryLocation(int[] distances, int[] fuel,
                                       int mpg, int start,
                                       int current, int remainingMiles) {
    int nextIndex = (current + 1) % distances.length;
    if (nextIndex == start) {
      return true;
    } else {
      final int newMiles = remainingMiles + fuel[current] * mpg
        - distances[current];

      if (newMiles >= 0) {
        return canGoToEveryLocation(distances, fuel, mpg,
          start, nextIndex, newMiles);
      } else {
        return false;
      }
    }
  }
}
