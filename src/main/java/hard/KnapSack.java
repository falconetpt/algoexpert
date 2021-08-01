package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KnapSack {
  public static List<List<Integer>> knapsackProblem(final int[][] items, final int capacity) {
    final var result = new int[items.length + 1][capacity + 1];

    fillArray(items, result);


    return List.of(
      List.of(result[items.length][capacity]),
      generateIndexes(result, items, items.length, capacity, new ArrayList<>())
    );
  }

  private static List<Integer> generateIndexes(final int[][] result,
                                               final int[][] items,
                                               final int row,
                                               final int column,
                                               final List<Integer> indexes) {
    final var value = result[row][column];

    if (value == 0) {
      return indexes;
    } else {
      if (value == result[row - 1][column]) {
        return generateIndexes(result, items, row - 1, column, indexes);
      } else {
        indexes.add(row - 1);
        return generateIndexes(result, items,row - 1, column - items[row - 1][1], indexes);
      }
    }
  }

  private static void fillArray(final int[][] items, final int[][] result) {
    for (var i = 1; i < result.length; i++) {
      final var currentItem = items[i - 1];
      final var currentValue = currentItem[0];
      final var currentWeight = currentItem[1];

      for (var j = 1; j < result[i].length; j++) {
        if (j >= currentWeight) {
          result[i][j] = Math.max(result[i - 1][j], currentValue + result[i - 1][j - currentWeight]);
        } else {
          result[i][j] = result[i - 1][j];
        }
      }
    }
  }
}
