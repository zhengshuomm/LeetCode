/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/o1-check-power-of-2
@Language: Java
@Datetime: 16-10-30 01:31
*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if(n == 0 || n == Integer.MIN_VALUE) return false;
        return (n & (n - 1)) == 0;
    }
};