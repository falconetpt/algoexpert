package mid;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PowerSetTest {

  @Test
  public void powerset() {
    final List<List<Integer>> actual = PowerSet.powerset(Arrays.asList(1, 2, 3));
    final List<List<Integer>> expected = Arrays.asList(
      Arrays.asList(),
      Arrays.asList(1),
      Arrays.asList(2),
      Arrays.asList(3),
      Arrays.asList(1, 2),
      Arrays.asList(2, 3),
      Arrays.asList(1, 3),
      Arrays.asList(1, 2, 3)
    );

    assertEquals(expected, actual);
  }
}