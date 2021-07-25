package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BuildingDirection {
  public List<Integer> sunsetViews(int[] buildings, String direction) {
    if ("WEST".equals(direction)) {
      return sunsetViews(buildings, 0, 1, Integer.MIN_VALUE, new ArrayList<>());
    } else {
      return sunsetViews(buildings, buildings.length - 1, -1, Integer.MIN_VALUE, new ArrayList<>());
    }
  }

  private List<Integer> sunsetViews(int[] buildings, int i, int acc, int maxValue, List<Integer> es) {
    if (i < 0 || i >= buildings.length) {
      return es.stream().sorted().collect(Collectors.toList());
    } else {
      if (buildings[i] > maxValue) es.add(i);
      return sunsetViews(buildings, i + acc, acc, Math.max(maxValue, buildings[i]), es);
    }
  }
}
