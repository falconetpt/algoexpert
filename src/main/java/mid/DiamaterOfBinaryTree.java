package mid;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DiamaterOfBinaryTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>(  );

        binaryTreeDiameter( tree, 0, 0, map );

        return map.values().stream()
                .map( v -> Math.abs( v.getKey() - v.getValue() ) )
                .max( Integer::compareTo )
                .orElse( 0 );
    }

    private void binaryTreeDiameter(BinaryTree tree,
                                   int level,
                                   int i,
                                   Map<Integer, Pair<Integer, Integer>> map) {
        if (Objects.nonNull(tree)) {
            map.putIfAbsent( level, new Pair<>( 0, 0 ) );

            binaryTreeDiameter( tree.left, level + 1, 2 * i, map );
            binaryTreeDiameter( tree.right, level + 1, 2 * i + 1, map );
        }
    }
}
