package mid;

import java.util.Objects;

public class InvertBinaryTree {
  public static void invertBinaryTree(BinaryTree tree) {
    // Write your code here.
    if (Objects.nonNull(tree)) {
      BinaryTree left = tree.left;
      BinaryTree right = tree.right;

      tree.left = right;
      tree.right = left;
      invertBinaryTree(right);
      invertBinaryTree(left);
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
