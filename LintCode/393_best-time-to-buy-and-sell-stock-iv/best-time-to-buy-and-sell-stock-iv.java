/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iv
@Language: Java
@Datetime: 16-10-10 01:33
*/

class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0)
            return 0;
        
        if(k > prices.length){
            int profit = 0;
            for(int i = 1 ; i < prices.length; i ++){
                if(prices[i] > prices[i - 1]){
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int len = prices.length ;
        int[][] local = new int[len][k+1]; // local[i][j]: max profit till i day, j transactions,
// sell on i day
        int[][] global = new int[len][k+1]; 
        // global[i][j]: max profit across i days, j transactions   not necessarily buy/sell on day i
        for(int i = 1 ; i < len ; i ++){
            int diff = prices[i] - prices[i - 1];
            for(int j=1; j<=k; j++) {

                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[len-1][k];

    }
}