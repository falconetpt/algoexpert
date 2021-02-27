package mid;

import java.util.Objects;

public class HeightOfTree {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    // Write your code here.
    if (Objects.isNull(tree)) {
      return true;
    } else {
      return heightBalancedBinaryTree(tree.left)
              && heightBalancedBinaryTree(tree.right)
              && Math.abs(height(tree.right) - height(tree.left)) < 2;
    }
  }

  private int height(final BinaryTree node) {
    if (node == null) {
      return 0;
    } else {
      int left = 1 + height(node.left);
      int right = 1 + height(node.right);

      return Math.max(left, right);
    }
  }
}
