package hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiStringSearch {
  public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
    return Arrays.stream(smallStrings)
      .map(bigString::contains)
      .collect(Collectors.toList());
  }
}
