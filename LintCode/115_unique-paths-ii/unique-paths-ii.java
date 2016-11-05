/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/unique-paths-ii
@Language: Java
@Datetime: 16-09-17 23:05
*/

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        //status
        if(obstacleGrid == null)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(m == 0 || n == 0)
            return 0;
        
        int [][] dp = new int[m][n];
        
        for(int i = 0 ; i < m ; i ++){
            if(obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }
        for(int j = 0 ; j < n ; j ++){
            if(obstacleGrid[0][j] == 1)
                break;
            dp[0][j] = 1;
        }
        
        for(int i = 1 ; i < m ; i ++){
            for(int j = 1 ; j < n ; j ++){
                if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }        
        return dp[m - 1][n - 1];
    }
}