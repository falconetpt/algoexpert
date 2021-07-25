package mid;

import java.util.Arrays;

public class MinNumberCoins {
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    // Write your code here.
    int[] result = new int[n + 1];
    Arrays.fill(result, n + 1);
    result[0] = 0;

    for (int coin : denoms) {
      for (int amount = coin; amount <= n; amount++) {
        result[amount] = Math.min(result[amount], 1 + result[amount - coin]);
      }
    }

    return result[n] < n + 1 ? result[n] : -1;
  }
}
