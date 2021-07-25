package mid;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BalancedBrackets {
  public static boolean balancedBrackets(final String str) {
    Map<Character, Boolean> charactersToAdd = new HashMap<Character, Boolean>() {{
      put('{', true);
      put('[', true);
      put('(', true);
    }};

    Map<Character, Character> mapping = new HashMap<Character, Character>() {{
      put('}', '{');
      put(']', '[');
      put(')', '(');
    }};

    return balancedBrackets(str, 0, new LinkedList<>(), mapping, charactersToAdd);
  }

  private static boolean balancedBrackets(String str,
                                          int i,
                                          Deque<Character> characters,
                                          Map<Character, Character> mapping,
                                          Map<Character, Boolean> charactersToAdd) {
    if (i >= str.length()) {
      return characters.isEmpty();
    } else {
      char value = str.charAt(i);

      if (charactersToAdd.getOrDefault(value, false)) {
        characters.addFirst(value);
      }

      if (mapping.containsKey(value)) {
        char open = mapping.get(value);

        if (characters.size() > 0 && characters.getFirst() == open) {
          characters.removeFirst();
        } else {
          return false;
        }
      }

      return balancedBrackets(str, i + 1, characters, mapping, charactersToAdd);
    }
  }
}
