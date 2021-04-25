package mid;

import org.junit.Test;

public class ValidStartingCityTest {

  @Test
  public void testValidStartingCity() {
    final int index = new ValidStartingCity()
      .validStartingCity(
        new int[]{5, 25, 15, 10, 15},
        new int[]{1,2,1,0,3},
        10
      );
    System.out.println("index = " + index);
  }
}