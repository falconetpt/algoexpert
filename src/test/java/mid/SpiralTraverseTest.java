package mid;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class SpiralTraverseTest {
  @Test
  public void testXpto() {
    final List<Integer> actual = SpiralTraverse
      .spiralTraverse(new int[][]{
        {1, 2, 3, 4},
        {12, 13, 14, 5},
        {11, 16, 15, 6},
        {10, 9, 8, 7},
      });
    final List<Integer> expected = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
      .collect(Collectors.toList());

    assertEquals(expected, actual);
  }
}