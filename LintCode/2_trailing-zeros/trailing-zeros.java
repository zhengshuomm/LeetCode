/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/trailing-zeros
@Language: Java
@Datetime: 16-10-30 02:07
*/

class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        long result = 0;
        while(n > 0){
            result += n / 5;
            n = n / 5;
        }
        return result;
    }
};
