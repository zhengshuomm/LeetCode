/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Java
@Datetime: 16-10-28 02:55
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if(source == null || target == null || source.length() - target.length() < 0)
            return -1;
        for(int i = 0 ; i <= source.length() - target.length() ; i ++){
            int j = 0;
            for( ; j < target.length() ; j ++){
                if(source.charAt(i + j) != target.charAt(j))
                    break;
            }
            if(j ==  target.length()){
                return i;
            }
        }
        return -1;
    }
}