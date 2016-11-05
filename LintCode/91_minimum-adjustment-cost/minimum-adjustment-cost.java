/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/minimum-adjustment-cost
@Language: Java
@Datetime: 16-09-23 03:39
*/

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int n = A.size();
        //A.i 变成 j 最小的 cost 总和
        int [][] dp = new int [n + 1][101];
        
        for (int j = 0 ; j < 101 ; j ++){
            dp[0][j] = Math.abs(j - A.get(0));
        }
        
        for(int i = 1; i < A.size(); i ++){
            for(int j = 0; j < 101; j ++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0 ; k < 101 ; k ++){
                    if(Math.abs(j - k) <= target)
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(j - A.get(i)));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < 101; i ++){
            min = Math.min(min, dp[A.size() - 1][i]);
        }
        return min;        
        
    }
}