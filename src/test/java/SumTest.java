import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTest {
  @Test
  public void test() {
    final var calculator = new Calculator();
    final var actual = calculator.sum(30, 12);
    assertEquals(42, actual);
  }

  @Test
  public void test2() {
    final var calculator = new Calculator();
    final var actual = calculator.sum(0, 42);
    assertEquals(42, actual);
  }

  @Test
  public void test3() {
    final var calculator = new Calculator();
    final var actual = calculator.sum(7, 2);
    assertEquals(9, actual);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test4() {
    final var calculator = new Calculator();
    calculator.sum(Integer.MAX_VALUE, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test5() {
    final var calculator = new Calculator();
    calculator.sum(Integer.MIN_VALUE, -3);
  }
}
