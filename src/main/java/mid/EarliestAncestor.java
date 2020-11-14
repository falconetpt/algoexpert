package mid;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class EarliestAncestor {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
        int depthOne = getDepth(topAncestor, descendantOne);
        int depthTwo = getDepth(topAncestor, descendantTwo);

        if (depthOne > depthTwo) {
            return getAncestor(descendantOne, descendantTwo, depthOne - depthTwo);
        } else {
            return getAncestor(descendantTwo, descendantOne, depthTwo - depthOne);
        }
    }

    private static AncestralTree getAncestor(AncestralTree higher, AncestralTree lower, int depth) {
        if (depth == 0) {
            return higher != lower
                    ? getAncestor( higher.ancestor , lower.ancestor, 0)
                    : lower;
        } else {
            return getAncestor( higher.ancestor, lower, depth - 1 );
        }
    }

    private static int getDepth(AncestralTree topAncestor, AncestralTree descendantOne) {
        if (topAncestor.name == descendantOne.name) {
            return 0;
        } else {
            return 1 + getDepth( topAncestor, descendantOne.ancestor );
        }
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
