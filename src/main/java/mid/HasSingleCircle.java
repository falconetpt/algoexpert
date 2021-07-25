package mid;

public class HasSingleCircle {
  public static boolean hasSingleCycle(int[] array) {
    // Write your code here.
    int nextArray = 0;
    for (int i = 0; i < array.length; i++) {
      if (i > 0 && nextArray == 0) return false;
      nextArray = (nextArray + array[nextArray]) % array.length;
      nextArray = nextArray >= 0 ? nextArray : nextArray + array.length;
    }

    return nextArray == 0;
  }
}
