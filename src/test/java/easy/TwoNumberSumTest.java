package easy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class TwoNumberSumTest {
    @Parameterized.Parameters(name = "{index}: {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                    "Null input should return empty",
                    new int[] {},
                    new int[] {},
                    0
                },
                {
                    "Empty input should return empty",
                    new int[] {},
                    new int[] {},
                    0
                },
                {
                    "Single element input should return empty",
                    new int[] { 1 },
                    new int[] {},
                    1
                },
                {
                    "Pair element input that don't match sum should return empty",
                    new int[] { 1, 3 },
                    new int[] {},
                    1
                },
                {
                    "Pair element input that match sum should return elements",
                    new int[] { 1, 3 },
                    new int[] { 1, 3},
                    4
                },
                {
                    "Large input that match sum should return elements",
                    new int[] { 3, 5, -4, 8, 11, 1, -1, 6 },
                    new int[] { -1, 11},
                    10
                }

        });
    }

    private String description;
    private int[] input;
    private int[] expected;
    private int sumTarget;

    public TwoNumberSumTest(final String description,
                            final int[] input,
                            final int[] expected,
                            final int sumTarget) {
        this.description = description;
        this.input = input;
        this.expected = expected;
        this.sumTarget = sumTarget;
    }

    @Test
    public void test() {
        int[] result = TwoNumberSum.twoNumberSum( this.input, this.sumTarget );

        Arrays.sort( result );
        Arrays.sort( this.expected );

        assertArrayEquals(this.expected, result);
    }
}