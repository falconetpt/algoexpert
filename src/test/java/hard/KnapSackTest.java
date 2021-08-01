package hard;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class KnapSackTest {
  @Test
  public void knapsackProblem_emptyInput_returnsEmptyList() {
    final var actual = KnapSack.knapsackProblem(new int[][]{}, 13);
    final var expected = List.of(
      List.of(0),
      List.of()
    );

    assertEquals(expected, actual);
  }

  @Test
  public void knapsackProblem_capacityLessThanItems_returnsEmptyList() {
    final var actual = KnapSack.knapsackProblem(new int[][]{
      {12, 3}
    }, 2);
    final var expected = List.of(
      List.of(0),
      List.of()
    );

    assertEquals(expected, actual);
  }

  @Test
  public void knapsackProblem_capacityCanOnlyPickOneItem_returnsSingleElementList() {
    final var actual = KnapSack.knapsackProblem(new int[][]{
      {12, 4},
      {24, 5}
    }, 4);
    final var expected = List.of(
        List.of(12),
        List.of(0)
      );

    assertEquals(expected, actual);
  }

  @Test
  public void knapsackProblem_capacityCanPickMultipleOptions_returnsElementList() {
    final var actual = KnapSack.knapsackProblem(new int[][]{
        {1, 2},
        {4, 3},
        {5, 6},
        {6, 7}
      }, 10);
    final var expected = List.of(
      List.of(10),
      List.of(3, 1)
    );

    assertEquals(expected, actual);
  }
}