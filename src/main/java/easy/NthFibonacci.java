package easy;

import java.util.List;

public class NthFibonacci {
    public static int getNthFib(int n) {
        // Write your code here.
        if (n < 0) {
            return -1;
        } else {

            switch (n) {
                case 1:
                    return 0;
                case 2:
                    return 1;
                default:
                    return getNthFib( n, 0, 1, 2 );
            }
        }
    }

    private static int getNthFib(int n, int prev, int next, int current) {
        if (n == current) {
            return next;
        }  else {
            return getNthFib( n, next, next + prev, current + 1 );
        }
    }
}
