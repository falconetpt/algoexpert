package assesments;

import java.util.stream.IntStream;

public class BlobMatch {
    public static boolean globMatching(String fileName, String pattern) {
        // Write your code here.
        boolean result[][] = new boolean[pattern.length() + 1][fileName.length() + 1];

        result[0][0] = true;

        for (int patternIndex = 0; patternIndex < pattern.length(); patternIndex++) {
            for (int fileIndex = 0; fileIndex < fileName.length(); fileIndex++) {
                char patternChar = pattern.charAt( patternIndex );
                char fileChar = fileName.charAt( fileIndex );

                switch (patternChar) {
                    case '*':
                        result[patternIndex + 1][fileIndex + 1]
                                = result[patternIndex + 1][fileIndex] || result[patternIndex][fileIndex + 1];
                        break;
                    case '?':
                        result[patternIndex + 1][fileIndex + 1] = result[patternIndex][fileIndex];
                        break;
                    default:
                        result[patternIndex + 1][fileIndex + 1] = fileChar == patternChar
                                && result[patternIndex][fileIndex];
                        break;
                }
            }
        }

        return result[fileName.length()][pattern.length()];
    }
}
