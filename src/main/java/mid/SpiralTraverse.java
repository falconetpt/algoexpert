package mid;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpiralTraverse {
  public static List<Integer> spiralTraverse(int[][] array) {
    final LinkedList<Point> moves = Stream.of(
      new Point(0, 1),
      new Point(1, 0),
      new Point(0, -1),
      new Point(-1, 0)
    ).collect(Collectors.toCollection(LinkedList::new));

    final Map<Point, Integer> map = createMap(array);
    map.remove(new Point(0, 0));
    final List<Integer> result = new ArrayList<>();
    result.add(array[0][0]);

    return spiralTraverse(map, moves, new Point(0, 0), result);
  }

  private static List<Integer> spiralTraverse(Map<Point, Integer> map, LinkedList<Point> moves,
                                              Point point, List<Integer> es) {
    if (map.isEmpty()) {
      return es;
    } else {
      final Point move = moves.peekFirst();
      final Point newPoint = new Point(point.x + move.x, point.y + move.y);

      if (map.containsKey(newPoint)) {
        es.add(map.get(newPoint));
        map.remove(newPoint);
        return spiralTraverse(map, moves, newPoint, es);
      } else {
        moves.pollFirst();
        moves.addLast(move);
        return spiralTraverse(map, moves, point, es);
      }
    }
  }

  private static Map<Point, Integer> createMap(final int[][] array) {
    final Map<Point, Integer> result = new HashMap<>();

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        result.put(new Point(i, j), array[i][j]);
      }
    }

    return result;
  }
}
