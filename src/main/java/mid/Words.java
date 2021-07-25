package mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Words {
  public char[] minimumCharactersForWords(String[] words) {
    final var charSet = new HashMap<Character, Integer>();

    Arrays.stream(words)
      .forEach(w -> addChars(w, charSet));

    final var result = new char[charSet.values().stream().reduce(0, Integer::sum)];
    var index = 0;

    for (final var c : charSet.entrySet()) {
      for (int i = 0; i < c.getValue(); i++) {
        result[index++] = c.getKey();
      }
    }

    return result;
  }

  private void addChars(final String w, final Map<Character, Integer> charSet) {
    final var map = new HashMap<Character, Integer>();

    for (final var c : w.toCharArray()) {
      map.putIfAbsent(c, 0);
      map.put(c, map.get(c) + 1);
    }

    map.keySet()
      .forEach(k -> charSet.put(k, Math.max(charSet.getOrDefault(k, 0), map.get(k))));
  }
}
