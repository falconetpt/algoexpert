package mid;

import java.util.ArrayList;
import java.util.List;

public class MoveElementsToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        return moveElementToEnd( array, 0, toMove, new ArrayList<>(  ), new ArrayList<>(  ) );
    }

    private static List<Integer> moveElementToEnd(List<Integer> array,
                                                  int i,
                                                  int toMove,
                                                  List<Integer> start,
                                                  List<Integer> end) {
        if (i >= array.size()) {
            start.addAll( end );
            return start;
        } else {
            int value = array.get( i );

            if (value == toMove) {
                end.add( value );
            } else {
                start.add( value );
            }

            return moveElementToEnd( array, i + 1, toMove, start, end );
        }
    }
}
