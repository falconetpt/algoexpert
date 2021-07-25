package mid;

import java.util.Optional;

public class ValidBst {
  public static boolean validateBst(BST tree) {
    // Write your code here.
    return Optional.ofNullable(tree).map(t -> validateBst(t, Integer.MAX_VALUE, Integer.MIN_VALUE))
      .orElse(true);
  }

  private static boolean validateBst(BST t, int maxValue, int minValue) {
    if (t.value < minValue || t.value >= maxValue) {
      return false;
    } else {

      boolean left = Optional.ofNullable(t.left)
        .map(l -> validateBst(l, t.value, minValue))
        .orElse(true);

      boolean right = Optional.ofNullable(t.right)
        .map(l -> validateBst(l, maxValue, t.value))
        .orElse(true);

      return right && left;
    }
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
