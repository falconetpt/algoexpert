package mid;

import java.util.*;
import java.util.LinkedList;

public class MinMaxStackObj {


    static class MinMaxStack {
        Deque<Map<String, Integer>> minMax = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();

        public int peek() {
            // Write your code here.
            return stack.getLast();
        }

        public int pop() {
            // Write your code here.
            minMax.removeLast();
            return stack.removeLast();
        }

        public void push(Integer number) {
            stack.addLast(number);
            Map<String, Integer> newMinMax = new HashMap<>();
            newMinMax.put("min", number);
            newMinMax.put("max", number);

            if (minMax.size() > 0) {
                Map<String, Integer> oldValue = minMax.getLast();
                newMinMax.put("min", Math.min(oldValue.get("min"), number));
                newMinMax.put("max", Math.max(oldValue.get("max"), number));
            }

            minMax.addLast(newMinMax);
        }

        public int getMin() {
            // Write your code here.
            return minMax.getLast().get("min");
        }

        public int getMax() {
            // Write your code here.
            return minMax.getLast().get("max");
        }
    }
}
