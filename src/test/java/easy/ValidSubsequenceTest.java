package easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ValidSubsequenceTest {

    @Test
    public void isValidSubsequence() {

        Integer[] array = new Integer[] { 5, 1, 22, 25, 6, -1, 8, 10};
        Integer[] sequence = new Integer[] { 1, 6, -1, 10 };

        assertTrue( ValidSubsequence.isValidSubsequence( Arrays.asList( array ), Arrays.asList( sequence ) ) );
    }
}