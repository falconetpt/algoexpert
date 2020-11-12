package mid;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RiverSize {
    public static List<Integer> riverSizes(final int[][] matrix) {
        // Write your code here.
        final Queue<Point> queue = IntStream.range( 0, matrix.length ).boxed()
                .flatMap( x -> IntStream.range( 0, matrix[x].length ).boxed()
                        .filter( y -> matrix[x][y] == 1 )
                        .map( y -> new Point( x, y ) )
                ).collect( Collectors.toCollection( LinkedList::new ));

        final Set<Point> moves = Stream.of(
                new Point( 0, 1 ),
                new Point( 0, -1 ),
                new Point( 1, 0 ),
                new Point( -1, 0 )
        ).collect( Collectors.toSet());


        return riverSizes( queue, matrix, moves , new ArrayList<>() );
    }

    private static List<Integer> riverSizes(Queue<Point> queue,
                                            int[][] matrix,
                                            Set<Point> moves,
                                            List<Integer> result) {
        if (queue.isEmpty()) {
            return result;
        } else {
            final Point next = queue.poll();
            int size = 1 + expandPoint(next, queue, matrix, moves);
            result.add( size );

            return riverSizes( queue, matrix, moves, result );
        }
    }

    private static int expandPoint(final Point next,
                                   final Queue<Point> queue,
                                   final int[][] matrix,
                                   final Set<Point> moves) {
        return moves.stream()
                .map( p -> new Point( next.x + p.x, next.y + p.y ) )
                .filter( queue::contains )
                .filter( p -> validPoint(matrix, p) )
                .peek( queue::remove )
                .map( p -> 1 + expandPoint( p, queue, matrix, moves ) )
                .reduce( 0, Integer::sum );
    }

    private static boolean validPoint(int[][] matrix, Point p) {
        try {
            return matrix[p.x][p.y] == 1;
        } catch (Exception e) {
            return false;
        }
    }
}
