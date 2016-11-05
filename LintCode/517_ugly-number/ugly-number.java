/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/ugly-number
@Language: Java
@Datetime: 16-10-12 03:02
*/

public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        // Write your code here
                if(num <= 0)    return false;
        if(num == 1)    return true;
        if(num % 5 == 0 && isUgly(num / 5)) return true;
        if(num % 3 == 0 && isUgly(num / 3)) return true;
        if(num % 2 == 0 && isUgly(num / 2)) return true;
        
        return false;
    }
}