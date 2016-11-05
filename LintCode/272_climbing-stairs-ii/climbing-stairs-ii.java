/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/climbing-stairs-ii
@Language: Java
@Datetime: 16-09-18 15:07
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        // Write your code here
        if(n == 0) return 1;
        if(n == 1) return 1;
        int [] dp = new int [n  + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3 ; i <= n; i ++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        return dp[n];
    }
}