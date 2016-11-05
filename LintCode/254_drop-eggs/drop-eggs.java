/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/drop-eggs
@Language: Java
@Datetime: 16-10-23 22:38
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int dropEggs(int n) {
        // Write your code here
        long ans = 0;
        for (int i = 1; ; ++i) {
            ans += (long)i;
            if (ans >= (long)n)
                return i;
        }
    }
}