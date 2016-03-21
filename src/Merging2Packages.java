package src;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  Merging 2 Packages

    Given a package with a weight limit and an array arr of item weights, how can you most efficiently find two items with sum of weights that equals the weight limit?

    Your function should return 2 such indices of item weights or -1 if such pair doesn't exist.
    What is the runtime and space complexity of your solution?

 *
 */
public class Merging2Packages {

    public static void main(String[] args){
        ArrayList<Integer> weights = new ArrayList<Integer>(5);
        weights.add(1);
        weights.add(5);
        weights.add(7);
        weights.add(8);
        weights.add(10);
        int limit = 8;

        findComplementingWeights(weights, limit);

    }

    /**
     * This is a hash map question
     * key: complementary weight
     * value: complementary index
     *
     * key | value
     * 7   | 0
     * 3   | 1
     * 1   | 2
     * 0   | 3
     * -2  | 4
     *
     *
     * @param weights
     * @param limit
     */
    public static void findComplementingWeights(ArrayList<Integer> weights, int limit) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        boolean found = false;

        for (int i=0; i <weights.size(); i++) {

            int currentWeight = weights.get(i);
            int complementaryWeight = limit - currentWeight;

            if (!map.containsKey(currentWeight)) {
                map.put(complementaryWeight, i);
            } else {
                System.out.println("Index: " + map.get(currentWeight));
                System.out.println("Complementary Index: " + i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("-1");
        }

    }

    // Run time: O(n)
    // Space: O(n)
}
