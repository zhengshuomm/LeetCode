/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/flip-bits
@Language: Java
@Datetime: 16-10-30 01:28
*/

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int sum = 0;
        for(int i = 0 ; i < 32; i ++){
            if (((a & (1 << i)) ^ (b & (1 << i))) != 0 ){
                sum ++;
            }
        }
        return sum;
    }
};
