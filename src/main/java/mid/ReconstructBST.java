package mid;

import javax.swing.text.html.Option;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

public class ReconstructBST {
    // This is an input class. Do not edit.
    static class BST {
      public int value;
      public BST left = null;
      public BST right = null;

      public BST(int value) {
        this.value = value;
      }
    }

    public BST reconstructBst(final List<Integer> preOrderTraversalValues) {
      Queue<Integer> queue = new LinkedList<>(preOrderTraversalValues);
      BST root = new BST(queue.poll());

      for (int value : queue) {
        insertInto(root, value);
      }

      return root;
    }

  private void insertInto(BST root, int value) {
      if (value >= root.value) {
        Optional<BST> nextNode = Optional.ofNullable(root.right);

        if (nextNode.isPresent()) {
          insertInto(root.right, value);
        } else {
          BST next = new BST(value);
          root.right = next;
        }
      } else {
        Optional<BST> nextNode = Optional.ofNullable(root.left);

        if (nextNode.isPresent()) {
          insertInto(root.left, value);
        } else {
          BST next = new BST(value);
          root.left = next;
        }
      }
  }


}
