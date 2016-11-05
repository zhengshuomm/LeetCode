/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/backpack
@Language: Java
@Datetime: 16-09-25 21:57
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if(m == 0 || A == null)
            return 0;
        //前i个物品放到体积为m的包里，有多少种方式
        int [][] dp = new int [A.length + 1][m + 1];
        
        for(int i = 1 ; i <= A.length; i ++){
            for(int j = 0 ; j <= m ; j ++){
                dp[i][j] = dp[i - 1][j];
                if(j >= A[i - 1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + A[i - 1]);
                }
            }
        }
        return dp[A.length][m];
    }
}