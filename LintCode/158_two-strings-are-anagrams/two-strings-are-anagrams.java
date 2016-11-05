/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/two-strings-are-anagrams
@Language: Java
@Datetime: 16-10-28 02:34
*/

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if(s == null && t == null)
            return true;
        if(s == null || t == null || s.length() != t.length())
            return false; 
        int [] count = new int [256];
        for(int i = 0 ; i < s.length() ; i ++){
            count[s.charAt(i)] ++;
        }
        
        for(int i = 0 ; i < t.length() ; i ++){
            if( -- count[t.charAt(i)] < 0)
                return false;
        }
        return true;
        
    }
};