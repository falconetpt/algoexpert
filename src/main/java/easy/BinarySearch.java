package easy;

public class BinarySearch {
  public static int binarySearch(int[] array, int target) {
    // Write your code here.
    return binarySearch(array, target, 0, array.length - 1);
  }

  private static int binarySearch(final int[] array,
                                  final int target,
                                  final int start,
                                  final int end) {
    if (start > end) {
      return -1;
    } else {
      int middle = (start + end) / 2;
      int value = array[middle];

      if (value == target) {
        return middle;
      } else {
        return value > target
          ? binarySearch(array, target, start, middle - 1)
          : binarySearch(array, target, middle + 1, end);
      }
    }
  }
}
