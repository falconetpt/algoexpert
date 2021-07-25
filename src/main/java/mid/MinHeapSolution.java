package mid;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinHeapSolution {
  static class MinHeap {
    List<Integer> heap;

    public MinHeap(List<Integer> array) {
      heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {

      // Write your code here.
      return array.stream().sorted().collect(Collectors.toList());
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
      // Write your code here.
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
      // Write your code here.
    }

    public int peek() {
      // Write your code here.
      return heap.get(0);
    }

    public int remove() {
      // Write your code here.
      return heap.remove(0);
    }

    public void insert(int value) {
      // Write your code here.
      int index = calculateIndex(value, 0, heap.size());
      heap.add(index, value);
    }

    private int calculateIndex(int value, int start, int end) {
      return IntStream.range(start + 1, end)
        .filter(i -> heap.get(i - 1) <= value && heap.get(i) >= value)
        .findFirst()
        .orElse(value <= heap.get(0) ? 0 : heap.size() - 1);
    }
  }
}
