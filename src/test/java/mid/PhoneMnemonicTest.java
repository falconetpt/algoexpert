package mid;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class PhoneMnemonicTest {
  private PhoneMnemonic phoneMnemonic;

  @Before
  public void setUp() {
    phoneMnemonic = new PhoneMnemonic();
  }

  @Test
  public void phoneNumberMnemonics_emptyPhoneNumber_returnsEmpty() {
    final var actual = phoneMnemonic.phoneNumberMnemonics("");
    final var expected = Set.of();

    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  public void phoneNumberMnemonics_zeroPhoneNumber_returnsSameAsOriginal() {
    final var actual = phoneMnemonic.phoneNumberMnemonics("0");
    final var expected = Set.of("0");

    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  public void phoneNumberMnemonics_onePhoneNumber_returnsSameAsOriginal() {
    final var actual = phoneMnemonic.phoneNumberMnemonics("1");
    final var expected = Set.of("1");

    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  public void phoneNumberMnemonics_multipleZerosPhoneNumber_returnsSameAsOriginal() {
    final var actual = phoneMnemonic.phoneNumberMnemonics("00000");
    final var expected = Set.of("00000");

    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  public void phoneNumberMnemonics_multipleOnesPhoneNumber_returnsSameAsOriginal() {
    final var actual = phoneMnemonic.phoneNumberMnemonics("111");
    final var expected = Set.of("111");

    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  public void phoneNumberMnemonics_mixZeroAndOnesPhoneNumber_returnsSameAsOriginal() {
    final var actual = phoneMnemonic.phoneNumberMnemonics("0101100");
    final var expected = Set.of("0101100");

    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  public void phoneNumberMnemonics_two_returnsListOfAbc() {
    final var actual = phoneMnemonic.phoneNumberMnemonics("2");
    final var expected = Set.of("a", "b", "c");

    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  public void phoneNumberMnemonics_three_returnsListOfDef() {
    final var actual = phoneMnemonic.phoneNumberMnemonics("3");
    final var expected = Set.of("d", "e", "f");

    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  public void phoneNumberMnemonics_twoMixedWithOnes_returnsListOfAbcWithOnes() {
    final var actual = phoneMnemonic.phoneNumberMnemonics("121");
    final var expected = Set.of("1a1", "1b1", "1c1");

    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  public void phoneNumberMnemonics_twoMixedWithZeros_returnsListOfAbcWithZeros() {
    final var actual = phoneMnemonic.phoneNumberMnemonics("0200");
    final var expected = Set.of("0a00", "0b00", "0c00");

    assertEquals(expected, new HashSet<>(actual));
  }
}