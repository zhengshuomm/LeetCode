/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/longest-common-prefix
@Language: Java
@Datetime: 16-10-29 01:47
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String str = strs[0];
        int j = 0;
    
        while (j < str.length()){
            for (int i = 0 ; i < strs.length; i ++){
                char c = str.charAt(j);
                if (j >= strs[i].length() || (j < strs[i].length() && c != strs[i].charAt(j))){
                    return str.substring(0, j);
                }
            }
            j ++;
        }
        return str.substring(0, j);
    }
}
