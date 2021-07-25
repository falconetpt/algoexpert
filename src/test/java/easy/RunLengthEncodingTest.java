package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RunLengthEncodingTest {
  @Test
  public void emptyShouldReturnEmpty() {
    RunLengthEncoding runLengthEncoding = new RunLengthEncoding();

    assertEquals("", runLengthEncoding.runLengthEncoding(""));
  }

  @Test
  public void singleElement() {
    RunLengthEncoding runLengthEncoding = new RunLengthEncoding();

    assertEquals("1A", runLengthEncoding.runLengthEncoding("A"));
  }

  @Test
  public void multipleElements() {
    RunLengthEncoding runLengthEncoding = new RunLengthEncoding();

    assertEquals("9A4A2B4C2D", runLengthEncoding.runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    assertEquals("9A3A", runLengthEncoding.runLengthEncoding("AAAAAAAAAAAA"));
  }
}