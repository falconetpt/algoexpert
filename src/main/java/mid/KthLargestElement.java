package mid;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

public class KthLargestElement {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public int findKthLargestValueInBst(final BST tree, final int k) {
    LinkedList<Integer> values = new LinkedList<>();
    findKthLargestValueInBst(tree, k, values);
    return values.getLast();
  }

  private void findKthLargestValueInBst(final BST tree,
                                        final int k,
                                        final LinkedList<Integer> integers) {
    if (integers.size() < k && Objects.nonNull(tree)) {
      Optional.ofNullable(tree.right)
        .ifPresent(p -> findKthLargestValueInBst(p, k, integers));

      if (integers.size() < k) integers.add(tree.value);
      System.out.println("added: " + tree.value);


      Optional.ofNullable(tree.left)
        .ifPresent(p -> findKthLargestValueInBst(p, k, integers));
    }
  }
}
