package hard;

public class IndexSameValue {
  public int indexEqualsValue(int[] array) {
    return indexEqualsValue(array, 0 , array.length - 1);
  }

  private int indexEqualsValue(final int[] array,
                               final int min,
                               final int max) {
    final var middle = (min + max) / 2;
    if (min > max) {
      return -1;
    } else if (array[middle] == middle) {
      final var minLocal = Math.min(middle,
        indexEqualsValue(array, min, middle - 1)
      );
      return minLocal == -1
        ? middle
        : minLocal;
    } else {
      if (array[middle] > middle) {
        return indexEqualsValue(array, min, middle - 1);
      } else {
        return indexEqualsValue(array, middle + 1, max);
      }
    }
  }
}
