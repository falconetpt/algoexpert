package easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindFirstNonRepeatingChar {
  public int firstNonRepeatingCharacter(final String string) {
    final int[] frequency = new int[26];

    Arrays.stream(string.split(""))
      .filter(s -> !s.isEmpty())
      .map(i -> i.charAt(0))
      .map(i -> i - 'a')
      .forEach(i -> frequency[i]++);

    return IntStream.range(0, string.length())
      .filter(i -> frequency[string.charAt(i) - 'a'] == 1)
      .findFirst()
      .orElse(-1);
  }
}
