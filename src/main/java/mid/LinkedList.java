package mid;

import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;

public class LinkedList {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.
            this.head = node;
        }

        public void setTail(Node node) {
            // Write your code here.
            this.tail = node;
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
            Node prev = node.prev;
            Node next = node;

            Optional.ofNullable(prev)
                    .map( n -> n.next = nodeToInsert )
                    .orElse( this.head = nodeToInsert );
            Optional.ofNullable(next)
                    .map( n -> n.prev = nodeToInsert )
                    .orElse( this.tail = nodeToInsert );

            nodeToInsert.prev = prev;
            nodeToInsert.next = next;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
            Node prev = node;
            Node next = node.next;

            Optional.ofNullable(prev)
                .map( n -> n.next = nodeToInsert )
                .orElse( this.head = nodeToInsert );
            Optional.ofNullable(next)
                    .map( n -> n.prev = nodeToInsert )
                    .orElse( this.tail = nodeToInsert );

            nodeToInsert.prev = prev;
            nodeToInsert.next = next;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
            insertAtPosition( position, nodeToInsert, head );
        }

        private void insertAtPosition(int position, Node nodeToInsert, Node node) {
            if (position == 0) {
                Node next = node.next;
                Node prev = node.prev;

                Optional.ofNullable(prev)
                        .map( n -> n.next = nodeToInsert )
                        .orElse( this.head = nodeToInsert );
                Optional.ofNullable(next)
                        .map( n -> n.prev = nodeToInsert )
                        .orElse( this.tail = nodeToInsert );

                nodeToInsert.prev = prev;
                nodeToInsert.next = next;

            } else {
                insertAtPosition( position-1, nodeToInsert, node.next );
            }
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
            removeNodesWithValue( value, head );
        }

        private void removeNodesWithValue(int value, Node node) {
            if (Objects.nonNull(node)) {
                if (node.value == value) remove( node );
                removeNodesWithValue( value, node.next );
            }
        }

        public void remove(Node node) {
            // Write your code here.
            Node next = node.next;
            Node prev = node.prev;

            Optional.ofNullable(prev)
                    .map( n -> n.next = next )
                    .orElse( this.head = next );
            Optional.ofNullable(next)
                    .map( n -> n.prev = prev )
                    .orElse( this.tail = prev );
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            return containsNodeWithValue( value, head );
        }

        private boolean containsNodeWithValue(int value, Node head) {
            if (Objects.isNull( head )) {
                return false;
            } else {
                if (head.value == value) {
                    return true;
                } else {
                    return containsNodeWithValue( value, head.next );
                }
            }
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
