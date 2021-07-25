package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindNodesDistanceK {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public List<Integer> findNodesDistanceK(final BinaryTree tree,
                                          final int target,
                                          final int k) {
    final var result = new HashSet<Integer>();

    fillParent(tree, null);

    final var targetNode = findNodeWithTarget(tree, target);
    findNodesDistanceK(targetNode, k, result, new HashSet<>());

    return new ArrayList<>(result);
  }

  private void findNodesDistanceK(final BinaryTree tree,
                                  final int k,
                                  final Set<Integer> result,
                                  final Set<BinaryTree> seen) {
    if (tree != null && !seen.contains(tree)) {
      seen.add(tree);
      if (k == 0) result.add(tree.value);

      if (k > 0) {
        findNodesDistanceK(tree.parent, k - 1, result, seen);
        findNodesDistanceK(tree.left, k - 1, result, seen);
        findNodesDistanceK(tree.right, k - 1, result, seen);
      }
    }
  }

  private BinaryTree findNodeWithTarget(final BinaryTree tree, final int target) {
    if (tree == null) {
      return null;
    } else {
      if (tree.value == target) {
        return tree;
      } else {
        final var left = findNodeWithTarget(tree.left, target);
        return left == null
          ? findNodeWithTarget(tree.right, target)
          : left;
      }
    }
  }

  private void fillParent(final BinaryTree tree, final BinaryTree parent) {
    if (tree != null) {
      tree.parent = parent;
      fillParent(tree.left, tree);
      fillParent(tree.right, tree);
    }
  }
}
