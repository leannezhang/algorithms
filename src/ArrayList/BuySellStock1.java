package src.ArrayList;

import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example :

 Input : [1 2]
 Return :  1

 Input: [10,5,20,90,85]
 Return: 85

 (Lowest stock price: 5, maxProfit = 85)

 * Created by liyangzhang on 2016-03-27.
 */
public class BuySellStock1 {

    // We should keep track of maxProfit and lowestStockPrice
    // Run time: O(n)
    // Space time: 2

    public int maxProfit(final List<Integer> a) {
        if (a.size() < 2) {
            return 0;
        }

        int lowestStockPrice = a.get(0);
        int maxProfit = 0;

        for (int i = 0; i < a.size(); i++) {

            int diff = a.get(i) - lowestStockPrice;
            maxProfit =  Math.max(diff, maxProfit);
            lowestStockPrice = Math.min(a.get(i),lowestStockPrice);

        } return maxProfit;

    }
}
