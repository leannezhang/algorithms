package Stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given an array, find the nearest/closest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
 https://en.wikipedia.org/wiki/All_nearest_smaller_values

 More formally,

 G[i] for an element A[i] = an element A[j] such that
 j is maximum possible AND
 j < i AND
 A[j] < A[i]
 Elements for which no smaller element exist, consider next smaller element as -1.

 Example:

 Input : A : [4, 5, 2, 10]
 Return : [-1, 4, -1, 2]

 Example 2:

 Input : A : [3, 2, 1]
 Return : [-1, -1, -1]

 Tip: NearestSamllerElement means the closest smallest number.
 Push each element to the stack as you go and pop() any larger number.
 This will result the top of stack is always the smallest and closest to the current item.

 * Created by liyangzhang on 2016-05-29.
 */
public class NearestSmallerElement {
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> input) {
        ArrayList<Integer> output = new ArrayList<Integer>(input.size());
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i< input.size(); i++) {

            Integer currentItem = input.get(i);
            while ( !stack.isEmpty() && stack.peek() >= currentItem ) {
                stack.pop();
            }
            if (  !stack.isEmpty() && stack.peek() < currentItem) {
                output.add(stack.peek());
                stack.push(currentItem);
            }
            else {
                stack.push(currentItem);
                output.add(-1);
            }

        }
        return output;
    }
}
