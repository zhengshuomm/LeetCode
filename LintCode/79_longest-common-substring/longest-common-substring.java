/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/longest-common-substring
@Language: Java
@Datetime: 16-09-21 01:02
*/

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        int max = 0;
        for (int i = 1 ; i <= A.length() ; i ++){
            for (int j = 1 ; j <= B.length() ; j ++){
                if (A.charAt(i - 1 ) == B.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}
