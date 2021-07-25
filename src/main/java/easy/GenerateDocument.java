package easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenerateDocument {
  public boolean generateDocument(final String characters,
                                  final String document) {
    if (document.length() == 0) return true;
    Map<String, Long> charactersFrequency = Arrays.stream(characters.split(""))
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Map<String, Long> documentFrequency = Arrays.stream(document.split(""))
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    // Write your code here.
    return documentFrequency.keySet().stream()
      .allMatch(i -> charactersFrequency.getOrDefault(i, 0L) >= documentFrequency.getOrDefault(i, 0L));
  }
}
