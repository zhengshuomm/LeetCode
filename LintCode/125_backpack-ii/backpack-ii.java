/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/backpack-ii
@Language: Java
@Datetime: 16-09-25 22:24
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
       if(m == 0 || A == null)
            return 0;
        //前i个物品放到体积为m的包里，可以有多大value
        int [][] dp = new int [A.length + 1][m + 1];
        
        for(int i = 1 ; i <= A.length; i ++){
            for(int j = 0 ; j <= m ; j ++){
                dp[i][j] = dp[i - 1][j];
                if(j >= A[i - 1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[A.length][m];
    }
}