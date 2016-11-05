/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/wildcard-matching
@Language: Java
@Datetime: 16-09-23 04:37
*/

public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if(s == null || p == null)
            return false;
        
        boolean [][] dp = new boolean [s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int j = 1 ; j <= p.length() ; j ++){
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        for(int i = 1 ; i <= s.length() ; i ++){
            for(int j = 1 ; j <= p.length() ; j ++){
                if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }else if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}