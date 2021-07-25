package mid;

import java.util.LinkedList;

public class ReverseString {
  public String reverseWordsInString(final String string) {
    final var result = new LinkedList<String>();
    var localStr = new StringBuffer();

    for (final var c : string.toCharArray()) {
      if (c == ' ') {
        result.addFirst(" " + localStr.toString());
        localStr = new StringBuffer();
      } else {
        localStr.append(c);
      }
    }

    result.addFirst(localStr.toString());

    return String.join("", result);
  }
}
