package hard;

import java.util.HashMap;
import java.util.Map;

public class MaxPathSum {

  public static int maxPathSum(BinaryTree tree) {
    if (tree == null) {
      return 0;
    } else {
      final var values = new HashMap<BinaryTree, Integer>();

      maxPathSum(tree, values);

      return values.values()
        .stream()
        .max(Integer::compareTo)
        .orElse(-1);
    }
  }

  public static int maxPathSum(final BinaryTree tree,
                               final Map<BinaryTree, Integer> values) {
    if (tree == null) {
      return 0;
    } else {
      final var left = maxPathSum(tree.left, values);
      final var right = maxPathSum(tree.right, values);

      values.putIfAbsent(tree, tree.value + Math.max(left, 0) + Math.max(right, 0));

      return tree.value + Math.max(left, right);
    }
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
