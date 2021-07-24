package mid;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SufixTest {
  @Test
  public void contains_noMatchingChar_returnsFalse() {
    final var actual = new Sufix.SuffixTrie("xpto");
    assertFalse(actual.contains("l"));
  }

  @Test
  public void contains_noMatchingSequence_returnsFalse() {
    final var actual = new Sufix.SuffixTrie("xpto");
    assertFalse(actual.contains("toe"));
  }

  @Test
  public void contains_allValue_returnsTrue() {
    final var actual = new Sufix.SuffixTrie("xpto");
    assertTrue(actual.contains("xpto"));
  }

  @Test
  public void contains_lastCharacter_returnsTrue() {
    final var actual = new Sufix.SuffixTrie("xpto");
    assertTrue(actual.contains("o"));
  }

  @Test
  public void contains_lastTwoCharacters_returnsTrue() {
    final var actual = new Sufix.SuffixTrie("xpto");
    assertTrue(actual.contains("to"));
  }

  @Test
  public void contains_lastThreeChar_returnsTrue() {
    final var actual = new Sufix.SuffixTrie("babc");
    assertTrue(actual.contains("abc"));
  }

  @Test
  public void contains_lastTwo_returnsTrue() {
    final var actual = new Sufix.SuffixTrie("babc");
    assertTrue(actual.contains("babc"));
  }

  @Test
  public void contains_allElemtnts_returnsTrue() {
    final var actual = new Sufix.SuffixTrie("babc");
    assertTrue(actual.contains("bc"));
  }

  @Test
  public void contains_lastTwoEqualsToFirstTwo_returnsTrue() {
    final var actual = new Sufix.SuffixTrie("bcbc");
    assertTrue(actual.contains("bc"));
  }
}