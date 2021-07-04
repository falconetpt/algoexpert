package hard;

import java.util.HashSet;
import java.util.Set;

public class FindLoop {
  public static LinkedList findLoop(LinkedList head) {
    return findLoop(head, new HashSet<>());
  }

  private static LinkedList findLoop(final LinkedList node,
                                     final Set<LinkedList> seen) {
    if (seen.contains(node)) {
      return node;
    } else {
      seen.add(node);
      return findLoop(node.next, seen);
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
