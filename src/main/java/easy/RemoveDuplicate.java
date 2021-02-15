package easy;

import java.util.Objects;
import java.util.Optional;

public class RemoveDuplicate {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        removeDuplicates(linkedList);

        return linkedList;
    }

    private int removeDuplicates(LinkedList linkedList) {
        if (Objects.nonNull(linkedList)) {
            Optional.ofNullable( linkedList )
                    .map( l -> l.next )
                    .filter( l -> l.value == linkedList.value )
                    .map( l -> {
                        linkedList.next = l.next;
                        return removeDuplicates( linkedList );
                    })
                    .orElseGet( () -> removeDuplicates( linkedList.next ) );
        }

        return 1;
    }
}
