package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
  public static List<List<String>> groupAnagrams(final List<String> words) {
    Map<String, List<String>> result = new HashMap<>();

    words.stream()
      .map(GroupAnagram::toAnagram)
      .peek(t -> result.putIfAbsent(t.key, new ArrayList<>()))
      .forEach(t -> result.get(t.key).add(t.value));

    return new ArrayList<>(result.values());
  }

  public static Anagram toAnagram(final String value) {
    char[] arr = value.toCharArray();
    Arrays.sort(arr);

    return new Anagram(String.valueOf(arr), value);
  }

  public static class Anagram {
    private String key;
    private String value;

    public Anagram(final String key, final String value) {
      this.key = key;
      this.value = value;
    }
  }

}
