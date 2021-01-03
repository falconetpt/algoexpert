package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PowerSet {
    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();

        IntStream.range(0, array.size())
                .forEach(x -> IntStream.range(x, array.size()).forEach(y -> {
                    List<Integer> localArr = new ArrayList<>();
                    IntStream.rangeClosed(x, y).forEach(v -> localArr.add(array.get(v)));
                    result.add(localArr);
                }));

        return result;
    }
}
