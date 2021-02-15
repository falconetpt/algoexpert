package mid;

public class SumLinkedList {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {

    // Write your code here.
    int value1 = extractValue(linkedListOne, "");
    int value2 = extractValue(linkedListTwo, "");
    int total = value1 + value2;

    return total == 0 ? new LinkedList(0) : createLinkedList(total, null, null);
  }

  private LinkedList createLinkedList(int total, LinkedList result, LinkedList next) {
    if (total == 0) {
      return result;
    } else {
      LinkedList next2 = new LinkedList(total % 10);
      if (next != null) next.next = next2;
      return createLinkedList(total / 10, result == null ? next2 : result, next2);
    }
  }

  private int extractValue(final LinkedList linkedListOne, String result) {
    if (linkedListOne == null) {
      return Integer.parseInt(result);
    } else {
      return extractValue(linkedListOne.next, linkedListOne.value + result);
    }
  }
}
