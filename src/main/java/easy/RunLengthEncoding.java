package easy;

public class RunLengthEncoding {
  public String runLengthEncoding(final String string) {
    // Write your code here.
    return runLengthEncoding(string, 0, ' ', 0, "");
  }

  private String runLengthEncoding(String string, int i, char value, int count, String result) {
    if (i >= string.length()) {

      if (count > 0) {
        if (count > 9) {
          result += 9 + String.valueOf(value);
          return runLengthEncoding(string, i, value, count - 9, result);
        } else {
          result += count + String.valueOf(value);
        }
      }

      return result;
    } else {
      final char element = string.charAt(i);
      if (element != value) {
        if (count > 0) {
          if (count > 9) {
            return runLengthEncoding(string, i, value, count - 9, result + 9 + value);
          } else {
            return runLengthEncoding(string, i + 1, element, 1, result + count + value);
          }
        } else {
          return runLengthEncoding(string, i + 1, element, 1, result);
        }
      } else {
        return runLengthEncoding(string, i + 1, value, count + 1, result);
      }
    }
  }
}
