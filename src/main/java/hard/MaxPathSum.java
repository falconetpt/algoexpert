package hard;

public class MaxPathSum {

  public static int maxPathSum(BinaryTree tree) {
    if (tree == null) {
      return 0;
    } else {
      return tree.value + maxPathSum(tree.left, 0) + maxPathSum(tree.right, 0);
    }
  }

  public static int maxPathSum(BinaryTree tree, int result) {
    if (tree == null) {
      return 0;
    } else {
      int right = maxPathSum(tree.left, 0);
      return tree.value + Math.max(maxPathSum(tree.left), maxPathSum(tree.right));
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
