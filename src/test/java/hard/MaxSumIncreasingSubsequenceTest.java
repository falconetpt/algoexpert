package hard;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MaxSumIncreasingSubsequenceTest {
  @Test
  public void maxSumIncreasingSubsequence_empty_returnsTwo() {
    final var actual = MaxSumIncreasingSubsequence
      .maxSumIncreasingSubsequence(
        new int[]{}
      );

    final var expected = List.of(
      List.of(0),
      List.of()
    );

    assertEquals(expected, actual);
  }

  @Test
  public void maxSumIncreasingSubsequence_singleNumberTwo_returnsTwo() {
    final var actual = MaxSumIncreasingSubsequence
      .maxSumIncreasingSubsequence(
        new int[]{2}
      );

    final var expected = List.of(
      List.of(2),
      List.of(2)
    );

    assertEquals(expected, actual);
  }

  @Test
  public void maxSumIncreasingSubsequence_ascendingSequence_returnsSum() {
    final var actual = MaxSumIncreasingSubsequence
      .maxSumIncreasingSubsequence(
        new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9}
      );

    final var expected = List.of(
      List.of(45),
      List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
    );

    assertEquals(expected, actual);
  }

  @Test
  public void maxSumIncreasingSubsequence_descendingArray_returnsFirstNumber() {
    final var actual = MaxSumIncreasingSubsequence
      .maxSumIncreasingSubsequence(
        new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
      );

    final var expected = List.of(
      List.of(10),
      List.of(10)
    );

    assertEquals(expected, actual);
  }

  @Test
  public void maxSumIncreasingSubsequence_randomArray_returnsMaxSum() {
    final var actual = MaxSumIncreasingSubsequence
      .maxSumIncreasingSubsequence(
        new int[]{10, 70, 20, 30, 50, 11, 30}
      );

    final var expected = List.of(
      List.of(110),
      List.of(10, 20, 30, 50)
    );

    assertEquals(expected, actual);
  }


}