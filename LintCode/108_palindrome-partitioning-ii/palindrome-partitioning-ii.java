/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning-ii
@Language: Java
@Datetime: 16-09-20 02:37
*/

public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if(s == null || s.length() == 0)
            return 0;
            
        //substring(i, j) is p or not    
        boolean [][] isPalindrom = getPalindrom(s);
    
        //前i个最少可以切割为几个字符串
        int [] dp = new int [s.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= s.length(); i ++){
            for(int j = 0 ; j < i ; j ++){
                //i - 1
                if(isPalindrom[j][i - 1]){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[s.length()] - 1;
        
    }
    
    private boolean [][] getPalindrom(String s){
        boolean [][] isPalindrom = new boolean[s.length()][s.length()];
        
        for(int i = 0 ; i < s.length(); i ++){
            isPalindrom[i][i] = true;
        }
        for(int i = 0 ; i < s.length() - 1; i ++){
            isPalindrom[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        
        for(int len = 2; len < s.length() ; len ++){
            for(int start = 0 ; start + len < s.length(); start ++){
                isPalindrom[start][start + len] = isPalindrom[start + 1][start + len - 1] && s.charAt(start) == s.charAt(start + len);
            }
        }
        
        return isPalindrom;
    }
}