package mid;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class RemoveIslands {
    public int[][] removeIslands(final int[][] matrix) {
        final int[][] result = new int[matrix.length][matrix[0].length];

        final List<Point> moves = Stream.of(
                new Point(1, 0),
                new Point(-1, 0),
                new Point(0, 1),
                new Point(0, -1)
        ).collect(Collectors.toList());

        final Queue<Point> pointList = IntStream.range(0, matrix.length).boxed()
                .flatMap(x ->
                        IntStream.range(0, matrix[x].length).boxed()
                                .map(y -> new Point(x, y))
                                .filter(p -> matrix[p.x][p.y] == 1)
                                .filter(p -> isValidBorderPoint(p, matrix, moves))
                ).collect(Collectors.toCollection(LinkedList::new));

        expandPoint(pointList, matrix, moves, result);

        return result;
    }

    private void expandPoint(final Queue<Point> pointList, final int[][] matrix,
                             final List<Point> moves, final int[][] result) {
        if (!pointList.isEmpty()) {
            Point element = pointList.poll();
            result[element.x][element.y] = 1;

            moves.stream()
                    .map(p -> new Point(element.x + p.x, element.y + p.y))
                    .filter(p -> isValidLand(p, matrix))
                    .filter(p -> result[p.x][p.y] != 1)
                    .forEach(pointList::add);

            expandPoint(pointList, matrix, moves, result);

        }
    }

    private boolean isValidLand(final Point p, final int[][] matrix) {
        try {
            return matrix[p.x][p.y] == 1;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isValidBorderPoint(final Point p, final int[][] matrix, final List<Point> moves) {
        try {

            for (Point move : moves) {
                int x = matrix[p.x + move.x][p.y + move.y];
            }

            return false;
        } catch (final Exception e) {
            return true;
        }
    }
}
