package mid;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumPassesOfMatrix {

  private static final List<Point> MOVES = List.of(
    new Point(0, 1),
    new Point(0, -1),
    new Point(1, 0),
    new Point(-1, 0)
  );

  public int minimumPassesOfMatrix(final int[][] matrix) {

    final var negativeNumberCoordinates = IntStream.range(0, matrix.length)
      .boxed()
      .flatMap(x -> IntStream.range(0, matrix[x].length).mapToObj(y -> new Point(x, y)))
      .filter(p -> matrix[p.x][p.y] < 0)
      .collect(Collectors.toSet());

    var result = 0;

    while (negativeNumberCoordinates.size() > 0) {
      final var size = negativeNumberCoordinates.size();

      final var toRemove = negativeNumberCoordinates.stream()
        .filter(p -> hasPositiveNeighboors(p, matrix))
        .collect(Collectors.toList());

      toRemove
        .stream()
        .peek(p -> matrix[p.x][p.y] *= -1)
        .forEach(negativeNumberCoordinates::remove);

      if (size == negativeNumberCoordinates.size()) return -1;
      result++;
    }

    return result;
  }

  private boolean hasPositiveNeighboors(final Point point, final int[][] matrix) {
    return MOVES.stream()
      .map(p -> new Point(p.x + point.x, p.y + point.y))
      .filter(p -> isValidPoint(p, matrix))
      .anyMatch(p -> matrix[p.x][p.y] > 0);
  }

  private boolean isValidPoint(final Point p, final int[][] matrix) {
    try {
      return matrix[p.x][p.y] > 0;
    } catch (final Exception e) {
      return false;
    }
  }
}
