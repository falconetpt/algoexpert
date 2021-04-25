package mid;

import java.util.LinkedList;
import java.util.Objects;

public class FindSucessor {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    final LinkedList<BinaryTree> linkedList = new LinkedList<>();
    constructInOrderTraversal(tree, linkedList);

    return findSuccessor(linkedList, false, node);
  }

  private BinaryTree findSuccessor(final LinkedList<BinaryTree> linkedList,
                                   final boolean foundSucessor,
                                   final BinaryTree node) {
    if (linkedList.isEmpty()) {
      return null;
    } else if (foundSucessor) {
      return linkedList.pollFirst();
    } else {
      return findSuccessor(linkedList,
        linkedList.pollFirst() == node,
        node);
    }
  }


  // O(n) time
  // O(n) space
  private void constructInOrderTraversal(final BinaryTree tree,
                                         final LinkedList<BinaryTree> linkedList) {
    if (Objects.nonNull(tree)) {
      constructInOrderTraversal(tree.left, linkedList);
      linkedList.add(tree);
      constructInOrderTraversal(tree.right, linkedList);
    }
  }
}
