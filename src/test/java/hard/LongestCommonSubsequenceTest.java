package hard;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LongestCommonSubsequenceTest {

  @Test
  public void longestCommonSubsequence_emptyFirstString_returnsEmptyList() {
    final var actual = LongestCommonSubsequence.longestCommonSubsequence("", "xyz");
    assertEquals(List.of(), actual);
  }

  @Test
  public void longestCommonSubsequence_emptySecondString_returnsEmptyList() {
    final var actual = LongestCommonSubsequence.longestCommonSubsequence("dfasf", "");
    assertEquals(List.of(), actual);
  }

  @Test
  public void longestCommonSubsequence_noCharMatches_returnsEmptyList() {
    final var actual = LongestCommonSubsequence.longestCommonSubsequence("abc", "def");
    assertEquals(List.of(), actual);
  }

  @Test
  public void longestCommonSubsequence_onlyOneCharMatches_returnsSingleCharList() {
    final var actual = LongestCommonSubsequence.longestCommonSubsequence("deafd", "poiusaioik");
    assertEquals(List.of('a'), actual);
  }

  @Test
  public void longestCommonSubsequence_largeString_returnsMatching() {
    final var actual = LongestCommonSubsequence.longestCommonSubsequence("ZXVVYZW", "XKYKZPW");
    assertEquals(List.of('X', 'Y', 'Z', 'W'), actual);
  }
}