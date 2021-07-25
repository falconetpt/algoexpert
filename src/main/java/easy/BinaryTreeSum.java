package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class BinaryTreeSum {
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(final BinaryTree root) {
    // Write your code here.
    List<Integer> result = new ArrayList<>();

    branchSums(root, result, 0);

    return result;
  }

  private static void branchSums(final BinaryTree root,
                                 final List<Integer> result,
                                 final int sum) {
    if (Objects.nonNull(root)) {
      boolean addValue = Stream.of(root.left, root.right).allMatch(Objects::isNull);

      if (addValue) result.add(sum + root.value);

      branchSums(root.left, result, sum + root.value);
      branchSums(root.right, result, sum + root.value);
    }
  }
}
