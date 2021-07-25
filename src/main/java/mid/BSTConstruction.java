package mid;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class BSTConstruction {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insert(int value) {
      // Write your code here.

      if (value > this.value) {
        Optional.ofNullable(this.right)
          .map(x -> x.insert(value))
          .orElseGet(() -> {
            BST element = new BST(value);
            this.right = element;
            return element;
          });
      } else {
        Optional.ofNullable(this.left)
          .map(x -> x.insert(value))
          .orElseGet(() -> {
            BST element = new BST(value);
            this.left = element;
            return element;
          });
      }

      // Do not edit the return statement of this method.
      return this;
    }

    public boolean contains(int value) {
      // Write your code here.
      if (value == this.value) {
        return true;
      } else if (value > this.value) {
        return Optional.ofNullable(this.right)
          .map(x -> x.contains(value))
          .orElse(false);
      } else {
        return Optional.ofNullable(this.left)
          .map(x -> x.contains(value))
          .orElse(false);
      }
    }

    public BST remove(int value) {
      // Write your code here.
      Optional<BST> node = search(value);

      node.ifPresent(this::remove);

      // Do not edit the return statement of this method.
      return this;
    }

    private void remove(BST node) {
      if (Stream.of(node.left, node.right).allMatch(Objects::isNull)) {
//                removeElement( node );
      }
    }

    private Optional<BST> search(int value) {
      if (value == this.value) {
        return Optional.of(this);
      } else if (value > this.value) {
        return Optional.ofNullable(this.right)
          .flatMap(x -> x.search(value));
      } else {
        return Optional.ofNullable(this.left)
          .flatMap(x -> x.search(value));
      }
    }
  }
}
