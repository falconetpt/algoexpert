package easy;

import java.util.Objects;

public class NodeDepthSum {
    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        return nodeDepths( root, 0 );
    }

    private static int nodeDepths(final BinaryTree root, int level) {
        if ( Objects.isNull( root ) ) {
            return 0;
        } else {
            return level + nodeDepths( root.left, level + 1 )
                    + nodeDepths( root.right, level + 1 );
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
