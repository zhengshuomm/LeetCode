/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/delete-digits
@Language: Java
@Datetime: 16-10-31 01:23
*/

public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if(A == null || A.length() == 0)
            return null;
        StringBuilder str = new StringBuilder(A);
        for(int i = 0 ; i < k ; i++){
            int m = findPeak(str);
            str.deleteCharAt(m);
        }
        while (str.length() > 1 && str.charAt(0) == '0'){
            str.deleteCharAt(0);
        }
        return str.toString();
    }
    
    public int findPeak(StringBuilder str){
        int i = 0;
        while (i < str.length() - 1){
            if (i == 0 && str.charAt(i) > str.charAt(i + 1)){
                return i;
            }else if (i != 0 &&  str.charAt(i) > str.charAt(i + 1) &&  str.charAt(i) >= str.charAt(i - 1)){
                return i;
            }
            i ++;
        }
        return i;
    }
}


// 178 09   1
// 1760897