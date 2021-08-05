package hard;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DiskStackingTest {
  @Test
  public void x() {
    DiskStacking.diskStacking(List.of(
      new Integer[]{2, 1, 2},
      new Integer[]{3, 2, 3},
      new Integer[]{2, 2, 8},
      new Integer[]{2, 3, 4},
      new Integer[]{1, 3, 1},
      new Integer[]{4, 4, 5}
    ));
  }
}