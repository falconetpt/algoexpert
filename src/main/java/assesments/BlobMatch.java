package assesments;

import java.util.stream.IntStream;

public class BlobMatch {
    public static boolean globMatching(String fileName, String pattern) {
        // Write your code here.
        boolean result[][] = new boolean[fileName.length() + 1][pattern.length() + 1];

        result[0][0] = true;

        for (int r = 0; r < fileName.length(); r++) {
            for (int c = 0; c < fileName.length(); c++) {
                char fileChar = fileName.charAt( r );
                char patternChar = fileName.charAt( c );


            }
        }

        return result[fileName.length()][pattern.length()];
    }
}
