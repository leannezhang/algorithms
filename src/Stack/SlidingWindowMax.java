package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Not finished...
 * Created by liyangzhang on 2016-05-31.
 */
public class SlidingWindowMax {
        // DO NOT MODIFY THE LIST
        public static ArrayList<Integer> slidingMaximum(final List<Integer> input, int w) {

            // ArrayList<Integer> output = new ArrayList<Integer>(input.size());
            Stack<Integer> s = new Stack<Integer>();
            if (input.size() <= 0) {
                return new ArrayList<Integer>();
            }

            //find the max among the first moving window
            int endIndex = w-1 ;
            if (w > input.size()) {
                endIndex = input.size() - 1;
            }
            Integer max = findMax(input, endIndex);
            s.push(max);

            // compare preivous max to last element in the moving window
            // push the current max to stack
            if ( w < input.size()) {
                for (int i = w; i < input.size(); i++) {
                    Integer top = s.peek();
                    if (input.get(i) > top) {
                        s.push(input.get(i));
                    } else {
                        s.push(top);
                    }
                }
            }


            ArrayList<Integer> output = new ArrayList<Integer>(s);
            return output;

        }

        public static Integer findMax(final List<Integer> input, int endIndex) {

            Integer max = input.get(0);

            if (endIndex >= 1) {
                for (int i=1; i <= endIndex; i++ ) {
                    if (input.get(i) > max) {
                        max = input.get(i);
                    }
                }
            }

            return max;
        }

        public static void main(String[] args) {

        }

}
