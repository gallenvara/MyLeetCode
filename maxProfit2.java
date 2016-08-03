/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
(1,4,4,3,10,6,5) --> (1,4),(3,10) --> 10
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[] f = new int[50000];
        f[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]){
                f[i] = Math.min(prices[i], f[i - 1]);
            } else {
                f[i] = prices[i];
            }
        }
        int max = 0;
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            max = Math.max(max, prices[i] - f[i]);
            if (prices[i] > prices[i + 1]) {
                sum += max;
                max = 0;
            }
        }
        if (max < prices[length - 1] - f[length - 1]) {
            max = prices[length - 1] - f[length - 1];
        }
        sum += max;
        return sum;
    }
}