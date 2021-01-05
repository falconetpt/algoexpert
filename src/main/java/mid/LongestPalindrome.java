package mid;

import java.util.Arrays;

public class LongestPalindrome {
    public static String longestPalindromicSubstring(final String str) {
        String result = "";

        for (int i = 0, n = str.length(); i < n; i ++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (new StringBuilder(sb).toString().equals(new StringBuilder(sb).reverse().toString())) {
                    if (sb.length() > result.length()) result = new StringBuilder(sb).toString();
                }

                sb = sb.append(str.charAt(j));
                System.out.println("sb.toString() = " + sb.toString());
            }

            if (new StringBuilder(sb).toString().equals(new StringBuilder(sb).reverse().toString())) {
                if (sb.length() > result.length()) result = new StringBuilder(sb).toString();
            }

        }

        return result;
    }
}
