package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneMnemonic {
  private Map<Character, List<Character>> digitMapping = Map.of(
    '0', List.of('0'),
    '1', List.of('1'),
    '2', List.of('a', 'b', 'c'),
    '3', List.of('d', 'e', 'f'),
    '4', List.of('g', 'h', 'i'),
    '5', List.of('j', 'k', 'l'),
    '6', List.of('m', 'n', 'o'),
    '7', List.of('p', 'q', 'r', 's'),
    '8', List.of('t', 'u', 'v'),
    '9', List.of('w', 'x', 'y', 'z')
  );

  public List<String> phoneNumberMnemonics(final String phoneNumber) {
    final var result = new ArrayList<StringBuffer>();
    result.add(new StringBuffer());

    for (final var digit : phoneNumber.toCharArray()) {
      fillDigits(digit, result);
    }

    return result.stream()
      .map(StringBuffer::toString)
      .filter(s -> s.length() > 0)
      .collect(Collectors.toList());
  }

  private void fillDigits(final char digit, final List<StringBuffer> result) {
    final var newList = digitMapping.get(digit).stream()
      .flatMap(d -> result.stream().map(s -> new StringBuffer(s).append(d)))
      .collect(Collectors.toList());

    result.clear();
    result.addAll(newList);
  }
}
