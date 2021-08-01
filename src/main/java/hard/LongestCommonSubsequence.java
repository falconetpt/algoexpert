package hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestCommonSubsequence {
  public static List<Character> longestCommonSubsequence(final String str1, final String str2) {
    final var result = new String[str1.length() + 1][str2.length() + 1];
    IntStream.range(0, result.length).forEach(x -> result[x][0] = "");
    IntStream.range(0, result[0].length).forEach(x -> result[0][x] = "");

    for (int i = 1; i < result.length; i++) {
      for (int j = 1; j < result[i].length; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          result[i][j] = result[i - 1][j - 1] + str1.charAt(i - 1);
        } else {
          result[i][j] = result[i - 1][j].length() > result[i][j - 1].length()
            ? result[i - 1][j]
            : result[i][j - 1];
        }
      }
    }

    return Arrays.stream(result[str1.length()][str2.length()].split(""))
      .filter(s -> !s.isEmpty())
      .map(s -> s.charAt(0))
      .collect(Collectors.toList());
  }
}
