package mid;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {

        final Queue<Point> moves = Stream.of(
                new Point( 0, 1 ),
                new Point( 1, 0 ),
                new Point( 0, -1 ),
                new Point( -1, 0 )
        ).collect( Collectors.toCollection( LinkedList::new ) );

        int[][] baseSpiral = new int[array.length][array.length];
        baseSpiral[0][0] = 1;

        List<Point> movePoints = spiralTraverse( baseSpiral, moves,
                array.length * array.length, new Point( 0, 0 ),
                Stream.of( new Point( 0, 0 ) ).collect( Collectors.toCollection(ArrayList::new))
        );

        // Write your code here.
        return movePoints.stream()
                .map( p -> array[p.x][p.y] )
                .collect( Collectors.toList() );
    }

    private static List<Point> spiralTraverse(final int[][] baseSpiral,
                                              final Queue<Point> moves,
                                              final int expectedSize,
                                              final Point point,
                                              final List<Point> result) {
        if (result.size() == expectedSize) {
            return result;
        } else {
            Point move = moves.peek();
            Point newPoint = new Point( point.x + move.x, point.y + move.y );

            if (isValid( baseSpiral, newPoint )) {
                baseSpiral[newPoint.x][newPoint.y] = 1;
                result.add( newPoint );

                return spiralTraverse( baseSpiral, moves, expectedSize, newPoint, result );
            } else {
                moves.poll();
                moves.add( move );
                return spiralTraverse( baseSpiral, moves, expectedSize, point, result );
            }

        }
    }

    private static boolean isValid(int[][] baseSpiral, Point point) {
        if (Stream.of( point.x, point.y ).allMatch( x -> x >= 0 && x < baseSpiral.length )) {
            return baseSpiral[point.x][point.y] == 0;
        } else {
            return false;
        }
    }
}
