package hard;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxSumIncreasingSubsequence {
  public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
    final var subSequences = new PriorityQueue<>(Comparator.comparing(SequenceInformation::getLast));

    fillSubSequences(array, 0, subSequences);

    final var maxSum = subSequences.stream()
      .max(Comparator.comparingInt(SequenceInformation::getSum));

    // Write your code here.
    return List.of(
      maxSum
        .map(SequenceInformation::getSum)
        .map(List::of)
        .orElse(List.of(0)),
      maxSum
        .map(SequenceInformation::getSequence)
        .orElse(List.of())
    );
  }

  private static void fillSubSequences(final int[] array,
                                       final int i,
                                       final PriorityQueue<SequenceInformation> subSequences) {
    if (i < array.length) {
      final var value = array[i];

      if (subSequences.isEmpty() || subSequences.peek().getLast() >= value) {
        subSequences.add(new SequenceInformation(value, 0, new LinkedList<>()));
      } else {
        final var sequences = subSequences.stream()
          .filter(s -> s.getLast() < value)
          .flatMap(s -> Stream.of(new SequenceInformation(value, s.sum, s.queue), new SequenceInformation(value, 0, new LinkedList<>())))
          .collect(Collectors.toList());
        subSequences.addAll(sequences);
      }

      fillSubSequences(array, i + 1, subSequences);
    }
  }


  static class SequenceInformation {
    private int sum = 0;
    private final LinkedList<Integer> queue;

    SequenceInformation(final int value, final int sum, final LinkedList<Integer> queue) {
      this.queue = new LinkedList<>(queue);
      this.sum = sum;
      addValue(value);
    }

    public void addValue(final int value) {
      queue.addLast(value);
      sum += value;
    }

    public int getLast() {
      return queue.peekLast();
    }

    public int getSum() {
      return sum;
    }

    public List<Integer> getSequence() {
      return queue;
    }
  }
}
