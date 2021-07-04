package hard;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SearchForRangeTest {

  @Test
  public void searchForRange_NumberDoesNotExist_ReturnsDefaultArray() {
    assertArrayEquals(new int[] { -1, -1 }, SearchForRange.searchForRange(new int[] {}, 1));
  }

  @Test
  public void searchForRange_NumberDoesExist_ReturnsSameIndexArray() {
    assertArrayEquals(new int[] { 1, 1 }, SearchForRange.searchForRange(new int[] {0, 1}, 1));
  }
}