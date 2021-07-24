package mid;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Sufix {
  static class TrieNode {
    final Map<Character, TrieNode> children = new HashMap<>();
  }

  static class SuffixTrie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public SuffixTrie(final String str) {
      populateSuffixTrieFrom(str);
    }


    public void populateSuffixTrieFrom(final String str) {
      if (str.isEmpty()) root.children.put(endSymbol, null);

      for (int i = 0; i < str.length(); i++) {
        root.children.putIfAbsent(str.charAt(i), new TrieNode());
      }

      for (int i = 0; i < str.length(); i++) {
        addValue(root.children.get(str.charAt(i)), str, i + 1);
      }
    }

    private void addValue(final TrieNode node, final String str, final int i) {
      if (i >= str.length()) {
        node.children.put(endSymbol, null);
      } else {
        node.children.putIfAbsent(str.charAt(i), new TrieNode());
        addValue(node.children.get(str.charAt(i)), str, i + 1);
      }
    }

    public boolean contains(final String str) {
      if (str.isEmpty()) {
        return root.children
          .containsKey(endSymbol);
      } else {
        return contains(str, root, 0);
      }
    }

    public boolean contains(final String str, final TrieNode node, final int i) {
      if (i >= str.length()) {
        return node.children
          .containsKey(endSymbol);
      } else {
        final var children = node.children
          .getOrDefault(str.charAt(i), null);
        return Optional.ofNullable(children)
          .filter(n -> contains(str, n, i + 1))
          .isPresent();
      }
    }
  }
}
