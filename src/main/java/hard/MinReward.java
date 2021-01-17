package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MinReward {
    public static int minRewards(int[] scores) {
        Map<Integer, Integer> seen = new HashMap<>();
       IntStream.range(0, scores.length).boxed()
               .filter(i -> isValley(scores, i))
               .forEach(i -> minRewards(scores, seen, Integer.MIN_VALUE, i, 0));

       return seen.values().stream()
               .reduce(0, Integer::sum);
    }

    private static int minRewards(int[] scores,
                                  Map<Integer, Integer> seen,
                                  int minValue,
                                  int i,
                                  int acc) {
        if (i >= scores.length || i < 0) {
            return 0;
        } else {
            if (scores[i] <= minValue) {
                return 0;
            }  else {
                minRewards(scores, seen, scores[i], i + 1, acc + 1);
                minRewards(scores, seen, scores[i], i - 1, acc + 1);

                seen.put(i, Math.max(seen.getOrDefault(i, 1), acc + 1));
                return seen.get(i);
            }
        }
    }

    private static boolean isValley(int[] scores, int i) {
        int left = extractValue(scores, i + 1);
        int right = extractValue(scores, i + 1);

        return left > scores[i] && right > scores[i];
    }

    private static int extractValue(int[] scores, int i) {
        try {
            return scores[i];
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
    }
}
