package mid;

import java.util.stream.IntStream;

public class SearchInSortedMatrix {
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    return IntStream.range(0, matrix.length).boxed()
      .flatMap(x -> IntStream.range(0, matrix[x].length).boxed()
        .filter(y -> matrix[x][y] == target)
        .map(y -> new int[]{x, y})
      ).findFirst()
      .orElse(new int[]{-1, -1});
  }
}
