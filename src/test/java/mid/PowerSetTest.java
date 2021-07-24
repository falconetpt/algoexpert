package mid;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class PowerSetTest {
  @Test
  public void powerset_emptyInput_returnsSingleSet() {
    final List<List<Integer>> actual = PowerSet.powerset(List.of());
    final Set<Set<Integer>> expected = Set.of(Set.of());

    assertEquals(expected, covertToSet(actual));
  }

  @Test
  public void powerset_singleInput_returnsEmptySetAndSingleNumSet() {
    final List<List<Integer>> actual = PowerSet.powerset(List.of(1));
    final Set<Set<Integer>> expected = Set.of(Set.of(), Set.of(1));

    assertEquals(expected, covertToSet(actual));
  }

  @Test
  public void powerset_threeDigits_returnsSevenList() {
    final List<List<Integer>> actual = PowerSet.powerset(Arrays.asList(1, 2, 3));
    final Set<Set<Integer>> expected = Set.of(
      Set.of(),
      Set.of(1),
      Set.of(2),
      Set.of(3),
      Set.of(1, 2),
      Set.of(2, 3),
      Set.of(1, 3),
      Set.of(1, 2, 3)
    );

    assertEquals(expected, covertToSet(actual));
  }

  private Set<Set<Integer>> covertToSet(final List<List<Integer>> expected) {
    return expected.stream()
      .map(HashSet::new)
      .collect(Collectors.toSet());
  }
}