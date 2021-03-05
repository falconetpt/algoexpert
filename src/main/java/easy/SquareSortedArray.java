package easy;

import java.util.Arrays;

public class SquareSortedArray {
  public int[] sortedSquaredArray(int[] array) {
    return Arrays.stream(array)
            .map(i -> i * i)
            .sorted()
            .toArray();
  }
}
