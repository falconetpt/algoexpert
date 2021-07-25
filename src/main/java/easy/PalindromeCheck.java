package easy;

public class PalindromeCheck {
  public static boolean isPalindrome(String str) {
    // Write your code here.
    return new StringBuilder(str).reverse().toString()
      .equals(str);
  }
}
