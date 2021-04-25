package mid;


import java.util.HashMap;
import java.util.Map;

public class DiamaterOfBinaryTree {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
        this.value = value;
    }
  }

  public int binaryTreeDiameter(final BinaryTree tree) {
    final Map<BinaryTree, Integer> diameter = new HashMap<>();
    binaryTreeDiameter(tree, diameter);

    return diameter.values()
      .stream()
      .max(Integer::compareTo)
      .orElse(-1);
  }

  private int binaryTreeDiameter(final BinaryTree tree,
                                 final Map<BinaryTree, Integer> diameter) {
    if (tree == null) {
      return 0;
    } else {
      final int maxDiameter = 1;
      final int leftDiameter = binaryTreeDiameter(tree.left, diameter);
      final int rightDiameter = binaryTreeDiameter(tree.right, diameter);
      final int total = maxDiameter + leftDiameter + rightDiameter;
      diameter.put(tree, total);

      return total;
    }
  }
}
