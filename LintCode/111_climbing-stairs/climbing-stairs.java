/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/climbing-stairs
@Language: Java
@Datetime: 16-09-17 21:13
*/

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n == 0) return 1;
        
        int [] dp = new int [n  + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2 ; i <= n; i ++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}