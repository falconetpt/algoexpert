package mid;

import java.util.List;
import java.util.Optional;

public class BSTMinWeight {
  public static BST minHeightBst(List<Integer> array) {
    // Write your code here.
    return minHeightBst(null, array, 0, array.size() - 1);
  }

  private static BST minHeightBst(BST value, List<Integer> array, int min, int max) {
    if (min > max) {
      return value;
    } else {
      int index = (min + max) / 2;

      BST newValue = Optional.ofNullable(value)
        .map(i -> {
          i.insert(array.get(index));
          return i;
        }).orElse(new BST(array.get(index)));

      minHeightBst(newValue, array, index + 1, max);
      minHeightBst(newValue, array, min, index - 1);

      return newValue;
    }
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }
}
