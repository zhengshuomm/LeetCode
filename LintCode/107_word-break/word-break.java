/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Java
@Datetime: 16-09-19 03:18
*/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        if(s == null) return true;
        
        boolean [] dp = new boolean [s.length() + 1];
        dp[0] = true;
        int max = getMaxLength(dict);
        for(int i = 1; i <= s.length() ; i ++){
            for(int j = 1 ; j <= max && j <= i ; j ++){
                if(dp[i - j]){
                    if(dict.contains(s.substring(i- j, i))){
                        dp[i] = true; 
                        break;
                    }
                } 
            }
        }
        
        return dp[s.length()];
    } 
    
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}