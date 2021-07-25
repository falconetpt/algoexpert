package easy;

import java.util.stream.IntStream;

public class SelectionSort {
  public static int[] selectionSort(int[] array) {
    // Write your code here.
    selectionSort(array, 0);
    return array;
  }

  private static void selectionSort(final int[] array,
                                    final int index) {
    if (index < array.length) {
      int minIndex = IntStream.range(index, array.length).boxed()
        .reduce(index, (a, b) -> array[a] > array[b] ? b : a);

      int tmp = array[index];
      int minimum = array[minIndex];

      array[index] = minimum;
      array[minIndex] = tmp;

      selectionSort(array, index + 1);
    }
  }
}
