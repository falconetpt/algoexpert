package hard;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinAreaSquare {
  public int minimumAreaRectangle(int[][] points) {
    Map<Integer, Set<Point>> xMap = new HashMap<>();
    Map<Integer, Set<Point>> yMap = new HashMap<>();

    Arrays.stream(points)
      .map(i -> new Point(i[0], i[1]))
      .peek(i -> xMap.putIfAbsent(i.x, new HashSet<>()))
      .peek(i -> yMap.putIfAbsent(i.y, new HashSet<>()))
      .forEach(i -> {
        xMap.get(i.x).add(i);
        yMap.get(i.y).add(i);
      });

    int result = Integer.MAX_VALUE;

//    xMap.keySet().stream()


    // Write your code here.
    return result == Integer.MAX_VALUE ? 0 : result;
  }
}
