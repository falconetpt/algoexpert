package mid;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberOfWaysToTraverseGraph {
  public int numberOfWaysToTraverseGraph(int width, int height) {
    if (width == 1 || height == 1) return 1;
    // Write your code here.
    int[][] grid = new int[width][height];
    grid[0][0] = 1;
    List<Point> moves = Stream.of(
      new Point(1, 0),
      new Point(0, 1)
    ).collect(Collectors.toList());

    Queue<Point> pointQueue = new LinkedList<>(moves);

    numberOfWaysToTraverseGraph(pointQueue, moves, grid);

    return grid[width - 1][height - 1];
  }

  private void numberOfWaysToTraverseGraph(Queue<Point> pointQueue,
                                           List<Point> moves,
                                           int[][] grid) {
    if (!pointQueue.isEmpty()) {
      Point element = pointQueue.poll();
      grid[element.x][element.y] += 1;

      moves.stream()
        .map(p -> new Point(p.x + element.x, p.y + element.y))
        .filter(p -> isValid(p, grid))
        .forEach(pointQueue::add);

      numberOfWaysToTraverseGraph(pointQueue, moves, grid);
    }
  }

  private boolean isValid(Point p, int[][] grid) {
    try {
      return grid[p.x][p.y] >= 0;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }
}
