package hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IndexSameValueTest {
  private IndexSameValue indexSameValue;

  @Before
  public void setUp() throws Exception {
    indexSameValue = new IndexSameValue();
  }

  @Test
  public void find_existingElementInOddArray_returnsLastIndex() {
    assertEquals(2, indexSameValue.indexEqualsValue(new int[] {-3, -2, 2}));
  }

  @Test
  public void find_existingFirstElementInOddArray_returnsFirstIndex() {
    assertEquals(0, indexSameValue.indexEqualsValue(new int[] {0, 3, 7}));
  }

  @Test
  public void find_nonExistingElementInOddArray_returnsNegOne() {
    assertEquals(0, indexSameValue.indexEqualsValue(new int[] {0, 3, 7}));
  }
}