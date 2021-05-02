package mid;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZigZagTraversal {

  public static final Point MOVE = new Point(-1, 1);

  public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
    final Queue<Point> moves = Stream.of(
      new Point(1, 0),
      new Point(0, 1)
    ).collect(Collectors.toCollection(LinkedList::new));


    return zigZagTraverse(
      array,
      moves,
      new Point(0,0),
      new ArrayList<>(),
      -1
    );
  }

  private static List<Integer> zigZagTraverse(final List<List<Integer>> array,
                                              final Queue<Point> moves,
                                              final Point point,
                                              final List<Integer> result,
                                              int positive) {
    if (moves.isEmpty()) {
      return result;
    } else {

      final LinkedList<Integer> localResult = new LinkedList();
      Point localPoint = point;

      while (isValidPoint(localPoint, array)) {
        if (positive > 0) {
          localResult.addLast(array.get(localPoint.x).get(localPoint.y));
        } else {
          localResult.addFirst(array.get(localPoint.x).get(localPoint.y));
        }

        localPoint = new Point(localPoint.x + MOVE.x, localPoint.y + MOVE.y);
      }

      result.addAll(localResult);

      final Point nextMove = moves.peek();
      final Point newPoint = new Point(point.x + nextMove.x, point.y + nextMove.y);

      if (isValidPoint(newPoint, array)) {
        return zigZagTraverse(array, moves, newPoint, result, positive * -1);
      } else {
        moves.poll();
        final Point otherMove = moves.isEmpty()
          ? new Point(0, 0)
          : moves.peek();
        final Point otherPoint = new Point(point.x + otherMove.x, point.y + otherMove.y);
        return zigZagTraverse(array, moves, otherPoint, result, positive * -1);
      }
    }
  }

  private static boolean isValidPoint(final Point point,
                                      final List<List<Integer>> array) {
    try {
      array.get(point.x)
        .get(point.y);
      return true;
    } catch (final Exception e) {
      return false;
    }
  }
}
