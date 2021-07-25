package easy;

import java.util.function.Function;
import java.util.stream.IntStream;

public class CaeserCypher {
  public static String caesarCypherEncryptor(String str, int key) {
    Function<Character, Character> encrypt = c -> {
      int newValue = ((c - 'a') + key) % 26;
      return (char) (newValue + 'a');
    };

    // Write your code here.
    return IntStream.range(0, str.length()).boxed()
      .map(str::charAt)
      .map(encrypt)
      .map(String::valueOf)
      .reduce("", String::concat);
  }
}
