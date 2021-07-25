package mid;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ValidIPAddressesTest {
  private ValidIPAddresses validIPAddresses;

  @Before
  public void setUp() {
    validIPAddresses = new ValidIPAddresses();
  }

  @Test
  public void validIPAddresses_invalidAddress_returnsEmptyList() {
    final var actual = validIPAddresses.validIPAddresses("9999999");
    final var expected = Set.of();

    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  public void validIPAddresses_singleValidAddress_returnSingletonList() {
    final var actual = validIPAddresses.validIPAddresses("1111");
    final var expected = Set.of("1.1.1.1");

    assertEquals(expected, new HashSet<>(actual));
  }
}