package mid;

import java.util.Objects;
import java.util.Optional;

public class RemoveKthElement {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    // Write your code here.
    int countElements = countElements(head);
    int index = countElements - k;

    if (index == 0) {
      head.value = head.next.value;
      head.next = head.next.next;
    } else {
      removeAtIndex(head, 1, index);
    }
  }

  private static void removeAtIndex(LinkedList node, int i, int index) {
    if (i <= index) {
      if (i == index) {
        node.next = Optional.ofNullable(node.next)
          .map(n -> n.next)
          .orElse(null);
      } else {
        removeAtIndex(node.next, i + 1, index);
      }
    }
  }

  private static int countElements(LinkedList head) {
    if (Objects.isNull(head)) {
      return 0;
    } else {
      return 1 + countElements(head.next);
    }
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
