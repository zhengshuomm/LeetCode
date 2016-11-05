/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/distinct-subsequences
@Language: Java
@Datetime: 16-09-22 03:27
*/

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        
        if (S == null || T == null) {
            return 0;
        }
        //S 的前i中 取T的前j 有多少种可能
        int [][] dp = new int [S.length() + 1][T.length() + 1];
        
        for(int i = 0 ; i <= S.length(); i ++)
            dp[i][0] = 1;
        
        for(int i = 1; i <= S.length(); i ++){
            for(int j = 1; j <= T.length(); j ++){
                dp[i][j] = dp[i - 1][j];
                if(S.charAt(i - 1) == T.charAt(j - 1)){
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[S.length()][T.length()];
    }
}