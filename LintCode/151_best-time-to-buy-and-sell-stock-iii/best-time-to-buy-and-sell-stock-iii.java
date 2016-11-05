/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iii
@Language: Java
@Datetime: 16-10-09 19:29
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int min = prices[0];
        int max = prices[prices.length - 1];
        left[0] = 0;
        for(int i = 1 ;i < prices.length ; i ++){
            left[i] = Math.max(prices[i] - min, left[i-1]);
            min = Math.min(min, prices[i]);
        }
        right[prices.length - 1] = 0;
        for(int i = prices.length - 2 ;i >= 0 ; i --){
            right[i] = Math.max(max - prices[i], right[i+1]);
            max = Math.max(max, prices[i]);
        }  
        int profit = Integer.MIN_VALUE;
        for(int i = 0 ; i < prices.length ; i ++){
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }
};