/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/unique-paths
@Language: Java
@Datetime: 16-09-17 19:09
*/

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1 ; i < m ; i ++){
            for(int j = 1 ; j < n ; j ++){
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
