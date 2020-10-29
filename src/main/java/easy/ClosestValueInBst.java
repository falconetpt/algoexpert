package easy;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

public class ClosestValueInBst {
    public static int findClosestValueInBst(final BST tree, final int target) {
        // Write your code here.
        Queue<BST> queue = new LinkedList<>(  );
        queue.add( tree );

        int result = -1;
        int minimumDifference = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            BST node = queue.poll();
            int newDifference = Math.min( Math.abs( node.value - target ), minimumDifference );

            result = newDifference < minimumDifference ? node.value : result;
            Stream.of(node.left, node.right).filter( Objects::nonNull )
                    .forEach( queue::add );
            minimumDifference = newDifference;
        }

        return result;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
