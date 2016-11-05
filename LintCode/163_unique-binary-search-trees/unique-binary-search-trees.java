/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/unique-binary-search-trees
@Language: Java
@Datetime: 16-10-30 02:12
*/

public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        if(n == 0) return 1;
        int [] dp = new int [n + 1];
        dp[0] = 1;
        for(int i = 1 ; i <=n ; i ++){
            for(int j = 0; j < i ; j ++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}