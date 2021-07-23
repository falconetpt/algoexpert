package mid;

import java.util.stream.IntStream;

public class NextGreatElement {
  public int[] nextGreaterElement(int[] array) {
    // Write your code here.
    return IntStream.range(0, array.length)
      .boxed()
      .mapToInt(i -> findNextGreater(array, i))
      .toArray();
  }

  private int findNextGreater(final int[] array, final int i) {
    for (int j = (i + 1) % array.length; j != i; j = (j + 1) % array.length) {
      if (array[j] > array[i]) return array[j];
    }

    return -1;
  }
}
