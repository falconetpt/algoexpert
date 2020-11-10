package mid;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LeveshteinDistance {
    public static int levenshteinDistance(final String str1, final String str2) {

        if (str1.length() == 0 || str2.length() == 0) {
            return Math.max( str1.length(), str2.length() );
        }
        // Write your code here.
        int[][] result = new int[str1.length() + 1][str2.length() + 1];

        result[0][0] = 0;
        IntStream.rangeClosed( 1, str1.length() ).forEach( r -> result[r][0] = 1 + result[r-1][0] );
        IntStream.rangeClosed( 1, str2.length() ).forEach( c -> result[0][c] = 1 + result[0][c-1] );

        for (int r = 1; r <= str1.length(); r++) {
            for (int c = 1; c <= str2.length(); c++) {
                if (str1.charAt( r - 1 ) == str2.charAt( c - 1 )) {
                    result[r][c] = result[r-1][c-1];
                } else {
                    result[r][c] = 1 + Math.min( result[r-1][c-1],Math.min( result[r-1][c], result[r][c-1] ));
                }
            }
        }

        return result[str1.length()][str2.length()];
    }
}
