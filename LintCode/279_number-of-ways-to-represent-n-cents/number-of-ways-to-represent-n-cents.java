/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/number-of-ways-to-represent-n-cents
@Language: Java
@Datetime: 16-09-24 20:55
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */

    public int waysNCents(int n) {
        // Write your code here
     	int [] dp = new int [n + 1];
     	dp[0] = 1;
     	int [] coin = new int [] {1, 5, 10 ,25};
     	for(int i = 0; i < coin.length ; i++){
     	    for(int j = 1; j <= n ; j ++){
     	        if(j >= coin[i]){
     	            dp[j] += dp[j - coin[i]];
     	        }
     	    }
     	}
     	return dp[n];
    }
}