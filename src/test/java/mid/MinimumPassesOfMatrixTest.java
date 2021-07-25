package mid;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumPassesOfMatrixTest {

  @Test
  public void x() {
    assertEquals(3, new MinimumPassesOfMatrix().minimumPassesOfMatrix(
      new int[][]{
        {0, -1, -3, 2, 0},
        {1, -2, -5, -1, -3},
        {3, 0, 0, -4, -1}
      }
    ));
  }
}