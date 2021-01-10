package hard;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Map<Integer, List<Point>> map = getAllCombos(array, 0, new HashMap<>());
        return new ArrayList<>(map.keySet().stream()
                .filter(map::containsKey)
                .filter(x -> map.containsKey(targetSum - x))
                .filter(x -> x != targetSum - x)
                .flatMap(x -> collectAll(map.get(x), map.get(targetSum - x)).stream())
                .distinct()
                .map(x -> x.stream().toArray(Integer[]::new))
                .collect(Collectors.toSet()));
    }

    private static Set<List<Integer>> collectAll(List<Point> points, List<Point> points1) {
        Set<List<Integer>> result = new HashSet<>();

        for (Point point1 : points) {
            for (Point point2: points1) {
                List<Integer> element = Stream.of(point1.x, point1.y, point2.x, point2.y)
                        .sorted()
                        .distinct()
                        .collect(Collectors.toList());
                if (element.size() == 4) {
                    result.add(element);
                }
            }
        }

        return result;
    }

    public static Map<Integer, List<Point>> getAllCombos(int[] array, int i, Map<Integer, List<Point>> result) {
        if (i >= array.length) {
            return result;
        } else {
            IntStream.range(i + 1, array.length)
                    .peek(x -> result.putIfAbsent(array[x] + array[i], new ArrayList<>()))
                    .forEach(x -> result.get(array[x] + array[i]).add(new Point(array[x], array[i])));
            return getAllCombos(array, i + 1, result);
        }
    }
}
