/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/longest-common-subsequence
@Language: Java
@Datetime: 16-09-20 04:07
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if(A == null || B == null)
            return 0;
        //dp[i][j] LCS until A[i]B[j]
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for(int i = 1; i <= A.length() ; i ++){
            for(int j = 1; j <= B.length() ; j ++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            } 
        }
        return dp[A.length()][B.length()];
    }
}

