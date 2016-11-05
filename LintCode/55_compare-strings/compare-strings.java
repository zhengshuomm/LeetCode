/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/compare-strings
@Language: Java
@Datetime: 16-10-28 02:44
*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if(B == null || B.length() == 0) return true;
        if(A == null || A.length() == 0) return false;
        int [] count = new int [256];
        for(int i = 0 ; i < A.length() ; i ++){
            count[A.charAt(i)] ++ ; 
            
        }
        
        for(int i = 0 ; i < B.length() ; i ++){
            if( -- count[B.charAt(i)] < 0){
                return false;
            }
        }
        return true;
    }
}