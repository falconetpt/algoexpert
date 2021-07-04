public class Calculator {
  public int sum(int a, int b) {
    int sum = a + b;

    if (sum < a && sum < b) {
      throw new IllegalArgumentException();
    } else {
      return sum;
    }
  }
}
