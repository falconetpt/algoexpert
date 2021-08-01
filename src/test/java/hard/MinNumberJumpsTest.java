package hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinNumberJumpsTest {

  @Test
  public void minNumberOfJumps_singleElement_returns0() {
    final var expected = MinNumberJumps.minNumberOfJumps(new int[]{ 1 });
    assertEquals(0, expected);
  }

  @Test
  public void minNumberOfJumps_twoOnes_returns1() {
    final var expected = MinNumberJumps.minNumberOfJumps(new int[]{ 1, 1 });
    assertEquals(1, expected);
  }

  @Test
  public void minNumberOfJumps_arrWithOnlyOnes_returnsSizeMinusOnes() {
    final var expected = MinNumberJumps.minNumberOfJumps(new int[]{ 1, 1, 1 });
    assertEquals(2, expected);
  }

  @Test
  public void minNumberOfJumps_arrWithOnlyOnes_returnsSizeMinusOnes2() {
    final var expected = MinNumberJumps.minNumberOfJumps(new int[]{ 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3 });
    assertEquals(4, expected);
  }
}