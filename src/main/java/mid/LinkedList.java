package mid;

public class LinkedList {
  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
      head = node;
    }

    public void setTail(Node node) {
      tail = node;
    }

    public void insertBefore(Node node, Node nodeToInsert) {
      final var prevNode = node.prev;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
      // Write your code here.
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
      // Write your code here.
    }

    public void removeNodesWithValue(int value) {
      // Write your code here.
    }

    public void remove(Node node) {
      // Write your code here.
    }

    public boolean containsNodeWithValue(int value) {
      // Write your code here.
      return false;
    }
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
