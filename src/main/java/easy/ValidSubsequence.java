package easy;

import java.util.List;

public class ValidSubsequence {
  public static boolean isValidSubsequence(final List<Integer> array,
                                           final List<Integer> sequence) {
    // Write your code here.

    return isValidSubsequence(array, sequence, 0, 0);
  }

  private static boolean isValidSubsequence(final List<Integer> array,
                                            final List<Integer> sequence,
                                            final int arrayIndex,
                                            final int sequenceIndex) {
    if (sequenceIndex >= sequence.size()) {
      return true;
    } else if (arrayIndex >= array.size()) {
      return false;
    } else {
      int sequenceIncrement = array.get(arrayIndex)
        .equals(sequence.get(sequenceIndex)) ? 1 : 0;
      return isValidSubsequence(
        array,
        sequence,
        arrayIndex + 1,
        sequenceIndex + sequenceIncrement
      );
    }
  }
}
