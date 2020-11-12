package mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BFS {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            breadthFirstSearch( Stream.of( this ).collect( Collectors.toCollection(LinkedList::new) ), array );
            // Write your code here.
            return array;
        }

        private void breadthFirstSearch(Queue<Node> collect, List<String> array) {
            if (!collect.isEmpty()) {
                Node element = collect.poll();
                array.add( element.name );
                collect.addAll( element.children );
                breadthFirstSearch( collect, array );
            }
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
