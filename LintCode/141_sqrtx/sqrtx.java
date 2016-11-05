/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 16-10-30 00:07
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        long high = x;
        long low = 0;
        while (low <= high){
            long mid = (low + high) / 2;
            if (mid * mid <=x && (mid + 1) * (mid + 1) > x){
                return (int) mid;
            }else if (mid * mid < x){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}