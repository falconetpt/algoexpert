package hard;

public class InterverweavingString {
  public static boolean interweavingStrings(String one, String two, String three) {
    if (one.length() + two.length() == three.length()) {
      return interweavingStrings(one, two, three, 0, 0, 0);
    } else {
      return false;
    }
  }

  private static boolean interweavingStrings(final String one,
                                             final String two,
                                             final String three,
                                             final int oneIndex,
                                             final int twoIndex,
                                             final int threeIndex) {
    if (threeIndex == three.length()) {
      return true;
    } else {
      final var charOne = oneIndex >= one.length()
      ? ' '
      : one.charAt(oneIndex);
      final var charTwo = twoIndex >= two.length()
        ? ' '
        : two.charAt(twoIndex);
      final var charThree = three.charAt(threeIndex);

      if ((oneIndex < one.length() && charThree == charOne)
        || (twoIndex < two.length() && charThree == charTwo)) {
        final var oneTest = charThree == charOne
          && interweavingStrings(one, two, three, oneIndex + 1, twoIndex, threeIndex + 1);
        final var twoTest = charTwo == charThree
          && interweavingStrings(one, two, three, oneIndex, twoIndex + 1, threeIndex + 1);

        return oneTest || twoTest;
      } else {
        return false;
      }
    }
  }
}
