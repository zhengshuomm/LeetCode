/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/fast-power
@Language: Java
@Datetime: 16-10-30 20:38
*/

class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        long c = a;
        if( n == 0)
            return 1 % b;
        if(n == 1)
            return a % b;
        long product = fastPower(a, b, n / 2);
        product = (product * product) % b;
        if (n % 2 == 1) {
            product = (product * a) % b;
        }
        return (int) product;
    }
};
