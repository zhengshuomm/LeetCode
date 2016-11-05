/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/minimum-path-sum
@Language: Java
@Datetime: 16-09-17 22:05
*/

public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        
        if(grid == null)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        if(m == 0 || n == 0)
            return 0;
        
        int [][] dp = new int [m][n];
        
        dp[0][0] = grid[0][0];
        
        for(int i = 1 ; i < m ; i ++){
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for(int j = 1 ; j < n ; j ++){
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        
        for(int i = 1 ; i < m ; i ++){
            for(int j = 1; j < n ; j ++){
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
